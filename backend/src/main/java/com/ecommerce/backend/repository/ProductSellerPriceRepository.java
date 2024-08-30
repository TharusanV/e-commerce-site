package com.ecommerce.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.backend.model.ProductSellerPrice;
import com.ecommerce.backend.model.User;

/*Basic CRUD operations such as save, findById, delete, and findAll are automatically 
 * provided by the repository interface without you needing to define them.*/

public interface ProductSellerPriceRepository extends CrudRepository<ProductSellerPrice,Long>{
    List<ProductSellerPrice> findBySeller(long sellerId);
   
}
