package BPR.Ikea.Project.demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {

    private final DBConnection dbConnection;
    public Admin admin;

    @Autowired
    public Controller(DBConnection dbConnection) {

        this.dbConnection = dbConnection;
    }

    // http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hej fra hello world!! ";
    }

    // https://batchelor-project-ikea.herokuapp.com/products
  //  @CrossOrigin(origins = "https://bachelor-project-admin.herokuapp.com")
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/products")
    public ArrayList<Product> productList() throws Exception {

        return dbConnection.productsDB();

    }
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/test/{admin}")
    public Boolean test(@PathVariable("admin") String adminString) throws Exception {

        admin = new Admin();
        ObjectMapper objectMapper = new ObjectMapper();

        Admin admin = objectMapper.readValue(adminString, Admin.class);
     //   String test =  "{\"message\":\"" + "message" + "\"}";
        return dbConnection.LoginCheckInDB(admin);

    }
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping(value = "/admin/{admin}")
    public Boolean AdminLogin(@PathVariable("admin") String adminString) throws Exception {


        System.out.println(adminString);

        admin = new Admin();
        ObjectMapper objectMapper = new ObjectMapper();

        Admin admin = objectMapper.readValue(adminString, Admin.class);


       // System.out.println(admin.getAdminPassword());
        return dbConnection.LoginCheckInDB(admin);

    }

}
