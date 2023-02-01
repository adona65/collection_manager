package adona65.collection_manager.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Configure datasources for the application.
 * 
 * @author @author adona65
 */
@Configuration
public class DataSourceConfiguration {

	@Autowired 
	Environment env;
	
	/**
	 * Tell the application that the datasource will be configured database. Configuration are taken into "application.properties" file.
	 */
	@Bean
	public DataSource dataSource() {
		 return DataSourceBuilder.create()
				 	.url(env.getProperty("db.url"))
				 	.driverClassName(env.getProperty("db.driver"))
				 	.username(env.getProperty("db.username"))
				 	.password(env.getProperty("db.password"))
				 	.build();
	}
}
