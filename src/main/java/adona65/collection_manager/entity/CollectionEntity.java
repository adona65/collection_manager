package adona65.collection_manager.entity;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Represent a "collection" table into database.<br/>
 * The table is automatically created at startup because of "spring.jpa.hibernate.ddl-auto=update" into "application.properties".
 * 
 * @author adona65
 */
@Entity
@Table(name = "collection")
public class CollectionEntity {
 
	@Id
    @Column(nullable = false)
    private Integer id;
	
    @Column(nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String name;
    
    @OneToMany(targetEntity = ItemEntity.class)
    private ArrayList<ItemEntity> itemsList = new ArrayList<ItemEntity>();
 
    public CollectionEntity() {}

    public CollectionEntity(Integer id, String username , String name, ArrayList<ItemEntity> itemsList) {
    	this.id = id;
    	this.username  = username ;
    	this.name = name;
    	this.itemsList = itemsList;
	}

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<ItemEntity> getItemsList() {
		return itemsList;
	}
}
