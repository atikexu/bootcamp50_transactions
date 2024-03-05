package com.bootcamp.transactions.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase de entidad
 */
@Data
@AllArgsConstructor
@Document(collection="transaction")
public class Transaction {
	@Id
	private String id;
	private String productType;
	private String productId;
	private String customerId;
	private String transactionType;
	private Double amount;
	private LocalDateTime transactionDate;
	private String customerType;
	private Double balance;
}
