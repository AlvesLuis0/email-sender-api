package com.alves.emailsender.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alves.emailsender.dto.Email;
import com.alves.emailsender.service.EmailService;

@RestController
public class EmailController {

  private final EmailService emailService;

  public EmailController(EmailService emailService) {
    this.emailService = emailService;
  }

  @PostMapping("/send-email")
  public void sendEmail(@RequestBody Email email) {
    emailService.sendEmail(email);
  }

}