package com.ecommerce.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.model.Product;
import com.ecommerce.backend.model.ProductSellerPrice;
import com.ecommerce.backend.repository.ProductRepository;
import com.ecommerce.backend.repository.ProductSellerPriceRepository;
import com.ecommerce.backend.repository.UserRepository;
import com.ecommerce.backend.model.User;

@Service
public class ProductSellerPriceService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductSellerPriceRepository productSellerPriceRepository;
    @Autowired
    private UserRepository userRepository;
    
	public ProductSellerPriceService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<ProductSellerPrice> getProductSellerPrices() {
		return (List<ProductSellerPrice>) productSellerPriceRepository.findAll();
	}

	public void addProductSellerPrice(ProductSellerPrice newProductSellerPrice) {
		productSellerPriceRepository.save(newProductSellerPrice);
	}
	
	
    public List<ProductSellerPrice> getProductSellerPriceBySeller(Long sellerId) {
        //User seller = userRepository.findById(sellerId).orElseThrow(() -> new RuntimeException("Seller not found"));
        return productSellerPriceRepository.findBySeller(sellerId);
    }
    
}
