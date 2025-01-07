package com.adrian.crypto_terminal_server.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionMessageListener {

  @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
  public void recieveMessage(String message) {
    System.out.println("Transaction message recieved");
  }
  
}
