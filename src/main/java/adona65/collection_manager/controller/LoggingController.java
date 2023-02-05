package adona65.collection_manager.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import adona65.collection_manager.entity.AuthoritiesEntity;
import adona65.collection_manager.entity.UsersEntity;
import adona65.collection_manager.repository.AuthoritiesRepository;
import adona65.collection_manager.repository.UsersRepository;

/**
 * Controller of all services for logging and registration of users.
 * 
 * @author adona65
 */
@RestController // Combine @Controller and @ResponseBody. 
public class LoggingController {
    
	private final PasswordEncoder passwordEncoder;
	
	private final UsersRepository usersRepository;
	private final AuthoritiesRepository authoritiesRepository;
	
    private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);
    
	LoggingController(UsersRepository usersRepository, AuthoritiesRepository authoritiesRepository, PasswordEncoder passwordEncoder) {
		this.usersRepository = usersRepository;
		this.authoritiesRepository = authoritiesRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	/**
	 * Send bake informations about logged user.
	 */
	@GetMapping("/principal")
	public Principal retrievePrincipal(Principal principal) {
		logger.info("Called : LoggingController/principal");
		return principal;
	}

	/**
	 * Create a new user in database if a user with same name don't already exist.
	 * 
	 * @param usersEntity The user to create.
	 * 
	 * @return A JSON formated response indicating if user was created or not :<br/>
	 * <ol>
	 * <li>created : true is user was created, false otherwise.</li>
	 * <li>message : give details about user creation success or failure.</li>
	 * </ol>
	 */
	@PostMapping("/register")
    public Map<String, Object> registerUSer(@RequestBody UsersEntity usersEntity) {
    	logger.info("Called : LoggingController/registerUSer");
    	
    	Map<String, Object> response = new HashMap<String, Object>();
    	
    	if(this.usersRepository.countByUsername(usersEntity.getUsername()) != 0) {
    		response.put("created", false);
    		response.put("message", "User with this name already exist.");
    	} else {
    		AuthoritiesEntity authoritiesEntity = new AuthoritiesEntity(usersEntity.getUsername() , "USER");
        	authoritiesRepository.save(authoritiesEntity);
        	
        	usersEntity.setPassword(this.passwordEncoder.encode(usersEntity.getPassword()));
        	usersEntity.setEnabled(true);
        	
        	this.usersRepository.save(usersEntity);
        	
        	response.put("created", true);
        	response.put("message", "User created.");
    	}
    	
    	return response;
	}
}
