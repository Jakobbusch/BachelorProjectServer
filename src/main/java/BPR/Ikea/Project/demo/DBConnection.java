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

    /**
     *Method to get instructions from database
     * @param id
     * @return instructions
     * @throws Exception
     */
    public ArrayList<Instruction> instructionsInDB(int id) throws Exception{

        instructions = new ArrayList<>();

        try{
            con = DriverManager.getConnection(
                    "jdbc:mysql://d5mcw7cvheivyqp9:nyxzx8czn4kekwn0@i54jns50s3z6gbjt.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/lsixgbt8anazl3cm","d5mcw7cvheivyqp9","nyxzx8czn4kekwn0");
            //mysql://b71f9c84952672:c5fcf155@eu-cdbr-west-02.cleardb.net:3306/heroku_ed5823d8c16859d           b71f9c84952672","c5fcf155"

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from instruction WHERE instruction.assemblyID ='"+ id +"'");

            while (rs.next()){

                Instruction instruction = new Instruction(
                        rs.getInt("instructionID"),
                        rs.getInt("stepNumber"),
                        rs.getString("instructionText")
                );

                instructions.add(instruction);
                return instructions;
            }

            con.close();
        }catch (Exception e){
            System.out.println(e);

        }

        return null;
    }

    /**
     * Method to get admin login from database
     * @param admin
     * @return bool
     * @throws Exception
     */
    public boolean loginCheckInDB(Admin admin) throws Exception {


        try{
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


        }catch (Exception e){
            System.out.println(e);
        }

        return false;
    }

    /**
     * Method to get products from database
     * @return list of products
     * @throws Exception
     */
    public ArrayList<Product> getProductsFromDB() throws Exception{

        int count =0;

        try{
            con = DriverManager.getConnection(
                    "jdbc:mysql://d5mcw7cvheivyqp9:nyxzx8czn4kekwn0@i54jns50s3z6gbjt.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/lsixgbt8anazl3cm","d5mcw7cvheivyqp9","nyxzx8czn4kekwn0");
            //mysql://b71f9c84952672:c5fcf155@eu-cdbr-west-02.cleardb.net:3306/heroku_ed5823d8c16859d           b71f9c84952672","c5fcf155"

            productArrayList.clear();


            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from products INNER JOIN qrcode ON products.productID = qrcode.productID");
            Statement stmt2=con.createStatement();;
            ResultSet rsAssembly=stmt2.executeQuery("select * from products LEFT JOIN assembly ON products.productID = assembly.productID");
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
                        rs.getString("productText"),
                        rs.getString("productImage"),
                        rs.getString("productImage2"),
                        rs.getInt("productPartAmount"),
                        rs.getString("productColor"),
                        rs.getString("productPlanImage"),
                        rs.getInt("qrcodeID"),assembly

                );

                System.out.println(count);
                count++;
                productArrayList.add(product);

                System.out.println(product.getAssembly().getInstructions());
                System.out.println(product);
            }

            con.close();
            return productArrayList;
        }catch (Exception e){
            System.out.println(e);
        }

           return null;

        }

    /**
     * Method to update products in database
     * @param p
     * @throws Exception
     */
    public void updateProductsInDB(ArrayList<Product> p) throws Exception{

        try{
            con = DriverManager.getConnection(
                    "jdbc:mysql://d5mcw7cvheivyqp9:nyxzx8czn4kekwn0@i54jns50s3z6gbjt.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/lsixgbt8anazl3cm","d5mcw7cvheivyqp9","nyxzx8czn4kekwn0");

            Statement stmt=con.createStatement();


            String sql = "";
            ArrayList<String> t = new ArrayList<>();
            for (int i = 0; i < p.size(); i++) {
                sql ="";
                sql += " UPDATE products SET productName = '" +p.get(i).getName() + "' , " + "productType = '" +p.get(i).getType() + "' , " + "productPrice = " +p.get(i).getPrice()
                        + " , " + "productWidth = " + p.get(i).getWidth() + " , " + "productHeight = " + p.get(i).getHeight() + " , " + "productWeight = " + p.get(i).getWeight();

                sql += " WHERE productID = " + p.get(i).getID() + " AND (productName <> '" + p.get(i).getName() + "' OR " + "productType <> '" + p.get(i).getType()+
                        "' OR " + " productPrice <> " + p.get(i).getPrice() + " OR productWidth <> " + p.get(i).getWidth() + " OR productHeight <> " +
                        p.get(i).getHeight() + " OR productWeight <> "+p.get(i).getWeight() +");";
                t.add(sql);
            }
            // Must be executed for each product, as the sql statement gets to long otherwise..
            for (int i = 0; i < t.size(); i++) {
                stmt.executeUpdate(t.get(i));
            }

            con.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }

    /**
     * update build time and set average
     * @param buildTime
     * @throws Exception
     */
    public void updateBuildTimeInDB(String buildTime) throws Exception{

        try{
            con = DriverManager.getConnection(
                    "jdbc:mysql://d5mcw7cvheivyqp9:nyxzx8czn4kekwn0@i54jns50s3z6gbjt.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/lsixgbt8anazl3cm","d5mcw7cvheivyqp9","nyxzx8czn4kekwn0");

            Statement stmt=con.createStatement();
            Statement stmt2=con.createStatement();

            String[] temp = buildTime.split(":");
            System.out.println(temp[0] + " " +temp[1]);
            String sql = "INSERT INTO statistics (assemblyID, singleBuildTime) VALUES (" +temp[1]+","+temp[0]+")";
            String sql2 ="UPDATE assembly SET averageBuildTime = (SELECT AVG(singleBuildTime) FROM statistics WHERE assemblyID ='" + temp[1] +"') WHERE assemblyID ='"+ temp[1] +"'";

            stmt.executeUpdate(sql);
            stmt2.executeUpdate(sql2);
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}



