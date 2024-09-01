package com.ecommerce.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.ecommerce.backend.ProductType;
import com.ecommerce.backend.UserType;

@Entity
@Table(name = "ProductListing")
@EntityListeners(AuditingEntityListener.class)
public class ProductListing implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "productId", nullable = false)
	Product product;

	@ManyToOne
	@JoinColumn(name = "sellerId", nullable = false)
	User seller;

	@Column(nullable = false)
	BigDecimal price;
	
    @Column(nullable = false)
    @Min(value = 0, message = "Quantity cannot be negative")
	int quantity;
	
	@NotBlank
	String imagePath;
	
	@Column(nullable = false)
	ProductType productType;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;


    // Default constructor
    public ProductListing() {
        super();
    }

    // Constructor
    public ProductListing(Product product, User seller, BigDecimal price, int quantity, String imagePath, ProductType productType) {
        this.product = product;
        this.seller = seller;
        this.price = price;
        this.quantity = quantity;
        this.imagePath = imagePath;
        this.productType = productType;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "ProductListing [id=" + id + ", product=" + product + ", seller=" + seller + ", price=" + price
                + ", quantity=" + quantity + ", productType=" + productType + "]";
    }

	

	 
	
	 

}
