package com.example.productservice.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("products")
public class Product {
  @Id
  private Long id;
  private String name;
  private String description;
  private Integer stock;

  public Product() {
  }

  public Product(Long id, String name, String description, Integer stock) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.stock = stock;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }
}
