package com.app.address.controller;

import com.app.address.controller.dto.AddressDto;
import com.app.address.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("code")
public class AddressController {
  private final AddressService addressService;

  @GetMapping("/{code}")
  public ResponseEntity<AddressDto> capterCode(@PathVariable("code") String code) {
    AddressDto addressDto = addressService.findByCode(code);
    return ResponseEntity.ok(addressDto);
  }
}
