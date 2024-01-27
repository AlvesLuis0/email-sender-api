package com.alves.emailsender.core;

public interface ProducerService {

  public void publish(Object payload);
  
}