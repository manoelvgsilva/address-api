package com.app.address.controller.dto;

import com.app.address.entity.Address;

public record AddressCreationDto(
    String publicLoc,
    String complement,
    String neighborhood,
    String location,
    String fu
) {

  public Address toEntity() {
    return new Address(publicLoc, complement, neighborhood,
        location,
        fu);
  }
}
