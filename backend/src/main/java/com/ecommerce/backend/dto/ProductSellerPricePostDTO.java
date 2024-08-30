package com.ecommerce.backend.dto;

import java.math.BigDecimal;

import com.ecommerce.backend.model.Product;
import com.ecommerce.backend.model.User;

public class ProductSellerPricePostDTO {
	
    private Long productId;   // Only pass the product ID
    private Long sellerId;    // Only pass the seller ID
    private BigDecimal price;
    private int quantity;

	public ProductSellerPricePostDTO(Long product, Long seller, BigDecimal price, int quantity) {
		super();
		this.productId = product;
		this.sellerId = seller;
		this.price = price;
		this.quantity = quantity;
	}

	public Long getProduct() {
		return productId;
	}

	public void setProduct(Long product) {
		this.productId = product;
	}

	public Long getSeller() {
		return sellerId;
	}

	public void setSeller(Long seller) {
		this.sellerId = seller;
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
	
	

}
