package com.alves.emailsender.application;

import org.springframework.stereotype.Service;

import com.alves.emailsender.adapters.ProducerGateway;
import com.alves.emailsender.core.ProducerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProducerServiceImpl implements ProducerService {

  private final ProducerGateway producerGateway;

  @Override
  public void publish(Object payload) {
    producerGateway.publish(payload);
  }
  
}