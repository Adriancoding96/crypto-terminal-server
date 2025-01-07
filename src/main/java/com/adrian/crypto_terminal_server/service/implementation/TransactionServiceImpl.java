package com.adrian.crypto_terminal_server.service.implementation;

import com.adrian.crypto_terminal_server.rabbitmq.TransactionMessagePublisher;
import com.adrian.crypto_terminal_server.record.TransactionRecord;
import com.adrian.crypto_terminal_server.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
 
  private final TransactionMessagePublisher publisher;

  @Autowired
  public TransactionServiceImpl(TransactionMessagePublisher publisher) {
    this.publisher = publisher;
  }

  @Override
  public boolean sendNewTransaction(TransactionRecord record) {
    publisher.sendMessage("Hopefully this works!");
    return true;
  }
  
}
