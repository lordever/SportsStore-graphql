package com.example.greeting.graphql.service.datafetcher;

import com.example.greeting.jpaModel.JpaProduct;
import com.example.greeting.repository.ProductRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AllProductsDataFetcher implements DataFetcher<Iterable<JpaProduct>>{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<JpaProduct> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return productRepository.findAll();
    }
}
