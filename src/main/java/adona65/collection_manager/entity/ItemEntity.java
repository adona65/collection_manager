package adona65.collection_manager.entity;

import java.sql.Blob;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represent an "item" table into database.<br/>
 * The table is automatically created at startup because of "spring.jpa.hibernate.ddl-auto=update" into "application.properties".
 * 
 * @author adona65
 */
@Entity
@Table(name = "item")
public class ItemEntity {
 
    @Id
    @Column(nullable = false)
    private Integer id;
    
    @Column(name="collection_id", nullable = false)
    private Integer collectionId;
    
    @Column(nullable = false)
    private String name;
 
    @Column
    private Long price;
    
    @Column(name="buy_date")
    private LocalDate buyDate;
    
    @Column(name="buy_bill")
    private Blob buyBill;
    
 
    public ItemEntity() {}

    public ItemEntity(Integer id, Integer collectionId, String name, Long price, LocalDate buyDate, Blob buyBill) {
    	this.id  = id ;
    	this.collectionId = collectionId;
    	this.name = name;
    	this.price = price;
    	this.buyDate = buyDate;
    	this.buyBill = buyBill;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(Integer collectionId) {
		this.collectionId = collectionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public LocalDate getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(LocalDate buyDate) {
		this.buyDate = buyDate;
	}

	public Blob getBuyBill() {
		return buyBill;
	}

	public void setBuyBill(Blob buyBill) {
		this.buyBill = buyBill;
	}
    
}
