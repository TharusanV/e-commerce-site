package com.ecommerce.backend.security;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.model.User;
import com.ecommerce.backend.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{ 
      User currentUser = repository.findByEmail(email);
      
      if (currentUser!=null) {
    	  //System.out.println(currentUser.getEmail());
      
    	  List<GrantedAuthority> authorities = new ArrayList<>();
    	  authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    	 
    	  UserDetails user = new org.springframework.security.core
              .userdetails.User(email, currentUser.getPassword()
              , true, true, true, true, 
              authorities);
    	  
          return user;
      }else {
    	  throw new UsernameNotFoundException("User not authorized.");
      }
    }
    
}

/*

The UserDetailsServiceImpl class is an implementation of Spring Security's UserDetailsService interface. 
It is responsible for retrieving user information from a data source (a database) and returning it in a format that Spring Security can use for authentication and authorization.

Implements UserDetailsService:
The class implements the UserDetailsService interface, which requires the implementation of the method loadUserByUsername(String username). This method is called by Spring Security to load user details during the authentication process. 

Dependency Injection:
@Autowired: This annotation injects the UserRepository dependency, which is used to interact with the data source (e.g., database) to retrieve user details.
UserRepository repository: This repository is assumed to have a method findByEmail(String email) that fetches a user object based on the email. This is likely a custom method in a UserRepository interface that extends JpaRepository.

loadUserByUsername(String email) Method:
Purpose: The method is responsible for loading a user's details from the database using the an email address as a username.
Steps:
	Fetching User: User currentUser = repository.findByEmail(email); - This line queries the UserRepository for a user entity by the email paramater.
	
	Check if User Exists - If the user is found (currentUser != null), it proceeds with authentication logic. If the user is not found, a UsernameNotFoundException is thrown, indicating the user does not exist.
	
	Granting Roles - List<GrantedAuthority> authorities = new ArrayList<>();: - GrantedAuthority represents an authority granted to the user. In this case, the user is granted the role "ROLE_USER".
	
	Creating UserDetails - UserDetails user = new org.springframework.security.core.userdetails.User(...): - This creates a UserDetails object, which is a core interface in Spring Security. It holds the user's email, password, and additional details required for authentication.
		The constructor parameters are:
			- email: The email of the user.
			- currentUser.getPassword(): The hashed password retrieved from the database. 
			- true, true, true, true: These boolean values indicate whether the user account is enabled, non-expired, non-locked, and credentials are non-expired.
			- authorities: The list of roles/authorities the user has.
	
	Returning UserDetails - This method returns the UserDetails object, which Spring Security uses to authenticate the user and manage session information.
	
	Exception Handling - If the user is not found in the database (currentUser == null), a UsernameNotFoundException is thrown with the message "User not authorized.".

Summary:
The UserDetailsServiceImpl class provides a way to load user details from a repository (database) using an email address. 
It converts the user entity from the database into a UserDetails object that Spring Security can use to manage authentication. 
If the user is found, their details, including the roles, are returned; if not, an exception is thrown to indicate that the user is unauthorized.

*/