package com.app.address.service;

import com.app.address.entity.Address;
import com.app.address.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "zipcode", url="https://zipcode.com.br/ws")
public class AddressService {
  private final AddressRepository addressRepository;

  @Autowired
  public AddressService(AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
  }

  @GetMapping("/{code}/json")
  Address findByCode(@PathVariable("code") String code) {
    return null;
  }
}