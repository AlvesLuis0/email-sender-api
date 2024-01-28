package com.alves.emailsender.infra.config;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties("message-broker")
@Configuration
public class RabbitMQConfig {

  private String queueName;

  @Bean
  public Queue getQueue() {
    return new Queue(queueName, true);
  } 

}