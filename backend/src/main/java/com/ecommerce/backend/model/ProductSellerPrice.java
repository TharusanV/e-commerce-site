package com.ecommerce.backend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.math.BigDecimal;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.ecommerce.backend.UserType;

@Entity
@Table(name = "ProductSellerPrices")
@EntityListeners(AuditingEntityListener.class)
public class ProductSellerPrice implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	Product product;

	@ManyToOne
	@JoinColumn(name = "sellerId")
	User seller;

	BigDecimal price;
	
	int quantity;


	public ProductSellerPrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductSellerPrice(Product product, User seller, BigDecimal price, int quantity) {
		this.product = product;
		this.seller = seller;
		this.price = price;
		this.quantity = quantity;
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

	@Override
	public String toString() {
		return "ProductSellerPrice [id=" + id + ", product=" + product + ", seller=" + seller + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	
	

	 
	
	 

}
