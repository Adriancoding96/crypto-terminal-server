package com.adrian.crypto_terminal_server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.time.Month;

import com.adrian.crypto_terminal_server.mapper.TransactionMapper;
import com.adrian.crypto_terminal_server.model.Transaction;
import com.adrian.crypto_terminal_server.record.TransactionRecord;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransactionMapperTests {

  private TransactionMapper mapper;

  private final LocalDateTime EXAMPLE_DATE_TIME = LocalDateTime.of(
        2025,
        Month.JANUARY,
        1,
        20,
        30,
        22
  );


  @BeforeEach
  void setUp() {
    mapper = new TransactionMapper();
  }

  @Test
  void testToTransaction() {
    
    TransactionRecord record = new TransactionRecord(
      "produceruuid",
      "consumeruuid",
      "bitcoin",
      2.4D,
      EXAMPLE_DATE_TIME
    );
    
    Transaction transaction = mapper.toTransaction(record);

    assertNotNull(transaction);
    assertEquals("produceruuid", transaction.getProducerUuid());
    assertEquals("consumeruuid", transaction.getProducerUuid());
    assertEquals("bitcoin", transaction.getCurrency());
    assertEquals(EXAMPLE_DATE_TIME, transaction.getTime());
  }

  @Test
  void testToRecord() {

  }
  
}
