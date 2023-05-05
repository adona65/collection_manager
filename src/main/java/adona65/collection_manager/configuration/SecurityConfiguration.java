package adona65.collection_manager.configuration;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configure security for the application (which services are publicly exposed, private...).
 * 
 * @author @author adona65
 */
@Configuration
public class SecurityConfiguration {

	@Autowired
	private DataSource dataSource;
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);
	
	/**
	 * Configure security concernes about http protocole (which services are publicly exposed, private...).
	 * 
	 * @param http Provided by Spring IOC.
	 */
	@Bean
	public SecurityFilterChain configure(HttpSecurity http)  throws Exception {
		logger.info("Will perform all Spring security's configurations.");
		
		http
			// Allow services calls from CORS. To be used alongside with "@CrossOrigin(origins="http://localhost:4200")"
			// annotation on services controllers.
			.cors()
			.and()
			// Beware : order of request matchers is important.
			.authorizeHttpRequests(requests -> requests
				// Specify that requests on given services' pattern + HTTP methods may be called by anyone.
				// TODO : specify services url in a .yml file, not anymore hardcoded.
				.requestMatchers(HttpMethod.POST, "/register").permitAll()
				.requestMatchers(HttpMethod.GET, "/helloworld").permitAll()
				// Specify that requests on given services' pattern + HTTP methods may be called by any authenticated user.
				.requestMatchers(HttpMethod.GET, "/principal", "/user").authenticated()
				// Specify that any other requests are not allowed by anyone.
				.anyRequest().denyAll())
			.httpBasic()
			.and().headers()
				.frameOptions()
				.sameOrigin()
			// TODO : Put only for allowing hello world tests using postman. To remove quickly.
			.and().csrf().disable();
		
		logger.info("Spring security's configurations finished.");
		
		return http.build();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(dataSource);
	}
}
