package BPR.Ikea.Project.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Configuration
public class DBConnection {
//mysql://b71f9c84952672:c5fcf155@eu-cdbr-west-02.cleardb.net/heroku_ed5823d8c16859d?reconnect=true

    public void readDataBase() throws Exception{
try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection(
                "jdbc:mysql://b71f9c84952672:c5fcf155@eu-cdbr-west-02.cleardb.net:3306/heroku_ed5823d8c16859d","b71f9c84952672","c5fcf155");
//here sonoo is database name, root is username and password
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select VarTest FROM testtable");
        while(rs.next())
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
        con.close();
    }catch(Exception e){ System.out.println(e);}
}
}


