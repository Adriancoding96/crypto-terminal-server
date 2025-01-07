package com.adrian.crypto_terminal_server.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionMessagePublisher {
  
  private final RabbitTemplate template;

  @Autowired
  public TransactionMessagePublisher(RabbitTemplate template) {
    this.template = template;
  }

  public void sendMessage(String message) {
    template.convertAndSend("transaction_queue",message);
  }
}
