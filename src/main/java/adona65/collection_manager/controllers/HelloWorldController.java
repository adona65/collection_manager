package adona65.collection_manager.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller of all services for set up an "Hello World" application.
 * 
 * @author adona65
 */
@RestController // Combine @Controller and @ResponseBody. 
public class HelloWorldController {
    
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    // TODO : Voir comment autoriser l'appel à certains services sans auth malgré spring security.
    @GetMapping("/private")
    public Map<String, Object> securedResource() {
        logger.info("Called : HelloWorldController/private");
        
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello collection's Private World");
        return model;
    }
    
    @GetMapping("/public")
    public Map<String, Object> publicResource() {
        logger.info("Called : HelloWorldController/public");
        
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("content", "You well got public resource.");
        return model;
    }
}
