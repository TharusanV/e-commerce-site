package com.ecommerce.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.dto.ProductPostDTO;
import com.ecommerce.backend.dto.UserPostDTO;
import com.ecommerce.backend.model.Product;
import com.ecommerce.backend.model.ProductListing;
import com.ecommerce.backend.model.User;
import com.ecommerce.backend.service.ProductService;
import com.ecommerce.backend.service.UserService;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

	// Get All Products
    @GetMapping("/productService")
    public List<Product> getProducts() {
        return productService.getProducts();
    }
    
    //Post
    @PostMapping("/productService")
    public ResponseEntity<Optional<Product>> addProduct(@RequestBody ProductPostDTO newProductDTO) {
    	
    	if (newProductDTO.getTitle()==null) {
            return new ResponseEntity<>(Optional.ofNullable(null), HttpStatus.BAD_REQUEST);
        }
    	
    	Product newProduct = new Product(newProductDTO.getTitle());
    	
    	productService.addProduct(newProduct);
    	
    	return new ResponseEntity<>(Optional.ofNullable(newProduct),HttpStatus.CREATED);

    }
	 

}
