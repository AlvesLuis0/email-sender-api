package com.alves.emailsender.infra;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.alves.emailsender.adapters.EmailSenderGateway;

@Service
public class JavaMailSenderImpl implements EmailSenderGateway {

  private final JavaMailSender javaMailSender;

  public JavaMailSenderImpl(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }

  @Override
  public void sendEmail(String to, String subject, String text) {
    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setTo(to);
    simpleMailMessage.setSubject(subject);
    simpleMailMessage.setText(text);
    javaMailSender.send(simpleMailMessage);
  }
  
}