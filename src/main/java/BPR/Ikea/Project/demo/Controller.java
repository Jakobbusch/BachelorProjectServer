package BPR.Ikea.Project.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    // http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hej fra hello world!! ";
    }
}
