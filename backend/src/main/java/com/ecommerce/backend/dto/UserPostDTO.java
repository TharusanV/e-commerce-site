package com.ecommerce.backend.dto;

import com.ecommerce.backend.UserType;

public class UserPostDTO {
	String firstName;
	String surname;
	String email;
	String password;
	Boolean userType[];
	
	public UserPostDTO(String firstName, String surname, String email, String password, Boolean[] buyer_seller) {
		super();
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.userType = buyer_seller;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean[] getUserType() {
		return userType;
	}

	public void setUserType(Boolean[] userType) {
		this.userType = userType;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType convertType() {
		
		if(this.userType == null || (this.userType[0]==false && this.userType[1]==false))
			return UserType.NONE;
		
		if(this.userType[0]==true && this.userType[1]==false)
			return UserType.BUYER;
		
		if(this.userType[0] == false && this.userType[1]== true)
			return UserType.SELLER;
	
		return UserType.BOTH;
		
		
	}
}
