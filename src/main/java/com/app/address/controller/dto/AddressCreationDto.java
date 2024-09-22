package com.app.address.controller.dto;

import com.app.address.entity.Address;

/**
 * addresscreationdto.
 *
 * @param publicLoc the publicloc
 * @param complement the complement
 * @param neighborhood the neighborhood
 * @param location the location
 * @param fu the fu
 * @param number the number
 */
public record AddressCreationDto(
    String publicLoc,
    String complement,
    String neighborhood,
    String location,
    String fu,
    Long number
) {

  /**
   * address.
   *
   * @return address
   */
  public Address toEntity() {
    return new Address(publicLoc, complement, neighborhood,
        location,
        fu, number);
  }
}
