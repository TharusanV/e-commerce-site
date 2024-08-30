package com.ecommerce.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ecommerce.backend.model.ProductSellerPrice;
import com.ecommerce.backend.model.User;
import com.ecommerce.backend.repository.ProductSellerPriceRepository;
import com.ecommerce.backend.repository.UserRepository;
import com.ecommerce.backend.UserType;
import com.ecommerce.backend.exception.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
    UserRepository userRepository;
	@Autowired
	ProductSellerPriceRepository priceRepository;
	
	public UserService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}

	public void addUser(User newUser) {
		userRepository.save(newUser);
	}

	
    public Optional<User> findByUserID(Long userID) {
        return userRepository.findById(userID);
    }
	
	
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
