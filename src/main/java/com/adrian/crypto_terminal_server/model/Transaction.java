package com.adrian.crypto_terminal_server.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Model of finanical transaction between an producer client and an consumer client.
 * The record contains information about the client identifiers, the currency type,
 * the ammount, and the time of the transaction.
 *
 * @param id:             the identifier of the transaction.
 * @param producerUuid:   the identifier of the producer client.
 * @param consumerUuid:   the identifier of the consumer client.
 * @param currency:       the currency used in the transaction.
 * @param ammount:        the amount involved in the transaction.
 * 
 * @since 0.1
 * @author adrian.nilsson.coding@gmail.com
 * */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("producerUuid")
    private String producerUuid;

    @JsonProperty("consumerUuid")
    private String consumerUuid;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("time")
    private LocalDateTime time;
}
