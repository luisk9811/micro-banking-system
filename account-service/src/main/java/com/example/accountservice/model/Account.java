package com.example.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table("accounts")
public class Account {
  @Id
  private Long id;
  private String accountNumber;
  private Long bankId;
  private String accountType;
  private BigDecimal balance;
  private String status;
}
