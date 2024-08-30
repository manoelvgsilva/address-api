package com.app.address.service;

import com.app.address.entity.Address;
import com.app.address.repository.AddressRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@Log4j2
@FeignClient(name = "zipcode", url="https://zipcode.com.br/ws")
public class AddressService {
  @Value("${topic.address-client}")
  private String topicAddressClient;

  private final AddressRepository addressRepository;

  @Autowired
  public AddressService(AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
  }

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @GetMapping("/{code}/json")
  public Address findByCode(@PathVariable("code") String code) {
    return null;
  }

  public void sendMessage(String message) {
    this.kafkaTemplate.send(topicAddressClient, message);
    log.info("Mensagem enviada para o topic.address-client: {}", message);
  }

}