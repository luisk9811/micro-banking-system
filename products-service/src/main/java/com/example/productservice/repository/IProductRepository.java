package com.example.productservice.repository;

import com.example.productservice.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends ReactiveCrudRepository<Product, Long> {
}
