package com.alves.emailsender.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.alves.emailsender.dto.Email;
import com.alves.emailsender.exceptions.InvalidEmailException;
import com.alves.emailsender.exceptions.MandatoryArgumentException;

@Service
public class EmailService {

  private final JavaMailSender emailSender;
  private final String FROM;
  private final String EMAIL_REGEX = "[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*";

  public EmailService(JavaMailSender emailSender, @Value("${spring.mail.username}") String FROM) {
    this.emailSender = emailSender;
    this.FROM = FROM;
  }

  public void sendEmail(Email email) {
    // validating email
    String to = email.to();
    boolean toIsNull = to == null || to.isBlank();

    if(toIsNull) {
      throw new MandatoryArgumentException("to");
    }

    boolean toDoesNotMatchesTheRegex = !to.matches(EMAIL_REGEX);
    if(toDoesNotMatchesTheRegex) {
      throw new InvalidEmailException(to);
    }

    // sending email
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(FROM);
    message.setTo(email.to());
    message.setSubject(email.subject());
    message.setText(email.text());
    emailSender.send(message);
  }
  
}