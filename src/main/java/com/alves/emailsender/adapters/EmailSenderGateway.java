package com.alves.emailsender.adapters;

public interface EmailSenderGateway {

  public void sendEmail(String to, String subject, String text);
  
}