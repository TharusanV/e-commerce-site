package com.ecommerce.backend.controller;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.dto.ProductSellerPricePostDTO;
import com.ecommerce.backend.dto.UserPostDTO;
import com.ecommerce.backend.model.Product;
import com.ecommerce.backend.model.ProductSellerPrice;
import com.ecommerce.backend.model.User;
import com.ecommerce.backend.repository.ProductRepository;
import com.ecommerce.backend.repository.UserRepository;
import com.ecommerce.backend.service.ProductSellerPriceService;
import com.ecommerce.backend.service.UserService;

@RestController 
public class ProductSellerPriceController {

	@Autowired
	ProductSellerPriceService productSellerPriceService;
	
	@Autowired
    ProductRepository productRepository;  

    @Autowired
    UserRepository userRepository;       

	// Get All ProductSellerPrice
    @GetMapping("/productSellerPrice")
    public List<ProductSellerPrice> getProductSellerPrice() {
        return productSellerPriceService.getProductSellerPrices();
    }
    
    //Post
    @PostMapping("/productSellerPrice")
    public ResponseEntity<Optional<ProductSellerPrice>> addProductSellerPrice(@RequestBody ProductSellerPricePostDTO newProductSellerPriceDTO) {
    	
    	if (newProductSellerPriceDTO.getSeller()==null || newProductSellerPriceDTO.getProduct()==null || 
    			newProductSellerPriceDTO.getPrice()==null) {
            return new ResponseEntity<>(Optional.ofNullable(null), HttpStatus.BAD_REQUEST);
        }
    	
        Product product = productRepository.findById(newProductSellerPriceDTO.getProduct())
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        
        User seller = userRepository.findById(newProductSellerPriceDTO.getSeller())
                .orElseThrow(() -> new EntityNotFoundException("Seller not found"));
    	
    	ProductSellerPrice newProductSellerPrice = new ProductSellerPrice(product, seller, newProductSellerPriceDTO.getPrice(), newProductSellerPriceDTO.getQuantity());
    	
    	productSellerPriceService.addProductSellerPrice(newProductSellerPrice);
    	
    	return new ResponseEntity<>(Optional.ofNullable(newProductSellerPrice),HttpStatus.CREATED);
    }
    
    //Get all product seller prices by seller
    @GetMapping("/productSellerPrice/{sellerId}")
    public List<ProductSellerPrice> getProductSellerPriceBySeller(@PathVariable(value = "sellerId") long sellerId) {
        return productSellerPriceService.getProductSellerPriceBySeller(sellerId);
    }
    
	
}
