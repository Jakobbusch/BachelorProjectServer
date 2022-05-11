package BPR.Ikea.Project.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BachelorProjectApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BachelorProjectApplication.class, args);





	}
}
