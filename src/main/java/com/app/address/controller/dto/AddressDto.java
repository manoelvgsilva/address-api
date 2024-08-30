package com.app.address.controller.dto;

import com.app.address.entity.Address;

public record AddressDto(
    String code,
    String publicLoc,
    String complement,
    String neighborhood,
    String location,
    String fu,
    Long number
) {

  public static AddressDto fromEntity(Address address) {
    return new AddressDto(
        address.getCode(),
        address.getPublicLoc(),
        address.getComplement(),
        address.getNeighborhood(),
        address.getLocation(),
        address.getFu(),
        address.getNumber()
    );
  }
}
