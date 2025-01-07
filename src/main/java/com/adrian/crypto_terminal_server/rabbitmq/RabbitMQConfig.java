package com.adrian.crypto_terminal_server.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

  public static final String QUEUE_NAME = "transaction_queue";
  public static final String EXCHANGE_NAME = "transaction_exchange";

  @Bean
  public Queue transactionQueue() {
    return new Queue(QUEUE_NAME, true);
  }

  @Bean
  public TopicExchange transactionExchange() {
    return new TopicExchange(EXCHANGE_NAME);
  }

  @Bean
  public Binding binding(Queue transactionQueue, TopicExchange transactionExchange) {
      return BindingBuilder.bind(transactionQueue).to(transactionExchange).with("transaction.#");
  }

}
