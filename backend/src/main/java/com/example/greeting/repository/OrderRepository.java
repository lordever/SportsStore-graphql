package com.example.greeting.repository;

import com.example.greeting.jpaModel.JpaSalesOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<JpaSalesOrder, Integer> {
}
