package com.adrian.crypto_terminal_server.mapper;

import com.adrian.crypto_terminal_server.model.Transaction;
import com.adrian.crypto_terminal_server.record.TransactionRecord;

import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

  public Transaction toTransaction(TransactionRecord record) {
    return null;
  }

  public TransactionRecord toRecord(Transaction transaction) {
    return null;
  }
  
}
