package com.bootcamp.transactions.dto;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

/**
 * Clase de transferencia de datos para la solicitud de Transacciones
 */
@Data
public class TransactionRequestDto {
	private String id;
	private String productType; //AHORRO, C_CORRIENTE, PLAZO_FIJO, CRE_PERSONAL, CRED_EMPRESARIAL, TAR_CRED_PERSONAL, TAR_CRED_EMPRESARIAL
	private String productId;
	private String customerId;
	private String transactionType; //DEPOSITO, RETIRO, PAGO, CONSUMO
	private Double amount;
	private LocalDateTime transactionDate;
	private String customerType;
	private Double balance;
}
