package BPR.Ikea.Project.demo;


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

    // http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hej fra hello world!! ";
    }

    // https://batchelor-project-ikea.herokuapp.com/products
    @CrossOrigin(origins = "https://bachelor-project-admin.herokuapp.com/:5000")
    @GetMapping("/products")
    public ArrayList<Product> productList() throws Exception {


        return dbConnection.productsDB();

    }


}
