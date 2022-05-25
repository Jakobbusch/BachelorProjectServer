package BPR.Ikea.Project.demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {

    private final DBConnection dbConnection;

    final private String Prod = "https://bachelor-project-admin.herokuapp.com";
    final private String test = "https://localhost:3000";

    @Autowired
    public Controller(DBConnection dbConnection) {

        this.dbConnection = dbConnection;
    }

    // https://batchelor-project-ikea.herokuapp.com/products
    // @CrossOrigin(origins = "https://localhost:3000")
    // @CrossOrigin(origins = "https://bachelor-project-admin.herokuapp.com")
    @CrossOrigin(origins = Prod)
    @GetMapping("/products")
    public ArrayList<Product> getProductList() throws Exception {

        return dbConnection.getProductsFromDB();

    }

    @CrossOrigin(origins = Prod)
    @GetMapping("/instructions/{id}")
    public ArrayList<Instruction> getInstructions(@PathVariable("id") int id) throws Exception {

        return dbConnection.instructionsInDB(id);

    }

    //@CrossOrigin(origins = "https://bachelor-project-admin.herokuapp.com")
    @CrossOrigin(origins = Prod)
    @GetMapping(value = "/admin/{admin}")
    public Boolean adminLogin(@PathVariable("admin") String adminString) throws Exception {

        System.out.println(adminString);

        ObjectMapper objectMapper = new ObjectMapper();

        Admin admin = objectMapper.readValue(adminString, Admin.class);

        return dbConnection.loginCheckInDB(admin);

    }

    @CrossOrigin(origins = Prod)
    @PostMapping(value = "/updateProducts")
    public void updateProducts(@RequestBody ArrayList<Product> products) throws Exception{
        System.out.println(products);
    }

}
