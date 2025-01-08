package com.adrian.crypto_terminal_server;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import com.adrian.crypto_terminal_server.controller.TransactionController;
import com.adrian.crypto_terminal_server.record.TransactionRecord;
import com.adrian.crypto_terminal_server.service.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/*
 * Tests to verify TransactionController produces the expected results
 * */
@WebMvcTest(controllers = {TransactionController.class})
public class TransactionControllerTests {
 
  private final LocalDateTime EXAMPLE_DATE_TIME = LocalDateTime.of(
        2025,
        Month.JANUARY,
        1,
        20,
        30,
        22
  );


  private final TransactionRecord RECORD_ONE = new TransactionRecord(
    "producerUuidOne",
    "consumerUuidOne",
    "bitcoin",
    2.2D,
    EXAMPLE_DATE_TIME,
    "producerone@example.com",
    "consumerone@example.com"
  );
  
  private final TransactionRecord RECORD_TWO = new TransactionRecord(
    "producerUuidTwo",
    "consumerUuidTwo",
    "springcoin",
    12.5D,
    EXAMPLE_DATE_TIME,
    "producertwo@example.com",
    "consumertwo@example.com"
  );

  private final List<TransactionRecord> RECORDS = List.of(RECORD_ONE, RECORD_TWO);

  @Autowired
  private final ObjectMapper mapper = new ObjectMapper();

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  public void setup() {
    mapper.registerModule(new JavaTimeModule());
  }

  @MockBean
  private TransactionService transactionService;
 
  /*
   * Test verifys that sendNewTransaction returns status 200 ok
   * when transaction is sent.
   * */
  @Test
  @WithMockUser
  public void sendNewTransaction_shouldReturnStatusOk() throws Exception {
    String recordJson = mapper.writeValueAsString(RECORD_ONE);

    Mockito.doNothing().when(transactionService).sendNewTransaction(Mockito.any(TransactionRecord.class));

    mockMvc.perform(MockMvcRequestBuilders.post("/api/transaction/new")
        .with(csrf())
        .contentType(MediaType.APPLICATION_JSON)
        .content(recordJson))
      .andExpect(MockMvcResultMatchers.status().isOk());
    

    
  }

}
