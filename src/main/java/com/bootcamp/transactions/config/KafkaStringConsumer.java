package com.bootcamp.transactions.config;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.bootcamp.transactions.entity.Transaction;
import com.bootcamp.transactions.repository.TransactionsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
public class KafkaStringConsumer {

    Logger logger = LoggerFactory.getLogger(KafkaStringConsumer.class);
    
    @Autowired
	private TransactionsRepository transactionsRepository;

    @KafkaListener(topics = "bootcamp-topic" , groupId = "group_id")
    public void consume(String value) throws JsonMappingException, JsonProcessingException {	
    	String[] parts = value.split(",");
        Transaction transaction = new Transaction(null, parts[1], parts[2], parts[3]
				, parts[4], Double.parseDouble(parts[5]), LocalDateTime.now(), parts[7], Double.parseDouble(parts[8]));
        
        logger.info("Consuming Message {}", transaction);
        transactionsRepository.save(transaction).subscribe();
    }

}