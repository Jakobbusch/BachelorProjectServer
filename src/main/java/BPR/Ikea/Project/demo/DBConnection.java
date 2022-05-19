package BPR.Ikea.Project.demo;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Configuration
public class DBConnection {


    private ArrayList <Product> productArrayList = new ArrayList();
    private String password;
    private boolean adminBool = false;
    private Connection con;
    private ArrayList<Instruction> instructions;


    public boolean loginCheckInDB(Admin admin) throws Exception {


        con = DriverManager.getConnection(
                "jdbc:mysql://d5mcw7cvheivyqp9:nyxzx8czn4kekwn0@i54jns50s3z6gbjt.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/lsixgbt8anazl3cm","d5mcw7cvheivyqp9","nyxzx8czn4kekwn0");
                                //mysql://b71f9c84952672:c5fcf155@eu-cdbr-west-02.cleardb.net:3306/heroku_ed5823d8c16859d           b71f9c84952672","c5fcf155"

        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM admin WHERE adminUsername ='"+admin.getUsername()+"'");

        System.out.println("Admin: "+admin.getPassword());
        while (rs.next()){
            password = rs.getString("adminPassword");
        }

        if (admin.getPassword().equals(password)){
            adminBool = true;
        }
        else {
            adminBool = false;
        }


        con.close();
        System.out.println(adminBool);
        return adminBool;
    }

    public ArrayList<Product> getProductsFromDB() throws Exception{

        con = DriverManager.getConnection(
                "jdbc:mysql://d5mcw7cvheivyqp9:nyxzx8czn4kekwn0@i54jns50s3z6gbjt.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/lsixgbt8anazl3cm","d5mcw7cvheivyqp9","nyxzx8czn4kekwn0");
        //mysql://b71f9c84952672:c5fcf155@eu-cdbr-west-02.cleardb.net:3306/heroku_ed5823d8c16859d           b71f9c84952672","c5fcf155"

        productArrayList.clear();


        Statement stmt=con.createStatement();;
        ResultSet rs=stmt.executeQuery("select * from products INNER JOIN qrcode ON products.productID = qrcode.productID");
        Statement stmt2=con.createStatement();;
        ResultSet rsAssembly=stmt2.executeQuery("select * from products INNER JOIN assembly ON products.productID = assembly.productID");
        Statement stmt3=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);;
        ResultSet rsInstructions=stmt3.executeQuery("select * from assembly INNER JOIN instruction ON assembly.assemblyID = instruction.assemblyID");

        while(rs.next() && rsAssembly.next()){

            instructions = new ArrayList<>();
                rsInstructions.beforeFirst();
                while (rsInstructions.next() ){
                    if (rsInstructions.getInt("assemblyID") == rsAssembly.getInt("assemblyID")){
                        instructions.add(new Instruction(rsInstructions.getInt("instructionID"),rsInstructions.getInt("stepNumber"),rsInstructions.getString("instructionText")));
                    }
                }



            Assembly assembly = new Assembly(rsAssembly.getInt("assemblyID"),rsAssembly.getString("webGLaddress"),
                   rsAssembly.getInt("averageBuildTime"),rsAssembly.getInt("buildDifficulty"),instructions);
            Product product = new Product(rs.getInt("productID"),
                    rs.getString("productName"),
                    rs.getString("productType"),
                    rs.getDouble("productPrice"),
                    rs.getDouble("productWidth"),
                    rs.getDouble("productHeight"),
                    rs.getDouble("productWeight"),
                    rs.getString("productImage"),
                    rs.getInt("productPartAmount"),
                    rs.getString("productColor"),
                    rs.getString("productPlanImage"),
                    rs.getInt("qrcodeID"),assembly

            );

            productArrayList.add(product);

            System.out.println(product.getAssembly().getInstructions());
            }
        con.close();
           return productArrayList;

        }

}



