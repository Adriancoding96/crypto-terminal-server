package com.adrian.crypto_terminal_server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.time.Month;

import com.adrian.crypto_terminal_server.model.Transaction;
import com.adrian.crypto_terminal_server.serialization.JsonSerialization;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * Tests to verify the correct functionality of JsonSerialization.
 * */
@SpringBootTest
public class JsonSerializationTests {

  private ObjectMapper mapper;
  private JsonSerialization jsonSerialization;

  private final LocalDateTime EXAMPLE_DATE_TIME = LocalDateTime.of(
      2025,
      Month.JANUARY,
      1,
      20,
      30,
      22);

  private final Transaction TRANSACTION_EXAMPLE = new Transaction(
      1L,
      "produceruuid",
      "consumeruuid",
      "bitcoin",
      2.2D,
      EXAMPLE_DATE_TIME);

  private final String EXPECTED_JSON = """
      {
        "id": 1,
        "producerUuid": "produceruuid",
        "consumerUuid": "consumeruuid",
        "currency": "bitcoin",
        "amount": 2.2,
        "time": "2025-01-01T20:30:22"
      }
      """;

  @BeforeEach
  void setUp() {
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    jsonSerialization = new JsonSerialization(mapper);
  }

  /*
   * Test that ensures JsonSerialization toJson method
   * produces a valid json representation of transaction when a 
   * transaction object is passed to the method.
   *
   * The test ensure the json conversion is not null, and that
   * the json is formatted as expected.
   * */
  @Test
  void testTransactionSerialization() throws JsonMappingException, JsonProcessingException {
    String json = jsonSerialization.toJson(TRANSACTION_EXAMPLE);
    assertNotNull(json);

    JsonNode expectedJsonNode = mapper.readTree(EXPECTED_JSON);
    JsonNode actualJsonNode = mapper.readTree(json);
    assertEquals(expectedJsonNode, actualJsonNode);
  }
}
