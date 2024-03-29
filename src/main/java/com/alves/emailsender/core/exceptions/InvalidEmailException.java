package com.alves.emailsender.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEmailException extends RuntimeException {

  public InvalidEmailException(String email) {
    super(String.format("'%s' is not a valid e-mail.", email));
  }
  
}