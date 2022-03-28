package BPR.Ikea.Project.demo;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Configuration
public class DBConnection {


    ArrayList <testtable> testClasses = new ArrayList();


    public ArrayList<testtable> readDataBase() throws Exception{
            testClasses.clear();
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://b71f9c84952672:c5fcf155@eu-cdbr-west-02.cleardb.net:3306/heroku_ed5823d8c16859d","b71f9c84952672","c5fcf155");

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from testtable");

            while(rs.next()){
                testtable testClass = new testtable(rs.getString("varTest"),
                                                    rs.getInt("intTest"));

                testClasses.add(testClass);


            }
           return testClasses;


        }

}



