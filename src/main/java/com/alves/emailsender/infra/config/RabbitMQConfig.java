package com.alves.emailsender.infra.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties("rabbitmq")
@Configuration
public class RabbitMQConfig {

  private String queueName;
  private String exchangeName;
  private String routingKey;

  @Bean
  public Queue getQueue() {
    return new Queue(queueName, true);
  } 

  @Bean
  public TopicExchange getExchange() {
    return new TopicExchange(exchangeName);
  }

  @Bean
  public Binding getBinding(Queue queue, TopicExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(routingKey);
  }
  
}