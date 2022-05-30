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

    final private String Prod = "https://bachelor-project-admin.herokuapp.com";
    final private String test = "http://localhost:3000";
    final private String ProdUnity = "https://irongarden.github.io";


    /**
     * Constructor for Controller
     * @param dbConnection
     */
    @Autowired
    public Controller(DBConnection dbConnection) {

        this.dbConnection = dbConnection;
    }

    // https://batchelor-project-ikea.herokuapp.com/products
    // @CrossOrigin(origins = "https://localhost:3000")
    // @CrossOrigin(origins = "https://bachelor-project-admin.herokuapp.com")

    /**
     * API for product list
     * @return product list from db
     * @throws Exception
     */
    @CrossOrigin(origins = Prod)
    @GetMapping("/products")
    public ArrayList<Product> getProductList() throws Exception {

        return dbConnection.getProductsFromDB();

    }

    /**
     * API for instruction list
     * @param id
     * @return instruction list from db
     * @throws Exception
     */
    @CrossOrigin(origins = ProdUnity)
    @GetMapping("/instructions/{id}")
    public ArrayList<Instruction> getInstructions(@PathVariable("id") int id) throws Exception {

        return dbConnection.instructionsInDB(id);

    }
    /**
     * API for admin login
     * @param adminString
     * @return bool from db
     * @throws Exception
     */
    //@CrossOrigin(origins = "https://bachelor-project-admin.herokuapp.com")
    @CrossOrigin(origins = Prod)
    @GetMapping(value = "/admin/{admin}")
    public Boolean adminLogin(@PathVariable("admin") String adminString) throws Exception {

        System.out.println(adminString);

        ObjectMapper objectMapper = new ObjectMapper();

        Admin admin = objectMapper.readValue(adminString, Admin.class);

        return dbConnection.loginCheckInDB(admin);

    }
    /**
     * API for update products
     * @param products
     * @throws Exception
     */
    @CrossOrigin(origins = Prod)
    @PutMapping(value="/updateProducts",consumes = "application/json", produces = "application/json")
    public void updateProducts(@RequestBody ArrayList<Product> products) throws Exception{
        System.out.println(products.get(0).getName());
        dbConnection.updateProducts(products);

    }
    //@CrossOrigin(origins = test)
    @CrossOrigin(origins = ProdUnity)
    @PutMapping(value="/updateBuildTime")
    public void updateBuildTime(@RequestBody String data) throws Exception{
        //System.out.println(data);
        dbConnection.updateBuildTime(data);
    }

    //@CrossOrigin(origins = test)
    @GetMapping("/test")
    public String test() throws Exception{
        System.out.println("TESTING :DDD");
        return "Hello";
    }


    @RequestMapping("/Testing")
    public @ResponseBody String greeting() {
        return "This is a test";
    }

}
