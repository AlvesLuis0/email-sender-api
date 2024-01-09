package com.alves.emailsender.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MandatoryArgumentException extends RuntimeException {

  public MandatoryArgumentException(String argumentName) {
    super(String.format("The '%s' argument is mandatory.", argumentName));
  }
  
}