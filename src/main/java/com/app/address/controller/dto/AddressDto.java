package com.app.address.controller.dto;

import com.app.address.entity.Address;

/**
 * addressdto.
 *
 * @param code the code
 * @param publicLoc the publicloc
 * @param complement the complement
 * @param neighborhood the neighborhood
 * @param location the location
 * @param fu the fu
 * @param number the number
 */
public record AddressDto(
    String code,
    String publicLoc,
    String complement,
    String neighborhood,
    String location,
    String fu,
    Long number
) {

  /**
   * addressdto.
   *
   * @param address the address
   * @return address
   */
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
