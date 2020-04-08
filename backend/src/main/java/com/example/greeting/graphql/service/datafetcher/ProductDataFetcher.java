package com.example.greeting.graphql.service.datafetcher;

import com.example.greeting.jpaModel.JpaProduct;
import com.example.greeting.repository.ProductRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductDataFetcher implements DataFetcher<JpaProduct> {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public JpaProduct get(DataFetchingEnvironment dataFetchingEnvironment) {
        Integer id = dataFetchingEnvironment.getArgument("id");
        Optional<JpaProduct> result = productRepository.findById(id);
        return result.orElse(null);
    }
}
