package com.app.address.service;

import com.app.address.entity.Address;
import com.app.address.repository.AddressRepository;
import com.app.address.repository.ZipcodeClient;
import java.util.List;
import java.util.Optional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * addressservice.
 */
@Service
@Log4j2
public class AddressService {

  @Autowired
  private MongoTemplate mongoTemplate;

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

  /**
   * getcitiesbystate.
   *
   * @param state the state
   * @return cities
   */
  public List<String> getCitiesByState(String state) {
    Query query = new Query();
    query.addCriteria(Criteria.where("fu").is(state.toUpperCase()));
    return mongoTemplate.findDistinct(query, "location", Address.class, String.class);
  }

  /**
   * findbycep.
   *
   * @param cep the cep
   * @return address
   */
  public Address findByCep(String cep) {
    // Aqui, assumimos que o cliente de CEP (zipcodeClient) pode ter um método para buscar o endereço por CEP
    Address address = zipcodeClient.findByCep(cep);
    if (address != null) {
      log.info("Endereço encontrado para o CEP: {}", cep);
    } else {
      log.warn("Nenhum endereço encontrado para o CEP: {}", cep);
    }
    return address;
  }
}
