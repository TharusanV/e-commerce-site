package com.ecommerce.backend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.ecommerce.backend.UserType;

@Entity
@Table(name = "Users")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@NotBlank
	String firstName;
	
	@NotBlank
	String surname;
	
	@NotBlank
	@Column(unique=true)
	String email;
	
	@NotBlank
	String password;
	
	UserType userType;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	
	
	 public User() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	 
	 public User(String firstName, String surname, String email, String password, UserType userType) {
		super();
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", surname=" + surname + ", email=" + email
				+ ", password=" + password + ", userType=" + userType + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
		
	
	
}
