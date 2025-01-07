package com.adrian.crypto_terminal_server.controller;

import com.adrian.crypto_terminal_server.record.TransactionRecord;
import com.adrian.crypto_terminal_server.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RabbitTestController {

  private final TransactionService transactionService;
 
  @Autowired
  public RabbitTestController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @PostMapping
  public void testRabbitMQ() {
    transactionService.sendNewTransaction(new TransactionRecord(null, null, null, null, null, null, null));
  }
  
}
