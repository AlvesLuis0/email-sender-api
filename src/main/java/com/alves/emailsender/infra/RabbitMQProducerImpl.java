package com.alves.emailsender.infra;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import com.alves.emailsender.adapters.ProducerGateway;
import com.alves.emailsender.infra.config.RabbitMQConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RabbitMQProducerImpl implements ProducerGateway {

  private final AmqpTemplate template;
  private final RabbitMQConfig rabbitConfig;
  private final ObjectMapper mapper;

  @Override
  public void publish(Object payload) {
    String json;
    try {
      json = mapper.writeValueAsString(payload);
      template.convertAndSend(
        rabbitConfig.getExchangeName(),
        rabbitConfig.getRoutingKey(),
        json
      );
    }
    catch(Exception exception) {
      exception.printStackTrace();
    }
  }
  
}