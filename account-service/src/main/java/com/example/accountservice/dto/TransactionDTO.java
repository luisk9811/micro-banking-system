package com.example.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table("transactions")
public class TransactionDTO {
  @Id
  private Long id;
  private String type;
  private Long accountId;
  private BigDecimal amount;
  private String description;
  private LocalDateTime timestamp;
}
