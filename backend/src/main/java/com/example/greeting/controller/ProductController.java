package com.example.greeting.controller;

import com.example.greeting.jpaModel.JpaProduct;
import com.example.greeting.model.Product;
import com.example.greeting.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public Iterable<JpaProduct> products() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<JpaProduct> get(@PathVariable Integer id){
        return productRepository.findById(id);
    }

    @PostMapping
    public JpaProduct save(@RequestBody JpaProduct newProduct){
        return productRepository.save(newProduct);
    }

    @PutMapping("/{id}")
    public JpaProduct update(@RequestBody Product newProduct, @PathVariable Integer id){
        return updateProduct(newProduct, id);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Integer id){
        productRepository.deleteById(id);
        return HttpStatus.OK;
    }

    private JpaProduct updateProduct(Product newProduct, Integer id){
        return productRepository.findById(id)
                .map(product -> {
                    product.setCategory(newProduct.getCategory());
                    product.setDescription(newProduct.getDescription());
                    product.setName(newProduct.getName());
                    product.setPrice(newProduct.getPrice());
                    return productRepository.save(product);
                }).get();
    }
}
