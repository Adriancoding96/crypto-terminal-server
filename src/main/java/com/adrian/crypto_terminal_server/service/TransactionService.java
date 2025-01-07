package com.adrian.crypto_terminal_server.service;

import com.adrian.crypto_terminal_server.record.TransactionRecord;

public interface TransactionService {

  boolean sendNewTransaction(TransactionRecord record);  

}
