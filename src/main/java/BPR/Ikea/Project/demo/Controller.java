package BPR.Ikea.Project.demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {

    private final DBConnection dbConnection;

    final private String Prod = "http://bachelor-project-admin.herokuapp.com";
    final private String test = "http://localhost:3000";

    @Autowired
    public Controller(DBConnection dbConnection) {

        this.dbConnection = dbConnection;
    }

    // https://batchelor-project-ikea.herokuapp.com/products
    // @CrossOrigin(origins = "https://localhost:3000")
    // @CrossOrigin(origins = "https://bachelor-project-admin.herokuapp.com")
    @CrossOrigin(origins = test)
    @GetMapping("/products")
    public ArrayList<Product> getProductList() throws Exception {

        return dbConnection.getProductsFromDB();

    }

    //@CrossOrigin(origins = "https://bachelor-project-admin.herokuapp.com")
    @CrossOrigin(origins = test)
    @GetMapping(value = "/admin/{admin}")
    public Boolean adminLogin(@PathVariable("admin") String adminString) throws Exception {

        System.out.println(adminString);

        ObjectMapper objectMapper = new ObjectMapper();

        Admin admin = objectMapper.readValue(adminString, Admin.class);

        return dbConnection.loginCheckInDB(admin);

    }

    @CrossOrigin(origins = test)
    @PutMapping(value="/updateProducts",consumes = "application/json", produces = "application/json")
    public void updateProducts(@RequestBody ArrayList<Product> products) throws Exception{
        System.out.println(products.get(0).getName());
        dbConnection.updateProducts(products);

    }

}
