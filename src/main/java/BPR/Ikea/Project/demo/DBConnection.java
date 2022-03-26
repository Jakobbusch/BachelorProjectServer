package BPR.Ikea.Project.demo;

import org.json.simple.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Configuration
public class DBConnection {


    JSONObject record = new JSONObject();
    public void readDataBase() throws Exception{
        try{

            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://b71f9c84952672:c5fcf155@eu-cdbr-west-02.cleardb.net:3306/heroku_ed5823d8c16859d","b71f9c84952672","c5fcf155");

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select VarTest FROM testtable");
            while(rs.next())
                record.put("VarTest", rs.getString("VarTest"));




            con.close();
        }catch(Exception e)
        { System.out.println(e);}
}
}


