package com.adrian.crypto_terminal_server.service;

public interface EmailService {

  void sendConfirmationEmail(String producerEmail);
  void sendNotificationEmail(String consumerEmail);
}
