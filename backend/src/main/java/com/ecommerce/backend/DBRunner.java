package com.ecommerce.backend;

import com.ecommerce.backend.model.*;
import com.ecommerce.backend.repository.*;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DBRunner implements CommandLineRunner{
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductSellerPriceRepository priceRepository;

	
	@Override
	public void run(String... args) throws Exception {
		
	}
}
