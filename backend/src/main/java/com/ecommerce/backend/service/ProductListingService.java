package com.ecommerce.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.model.Product;
import com.ecommerce.backend.model.ProductListing;
import com.ecommerce.backend.repository.ProductRepository;
import com.ecommerce.backend.repository.ProductListingRepository;
import com.ecommerce.backend.repository.UserRepository;
import com.ecommerce.backend.model.User;

@Service
public class ProductListingService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductListingRepository productListingRepository;
    @Autowired
    private UserRepository userRepository;
    
	public ProductListingService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<ProductListing> getProductSellerPrices() {
		return (List<ProductListing>) productListingRepository.findAll();
	}

	public void addProductSellerPrice(ProductListing newProductSellerPrice) {
		productListingRepository.save(newProductSellerPrice);
	}
	
	
    public List<ProductListing> getProductSellerPriceBySeller(Long sellerId) {
        //User seller = userRepository.findById(sellerId).orElseThrow(() -> new RuntimeException("Seller not found"));
        return productListingRepository.findBySeller(sellerId);
    }
    
}
