package com.ecommerce.backend.repository;

import com.ecommerce.backend.model.User;
import org.springframework.data.repository.CrudRepository;

/*Basic CRUD operations such as save, findById, delete, and findAll are automatically 
 * provided by the repository interface without you needing to define them.*/

public interface UserRepository extends CrudRepository<User,Long>{
	User findByEmail(String email);
}

