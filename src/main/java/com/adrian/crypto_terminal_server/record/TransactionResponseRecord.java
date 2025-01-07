package com.adrian.crypto_terminal_server.record;

import java.time.LocalDateTime;

/*
 * Represent a response from a consumer containing information if
 * the transaction was an success, the consumer uuid, succes | error message,
 * and the time the consumer recieved the response.
 *
 * @param success:        success status of the transaction.
 * @param consumerUuid:   the identifier of the consumer client.
 * @param currency:       message containing success | error message.
 * @param ammount:        the time the transaction was recieved by the consumer.
 * 
 * @since 0.1
 * @author adrian.nilsson.coding@gmail.com
 * */
public record TransactionResponseRecord(
  boolean success,
  String consumerUuid,
  String message,
  LocalDateTime timeRecieved
) {}
