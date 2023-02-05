package adona65.collection_manager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represent an "authorities" table into database (based on spring security default schema).<br/>
 * The table is automatically created at startup because of "spring.jpa.hibernate.ddl-auto=update" into "application.properties".
 * 
 * @author adona65
 */
@Entity
@Table(name = "authorities")
public class AuthoritiesEntity {
 
	@Id
    @Column(nullable = false)
    private String username;
 
    @Column(nullable = false)
    private String authority;
    
    public AuthoritiesEntity() {}

    public AuthoritiesEntity(String username , String authority) {
    	this.username  = username ;
    	this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

    
}
