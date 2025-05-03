package com.app.address.controller;

import com.app.address.controller.dto.AddressDto;
import com.app.address.service.AddressService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * addresscontroller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("code")
public class AddressController {
  private static final Logger log = LoggerFactory.getLogger(AddressController.class);
  private final AddressService addressService;

  /**
   * captercode.
   *
   * @param code the code
   * @return code
   */
  @GetMapping("/{code}")
  public ResponseEntity<AddressDto> capterCode(@PathVariable("code") String code) {
    AddressDto addressDto = AddressDto.fromEntity(addressService.findByCode(code));
    return ResponseEntity.ok(addressDto);
  }

  /**
   * sendcode.
   *
   * @param code the code
   * @return code
   * @throws JsonProcessingException the jsonprocessingexception
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<AddressDto> sendAddress(@RequestBody String code)
      throws JsonProcessingException {
    log.info("## Dados enviados pelo cliente: {}", code);
    AddressDto addressDto = AddressDto.fromEntity(addressService.findByCode(code));
    ObjectMapper objectMapper = new ObjectMapper();
    String message = objectMapper.writeValueAsString(addressDto);
    addressService.sendMessage(message);
    log.info("## Endereco retornado pela api de cep: {}", addressDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(addressDto);
  }

  @GetMapping("/cities/{state}")
  public ResponseEntity<List<String>> getCitiesByState(@PathVariable("state") String state) {
    List<String> cities = addressService.getCitiesByState(state);
    return ResponseEntity.ok(cities);
  }
}
