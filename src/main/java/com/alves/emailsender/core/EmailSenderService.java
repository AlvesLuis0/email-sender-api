package com.alves.emailsender.core;

public interface EmailSenderService {

  public void sendEmail(String to, String subject, String text);
  
}