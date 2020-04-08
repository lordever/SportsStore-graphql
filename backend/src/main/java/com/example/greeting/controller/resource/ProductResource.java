package com.example.greeting.controller.resource;

import com.example.greeting.graphql.service.GraphQLService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/products")
public class ProductResource {
    @Autowired
    GraphQLService graphqlService;

    @PostMapping
    public ResponseEntity<Object> getAllProducts(@RequestBody String query){
        ExecutionResult execute = graphqlService.getGraphQL().execute(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
