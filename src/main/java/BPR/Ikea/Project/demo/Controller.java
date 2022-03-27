package BPR.Ikea.Project.demo;


import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {




    // http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hej fra hello world!! ";
    }

    // https://batchelor-project-ikea.herokuapp.com/db
    @GetMapping("/db")
    public String hello(@RequestParam Map<String, Object> db){
            System.out.println(db.toString());

        return db.toString();

    }


}
