package com.adrian.crypto_terminal_server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.time.Month;

import com.adrian.crypto_terminal_server.mapper.TransactionMapper;
import com.adrian.crypto_terminal_server.model.Transaction;
import com.adrian.crypto_terminal_server.record.TransactionRecord;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * Tests to verify the correct functionality of TransactionMapper.
 * The tests validate two methods, which are mapping a Transaction to
 * a TransactionRecord, and mapping a TransactionRecord to a Transaction.
 * */
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

  /*
   * Test that ensures TransactionMapper toTransaction method
   * produces a valid transaction model, that is not null and all attributes
   * of the record are correctly mapped.
   * */
  @DisplayName("Map - TransactionRecord -> Transaction")
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
    assertEquals(2.4D, transaction.getAmount());
    assertEquals(EXAMPLE_DATE_TIME, transaction.getTime());
  }

  /*
   * Test that ensures TransactionMaper toRecord method
   * produces a valid TransactionRecord, that is not null and all attributes
   * are correctly mapped.
   * */
  @DisplayName("Map - Transaction -> TransactionRecord")
  @Test
  void testToRecord() {
    
    Transaction transaction = new Transaction();
    transaction.setId(1L);
    transaction.setProducerUuid("produceruuid");
    transaction.setConsumerUuid("consumeruuid");
    transaction.setCurrency("bitcoin");
    transaction.setAmount(2.4D);
    transaction.setTime(EXAMPLE_DATE_TIME);

    TransactionRecord record = mapper.toRecord(transaction);

    assertNotNull(record);
    assertEquals("produceruuid", record.producerUuid());
    assertEquals("consumeruuid", record.consumerUuid());
    assertEquals("bitcoin", record.currency());
    assertEquals(2.4D, record.amount());
    assertEquals(EXAMPLE_DATE_TIME, record.time());

  }
  
}
