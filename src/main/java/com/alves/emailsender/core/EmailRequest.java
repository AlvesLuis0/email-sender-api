package com.alves.emailsender.core;

public record EmailRequest(

  String to,
  String subject,
  String text

) {}