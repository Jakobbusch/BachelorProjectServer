package BPR.Ikea.Project.demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {

    private final DBConnection dbConnection;


    @Autowired
    public Controller(DBConnection dbConnection) {

        this.dbConnection = dbConnection;
    }

    // https://batchelor-project-ikea.herokuapp.com/products
    // @CrossOrigin(origins = "https://bachelor-project-admin.herokuapp.com")
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/products")
    public ArrayList<Product> getProductList() throws Exception {

        return dbConnection.getProductsFromDB();

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/admin/{admin}")
    public Boolean adminLogin(@PathVariable("admin") String adminString) throws Exception {

        System.out.println(adminString);

        ObjectMapper objectMapper = new ObjectMapper();

        Admin admin = objectMapper.readValue(adminString, Admin.class);

        return dbConnection.loginCheckInDB(admin);

    }

}
