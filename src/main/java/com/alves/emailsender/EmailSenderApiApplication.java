package com.alves.emailsender;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class EmailSenderApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(EmailSenderApiApplication.class, args);
  }

}