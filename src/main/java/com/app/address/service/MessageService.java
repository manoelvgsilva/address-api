package com.app.address.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * messageservice.
 */
@Service
public class MessageService {
  private static final Logger logger = LoggerFactory.getLogger(MessageService.class);
  private final KafkaTemplate<String, String> kafkaTemplate;
  private static String staticTopcAddress;

  @Autowired
  public MessageService(KafkaTemplate<String, String> kafkaTemplate, @Value(
      "${topic.address}") String topicAddress) {
    this.kafkaTemplate = kafkaTemplate;
    staticTopcAddress = topicAddress;
  }

  public void senMessage(String message) {
    logger.info("Mesasage -> {}", message);
    this.kafkaTemplate.send(staticTopcAddress, message);
  }
}
