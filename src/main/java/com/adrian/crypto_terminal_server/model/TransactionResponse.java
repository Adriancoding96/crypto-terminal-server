package com.adrian.crypto_terminal_server.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Response model from a consumer containing id for db persistance, if
 * the transaction was an success, the consumer uuid, succes | error message,
 * and the time the consumer recieved the response.
 *
 * @param id:             attribute for saving model to a database.
 * @param success:        success status of the transaction.
 * @param consumerUuid:   the identifier of the consumer client.
 * @param currency:       message containing success | error message.
 * @param ammount:        the time the transaction was recieved by the consumer.
 * 
 * @since 0.1
 * @author adrian.nilsson.coding@gmail.com
 * */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private boolean success;
  private String consumerUuid;
  private String message;
  private LocalDateTime timeRecieved;
  
}
