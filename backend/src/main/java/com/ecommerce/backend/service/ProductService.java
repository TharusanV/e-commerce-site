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
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ProductListingRepository productListingRepository;

    @Autowired
    private UserRepository userRepository;
    
	public ProductService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Product> getProducts() {
		return (List<Product>) productRepository.findAll();
	}
	
	public void addProduct(Product newProduct) {
		productRepository.save(newProduct);
	}
	
}
