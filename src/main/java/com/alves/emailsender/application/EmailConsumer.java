package com.alves.emailsender.application;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.alves.emailsender.adapters.EmailSenderGateway;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class EmailConsumer {

  private final EmailSenderGateway emailSenderGateway;
  private final ObjectMapper mapper;

  @RabbitListener(queues = "${message-broker.queueName}")
  public void sendEmail(@Payload Message<String> message) throws JsonMappingException, JsonProcessingException {
    var json = mapper.readTree(message.getPayload());
    emailSenderGateway.sendEmail(
      json.get("to").asText(),
      json.get("subject").asText(),
      json.get("text").asText()
    );
  }
  
}