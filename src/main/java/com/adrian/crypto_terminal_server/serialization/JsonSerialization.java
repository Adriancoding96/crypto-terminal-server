package com.adrian.crypto_terminal_server.serialization;

import com.adrian.crypto_terminal_server.model.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.springframework.stereotype.Component;

@Component
public class JsonSerialization {

  private final ObjectWriter writer;

  public JsonSerialization(ObjectMapper mapper) {
    writer = mapper.writer().withDefaultPrettyPrinter(); 
  }

  public String toJson(Object object) {
    switch (object) {
      case Transaction transaction: {
        return transactionToJson(transaction);
      }
      case null: {
        throw new IllegalArgumentException("Object cannot be null");
      }
      default: {
        throw new RuntimeException("Instance of object is not present in pattern matcher");
      }
    } 
  }

  private String transactionToJson(Transaction transaction) {
    try {
      return writer.writeValueAsString(transaction);
    } catch (JsonProcessingException e) {
      throw new IllegalArgumentException("Failed to map: " + transaction + " to JSON", e );
    }
  }
}
