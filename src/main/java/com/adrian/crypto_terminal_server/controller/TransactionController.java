package com.adrian.crypto_terminal_server.controller;

import com.adrian.crypto_terminal_server.record.TransactionRecord;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaciton")
public class TransactionController {

 
  @PostMapping("/new")
  public ResponseEntity<Void> sendNewTransaction(@RequestBody TransactionRecord record) {
    return null;
  }
}
