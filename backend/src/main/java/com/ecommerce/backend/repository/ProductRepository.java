package com.ecommerce.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.backend.model.Product;

/*Basic CRUD operations such as save, findById, delete, and findAll are automatically 
 * provided by the repository interface without you needing to define them.*/

public interface ProductRepository extends CrudRepository<Product,Long>{

}
