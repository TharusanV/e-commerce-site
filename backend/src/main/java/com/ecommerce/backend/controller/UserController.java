package com.ecommerce.backend.controller;
import java.util.List;
import java.util.Optional;

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

import com.ecommerce.backend.dto.UserPostDTO;
import com.ecommerce.backend.model.User;
import com.ecommerce.backend.service.UserService;


@RestController  
public class UserController {
	
	@Autowired
	UserService userService;

	// Get All Users
    @GetMapping("/user")
    public List<User> getUsers() {
        return userService.getUsers();
    }
    
    //Post
    @PostMapping("/user")
    public ResponseEntity<Optional<User>> addUser(@RequestBody UserPostDTO newUserDTO) {
    	
    	if (newUserDTO.getFirstName()==null || newUserDTO.getSurname()==null || newUserDTO.getEmail()==null || newUserDTO.getPassword()==null || newUserDTO.getUserType() == null) {
            return new ResponseEntity<>(Optional.ofNullable(null), HttpStatus.BAD_REQUEST);
        }
    	
    	User newUser = new User(newUserDTO.getFirstName(), newUserDTO.getSurname(), newUserDTO.getEmail(), newUserDTO.getPassword(), newUserDTO.convertType());
    	
    	userService.addUser(newUser);
    	
    	return new ResponseEntity<>(Optional.ofNullable(newUser),HttpStatus.CREATED);
    }
	 
    
    // Get User by ID
    @GetMapping("/user/{userID}")
    public Optional<User> getUserByUserID(@PathVariable(value = "userID") Long userID) {
        return userService.findByUserID(userID);
    }
    
    //Get User by Email
    @GetMapping("/user/findByEmail")
    public Optional<User> getUserByEmail(@RequestParam String email) {
    	return Optional.ofNullable(userService.findUserByEmail(email));
    }

}
