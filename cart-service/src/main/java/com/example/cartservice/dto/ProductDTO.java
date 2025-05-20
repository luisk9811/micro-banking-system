package com.example.cartservice.dto;

public class ProductDTO {
  private Long id;
  private String name;
  private String description;
  private Integer quantity;

  public ProductDTO(Long id, String name, String description, Integer quantity) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.quantity = quantity;
  }

  public ProductDTO() {
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

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
