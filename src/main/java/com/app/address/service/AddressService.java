package com.app.address.service;

import com.app.address.entity.Address;
import com.app.address.repository.AddressRepository;
import com.app.address.repository.ZipcodeClient;
import java.util.Optional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * addressservice.
 */
@Service
@Log4j2
public class AddressService {

  @Value("${topic.address-client}")
  private String topicAddressClient;

  private final AddressRepository addressRepository;
  private final ZipcodeClient zipcodeClient;

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  /**
   * addressservice.
   *
   * @param addressRepository the addressRepository
   * @param zipcodeClient the zipcodeClient
   */
  @Autowired
  public AddressService(AddressRepository addressRepository, ZipcodeClient zipcodeClient) {
    this.addressRepository = addressRepository;
    this.zipcodeClient = zipcodeClient;
  }

  /**
   * findbycode.
   *
   * @param code the code
   * @return code
   */
  public Address findByCode(String code) {
    Optional<Address> optionalAddress = addressRepository.findByCode(code);
    if (optionalAddress.isPresent()) {
      log.info("Endereço encontrado no banco de dados para o código: {}", code);
      return optionalAddress.get();
    }
    Address address = zipcodeClient.findByCode(code);
    addressRepository.save(address);
    log.info("Endereço salvo no banco de dados após a chamada ao Feign para o código: {}", code);
    return address;
  }

  /**
   * sendmessage.
   *
   * @param message the message
   */
  public void sendMessage(String message) {
    this.kafkaTemplate.send(topicAddressClient, message);
    log.info("Mensagem enviada para o topic.address-client: {}", message);
  }
}