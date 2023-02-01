package adona65.collection_manager.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import adona65.collection_manager.entity.HelloWorldEntity;
import adona65.collection_manager.exception.ResourceNotFoundException;
import adona65.collection_manager.repository.HelloWorlRepository;

/**
 * Controller of all services for set up an "Hello World" application.
 * 
 * @author adona65
 */
@RestController // Combine @Controller and @ResponseBody. 
public class HelloWorldController {
    
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
    
    private final HelloWorlRepository repository;

	HelloWorldController(HelloWorlRepository repository) {
	    this.repository = repository;
	}
	
    /**
     * Fake service for HelloWorld application.
     */
    @GetMapping("/private")
    public Map<String, Object> securedResource() {
        logger.info("Called : HelloWorldController/private");
        
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello collection's Private World");
        return model;
    }
    
    /**
     * Fake service for HelloWorld application.
     */
    @GetMapping("/public")
    public Map<String, Object> publicResource() {
        logger.info("Called : HelloWorldController/public");
        
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("content", "You well got public resource.");
        return model;
    }
    
    /**
     * Fake service that retrieve data into database for HelloWorld application.
     */
    @GetMapping("/getHelloWorld/{id}")
    public HelloWorldEntity change(@PathVariable Long id) {
    	
    	logger.info("Called : HelloWorldController/getHelloWorld/{id}");
    	HelloWorldEntity person = new HelloWorldEntity();
    	
    	person = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id.toString()));
    	
    	return person;
	}
    
    /**
     * Fake dummy service that generate exception for using generation handling into HelloWorld application.
     */
    @SuppressWarnings("null")
	@GetMapping("/generate_dummy_exception")
    public String generateEx() {
    	
    	logger.info("Called : HelloWorldController/generate_dummy_exception");
    	String myStr = null;
    	myStr.trim();
    	
    	return myStr;
	}
    
    /**
     * Fake service that insert data into database for HelloWorld application.
     */
    @PostMapping("/insertHelloWorld")
    public HelloWorldEntity change(@RequestBody HelloWorldEntity entity) {
    	logger.info("Called : HelloWorldController/insertHelloWorld");
    	
    	return repository.save(entity);
	}
    
}
