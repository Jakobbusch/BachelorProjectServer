package BPR.Ikea.Project.demo;

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
//mysql://b71f9c84952672:c5fcf155@eu-cdbr-west-02.cleardb.net/heroku_ed5823d8c16859d?reconnect=true

    public List<String> sqlTest;

    public void readDataBase() throws Exception{
        try{

            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://b71f9c84952672:c5fcf155@eu-cdbr-west-02.cleardb.net:3306/heroku_ed5823d8c16859d","b71f9c84952672","c5fcf155");

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select VarTest FROM testtable");
            while(rs.next())

            sqlTest.add(rs.getString(1));

                //sqlTest.add(rs.getString())
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e)
        { System.out.println(e);}
}
}


