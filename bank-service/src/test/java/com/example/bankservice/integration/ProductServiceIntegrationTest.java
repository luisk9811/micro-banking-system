//package com.example.productservice.integration;
//
//import com.example.productservice.model.Bank;
//import com.example.productservice.repository.IBankRepository;
//import com.example.productservice.service.BankService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.r2dbc.core.DatabaseClient;
//import org.springframework.test.context.ActiveProfiles;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//@ActiveProfiles("test")
//public class ProductServiceIntegrationTest {
//  @Autowired
//  private BankService productService;
//  @Autowired
//  private IBankRepository productRepository;
//  @Autowired
//  private DatabaseClient databaseClient;
//
//  @BeforeEach
//  void setUp() {
//    this.databaseClient.sql("DELETE FROM products").then().subscribe().dispose();
//  }
//
//
//  @Test
//  void getAllProducts() {
//    Bank product = new Bank(null, "Bank 1", "Description 1", 10);
//    Bank product2 = new Bank(null, "Bank 2", "Description 1", 10);
//
//    productRepository.save(product).block();
//    productRepository.save(product2).block();
//
//    Flux<Bank> products = productService.getAll();
//
//    StepVerifier
//      .create(products)
//      .assertNext(pr -> {
//        assertEquals(product.getName(), pr.getName());
//        assertEquals(11l, pr.getId());
//      })
//      .assertNext(pr -> {
//        assertEquals(product2.getName(), pr.getName());
//        assertEquals(12l, pr.getId());
//      })
//      .verifyComplete();
//  }
//
//  @Test
//  void getById_WithExistingId_ShouldReturnProduct() {
//    Bank product = new Bank(null, "Bank 1", "Description 1", 10);
//
//    productRepository.save(product).block();
//
//    Mono<Bank> products = productService.getById(11l);
//
//    StepVerifier
//      .create(products)
//      .assertNext(pr -> {
//        assertEquals(product.getName(), pr.getName());
//        assertEquals(11l, pr.getId());
//      })
//      .verifyComplete();
//  }
//
//  @Test
//  void getById_WithNotExistingId_ShouldReturnException() {
//    Mono<Bank> products = productService.getById(15l);
//
//    StepVerifier
//      .create(products)
//      .expectError(RuntimeException.class);
//  }
//}
