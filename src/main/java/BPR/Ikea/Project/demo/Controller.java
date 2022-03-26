package BPR.Ikea.Project.demo;


import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    DBConnection db;

    // http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hej fra hello world!! ";
    }

    // https://batchelor-project-ikea.herokuapp.com/
    @GetMapping("/")
    public JSONObject hello(){
        return db.record;
    }


}
