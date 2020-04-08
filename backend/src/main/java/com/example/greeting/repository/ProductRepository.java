package com.example.greeting.repository;

import com.example.greeting.jpaModel.JpaProduct;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<JpaProduct, Integer> {
}
