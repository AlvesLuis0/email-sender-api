package com.alves.emailsender.infra.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties("rabbitmq")
@Configuration
public class RabbitMQConfig {

  private String exchangeName;
  private String routingKey;
  
}