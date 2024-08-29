package com.ecommerce.backend.repository;

import com.ecommerce.backend.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Long>{
	User findByEmail(String email);
}

