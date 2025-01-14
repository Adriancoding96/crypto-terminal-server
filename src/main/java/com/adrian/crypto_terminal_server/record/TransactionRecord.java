package com.adrian.crypto_terminal_server.record;

import java.time.LocalDateTime;


/*
 * Represent a finanical transaction between an producer client and an consumer client.
 * The record contains information about the client identifiers, the currency type,
 * the ammount, and the time of the transaction.
 *
 * @param producerUuid:   the identifier of the producer client.
 * @param consumerUuid:   the identifier of the consumer client.
 * @param currency:       the currency used in the transaction.
 * @param ammount:        the amount involved in the transaction.
 * @param time:           the amount involved in the transaction.
 * @param producerEmail:  the amount involved in the transaction.
 * @param consumerEmail:  the amount involved in the transaction.
 * 
 * @since 0.1
 * @author adrian.nilsson.coding@gmail.com
 * */
public record TransactionRecord(
    String producerUuid,
    String consumerUuid,
    String currency,
    Double amount,
    LocalDateTime time,
    String producerEmail,
    String consumerEmail
) {}
