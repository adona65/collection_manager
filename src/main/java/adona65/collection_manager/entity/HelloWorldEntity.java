package adona65.collection_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represent a "helloworld" table into database.<br/>
 * The table is automatically created at startup because of "spring.jpa.hibernate.ddl-auto=update" into "application.properties".
 * 
 * @author adona65
 */
@Entity
@Table(name = "helloworld")
public class HelloWorldEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    private String name;
 
    private String message;
 
    public HelloWorldEntity() {}

    public HelloWorldEntity(String name, String message) {
    	this.name = name;
    	this.message = message;
	}
    
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
}
