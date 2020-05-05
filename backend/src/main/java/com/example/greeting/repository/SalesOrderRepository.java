package com.example.greeting.repository;

import com.example.greeting.jpaModel.JpaSalesOrder;
import org.springframework.data.repository.CrudRepository;

public interface SalesOrderRepository extends CrudRepository<JpaSalesOrder, Integer> {
}
