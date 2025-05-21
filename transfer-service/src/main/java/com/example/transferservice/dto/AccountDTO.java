package com.example.transferservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
  private Long id;
  private String accountNumber;
  private Long bankId;
  private String accountType;
  private BigDecimal balance;
  private String status;
}
