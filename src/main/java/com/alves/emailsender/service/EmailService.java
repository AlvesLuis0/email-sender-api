package com.alves.emailsender.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.alves.emailsender.dto.Email;

@Service
public class EmailService {

  private final JavaMailSender emailSender;
  private final String FROM;

  public EmailService(JavaMailSender emailSender, @Value("${spring.mail.username}") String FROM) {
    this.emailSender = emailSender;
    this.FROM = FROM;
  }

  public void sendEmail(Email email) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(FROM);
    message.setTo(email.to());
    message.setSubject(email.subject());
    message.setText(email.text());
    emailSender.send(message);
  }
  
}