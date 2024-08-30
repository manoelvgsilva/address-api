package com.app.address.controller;

import com.app.address.controller.dto.AddressDto;
import com.app.address.service.AddressService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("code")
public class AddressController {
  private final AddressService addressService;

  @GetMapping("/{code}")
  public ResponseEntity<AddressDto> capterCode(@PathVariable("code") String code) {
    AddressDto addressDto = AddressDto.fromEntity(addressService.findByCode(code));
    return ResponseEntity.ok(addressDto);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<AddressDto> sendAddress(@RequestBody String code) throws JsonProcessingException {
    log.info("## Dados enviados pelo cliente: {}", code);
    AddressDto addressDto =
        AddressDto.fromEntity(addressService.findByCode(String.valueOf(capterCode(code))));
    ObjectMapper objectMapper = new ObjectMapper();
    String message = objectMapper.writeValueAsString(addressDto);
    addressService.sendMessage(message);
    log.info("## Endereco retornado pela api de cep: {}", addressDto);
    return ResponseEntity.ok(addressDto);
  }
}
