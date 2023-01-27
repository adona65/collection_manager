package adona65.collection_manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http)  throws Exception {
		 logger.info("Will perform all Spring security's configurations.");
		
		http
			// Beware : order of request matchers is important.
			.authorizeHttpRequests(requests -> requests
				// Specify that requests on "/public" services's pattern may be called by anyone.
				.requestMatchers(HttpMethod.GET, "/public").permitAll()
				// Specify that requests on "/private" services's pattern may be called by any authenticated user.
				.requestMatchers(HttpMethod.GET, "/private").authenticated()
				// Specify that any other requests are not allowed by anyone.
				.anyRequest().denyAll())
			.httpBasic();
		
		logger.info("Spring security's configurations finished.");
		
		return http.build();
	}
}
