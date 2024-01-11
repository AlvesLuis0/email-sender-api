package com.alves.emailsender.adapters;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alves.emailsender.core.EmailRequest;
import com.alves.emailsender.core.EmailSenderService;

@RestController
public class EmailSenderController {

  private final EmailSenderService emailSenderService;

  public EmailSenderController(EmailSenderService emailSenderService) {
    this.emailSenderService = emailSenderService;
  }

  @PostMapping("/send-email")
  public void sendEmail(@RequestBody EmailRequest email) {
    String to = email.to();
    String subject = email.subject();
    String text = email.text();
    emailSenderService.sendEmail(to, subject, text);
  }

}