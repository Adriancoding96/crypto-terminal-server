package com.adrian.crypto_terminal_server.mapper;

import com.adrian.crypto_terminal_server.model.Transaction;
import com.adrian.crypto_terminal_server.record.TransactionRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
 * Mapper class for converting (@link TransactionRecord) and (@link Transaction).
 * */
@Component
public class TransactionMapper {

  private static final Logger logger = LoggerFactory.getLogger(TransactionMapper.class);

  /*
   * Converts a (@link TransactionRecord) to a (@link Transaction).
   *
   * @param record: contains (@link TransactionRecord) to be mapped to a (@link Transaction)
   * @return transaction: the mapped (@link Transaction) object.
   * @throws IllegalArgumentException: if the input (@link TransactionRecord)
   *                                   is (@code null).
   * */
  public Transaction toTransaction(TransactionRecord record) {
    if(record == null) throw new IllegalArgumentException("TransactionRecord is null");
    logger.debug("Mapping TransactionRecord to Transaction");

    return new Transaction(
        null,
        record.producerUuid(),
        record.consumerUuid(),
        record.currency(),
        record.amount(),
        record.time());
  }

  /*
   * Coverts a {@link Transaction} to a (@link TransactionRecord).
   *
   * @param transaction: contains (@link Transaction) to be mapped to a (@link TransactionRecord)
   * @return record: the mapped (@link TransactionRecord) object.
   * @throws IlleagalArgumentException: if the input (@link Transaction)
   *                                    is (@code null).
   *
   * */
  public TransactionRecord toRecord(Transaction transaction) {
    if(transaction == null) throw new IllegalArgumentException("Transaction model is null");
    logger.debug("Mapping Transaction to TransactionRecord");

    return new TransactionRecord(
        transaction.getProducerUuid(),
        transaction.getConsumerUuid(),
        transaction.getCurrency(),
        transaction.getAmount(),
        transaction.getTime());
  }
}
