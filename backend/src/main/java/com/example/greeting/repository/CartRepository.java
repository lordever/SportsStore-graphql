package com.example.greeting.repository;

import com.example.greeting.jpaModel.JpaCart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<JpaCart, Integer> {
}
