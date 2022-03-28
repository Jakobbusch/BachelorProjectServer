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

    // https://batchelor-project-ikea.herokuapp.com/db
    @GetMapping("/db")
    public ArrayList<testtable> testMap() throws Exception {


        return dbConnection.readDataBase();

    }


}
