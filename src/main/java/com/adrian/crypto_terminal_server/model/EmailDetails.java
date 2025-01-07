package com.adrian.crypto_terminal_server.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Model of emails sent to producer and consumers during currency transactions.
 * The class contains all neccessary attributes to construct a email and send it
 * using the spring.starter.mail dependency. 
 *
 * @param id:             the identifier of the email.
 * @param recipient:      the recipient email.
 * @param messageBody:    the body of the email.
 * @param subject:        the subject of the email.
 * @param attachment:     email attachment.
 * 
 * @since 0.1
 * @author adrian.nilsson.coding@gmail.com
 * */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDetails {
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String recipient;
  private String messageBody;
  private String subject;
  private String attachment;
}
