package com.alves.emailsender.adapters;

public interface ProducerGateway {

  public void publish(Object payload);
  
}