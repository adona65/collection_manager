package adona65.collection_manager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represent an "user" table into database (based on spring security default schema).<br/>
 * The table is automatically created at startup because of "spring.jpa.hibernate.ddl-auto=update" into "application.properties".
 * 
 * @author adona65
 */
@Entity
@Table(name = "users")
public class UsersEntity {
 
    @Id
    @Column(nullable = false)
    private String username;
 
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private boolean enabled;
 
    public UsersEntity() {}

    public UsersEntity(String username , String password, boolean enabled) {
    	this.username  = username ;
    	this.password = password;
    	this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

    
}
