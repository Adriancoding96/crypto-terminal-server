package com.adrian.crypto_terminal_server;

import com.adrian.crypto_terminal_server.mapper.TransactionMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransactionMapperTests {

  private TransactionMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new TransactionMapper();
  }

  @Test
  void testToTransaction() {

  }

  @Test
  void testToRecord() {

  }
  
}
