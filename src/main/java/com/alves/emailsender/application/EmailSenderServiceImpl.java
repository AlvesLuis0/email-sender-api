package com.alves.emailsender.application;

import org.springframework.stereotype.Service;

import com.alves.emailsender.adapters.EmailSenderGateway;
import com.alves.emailsender.core.EmailSenderService;
import com.alves.emailsender.core.exception.InvalidEmailException;
import com.alves.emailsender.core.exception.MandatoryArgumentException;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

  private final EmailSenderGateway emailSenderGateway;
  private final String EMAIL_REGEX = "[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*";

  public EmailSenderServiceImpl(EmailSenderGateway emailSenderGateway) {
    this.emailSenderGateway = emailSenderGateway;
  }

  @Override
  public void sendEmail(String to, String subject, String text) {
    // validating email
    boolean toIsNotValid = to == null || to.isBlank();
    if(toIsNotValid) {
      throw new MandatoryArgumentException("to");
    }

    boolean toDoesNotMatchesTheRegex = !to.matches(EMAIL_REGEX);
    if(toDoesNotMatchesTheRegex) {
      throw new InvalidEmailException(to);
    }

    // sending email
    emailSenderGateway.sendEmail(to, subject, text);
  }
  
}