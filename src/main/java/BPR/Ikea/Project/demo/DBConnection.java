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


    public ArrayList<Product> productsDB() throws Exception{
        productArrayList.clear();
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://b71f9c84952672:c5fcf155@eu-cdbr-west-02.cleardb.net:3306/heroku_ed5823d8c16859d","b71f9c84952672","c5fcf155");

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from products");

            while(rs.next()){
                Product product = new Product(rs.getInt("productID"),
                                              rs.getString("productName"),
                                              rs.getString("productType"),
                                              rs.getDouble("productPrice"),
                                              rs.getDouble("productWidth"),
                                              rs.getDouble("productHeight"),
                                              rs.getDouble("productWeight"));

                productArrayList.add(product);
            }
           return productArrayList;


        }

}



