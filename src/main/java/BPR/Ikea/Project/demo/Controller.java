package BPR.Ikea.Project.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    DBConnection db = new DBConnection();

    // http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hej fra hello world!! ";
    }

    // https://batchelor-project-ikea.herokuapp.com/
    @GetMapping("/")
    public List <String> hello(){
        return db.sqlTest;
    }


}
