package com.ecommerce.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.backend.model.ProduceSellerPrice;
import com.ecommerce.backend.model.User;

public interface ProduceSellerPriceRepository extends CrudRepository<ProduceSellerPrice,Long>{
	 List<ProduceSellerPrice> deleteBySeller(User seller);
}
