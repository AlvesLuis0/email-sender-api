package com.alves.emailsender.dto;

public record Email(

  String to,
  String subject,
  String text

) {}