package com.ecommerce.backend.dto;

import java.math.BigDecimal;

import com.ecommerce.backend.ProductType;
import com.ecommerce.backend.ProductType;
import com.ecommerce.backend.model.Product;
import com.ecommerce.backend.model.User;

public class ProductListingPostDTO {
	
    private Long productId;   // Only pass the product ID
    private Long sellerId;    // Only pass the seller ID
    private BigDecimal price;
    private int quantity;
    private String imagePath;
    private Boolean productType[];

	public ProductListingPostDTO(Long product, Long seller, BigDecimal price, int quantity, String imagePath, Boolean[] product_type) {
		super();
		this.productId = product;
		this.sellerId = seller;
		this.price = price;
		this.quantity = quantity;
		this.imagePath = imagePath;
		this.productType = product_type;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public ProductType convertType() {
		if(this.productType == null || (this.productType[0]==false && this.productType[1]==false && this.productType[2]==false))
			return ProductType.NONE;
		
		if(this.productType[1]==true && this.productType[0]==false && this.productType[2]==false)
			return ProductType.USED;
		
		if(this.productType[2] == true && this.productType[0]== false && this.productType[1]==false)
			return ProductType.REFURBISHED;
	
		return ProductType.NEW;
	}

}
