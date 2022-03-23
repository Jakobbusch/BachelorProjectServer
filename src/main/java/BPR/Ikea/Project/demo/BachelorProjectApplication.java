package BPR.Ikea.Project.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class BachelorProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BachelorProjectApplication.class, args);

		try{

			Connection con= DriverManager.getConnection(
					"jdbc:mysql://b71f9c84952672:c5fcf155@eu-cdbr-west-02.cleardb.net:3306/heroku_ed5823d8c16859d","b71f9c84952672","c5fcf155");

			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select VarTest FROM testtable");
			while(rs.next())
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			con.close();
		}catch(Exception e){ System.out.println(e);}
	}
}
