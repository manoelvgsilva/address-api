package com.app.address.entity;

import java.util.Objects;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * address.
 */
@Document(collection = "addressess")
public class Address {
  private String code;
  private String publicLoc;
  private String complement;
  private String neighborhood;
  private String location;
  private String fu;
  private Long number;

  public Address(String publicLoc, String complement, String neighborhood,
                 String location, String fu, Long number) {
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getPublicLoc() {
    return publicLoc;
  }

  public void setPublicLoc(String publicLoc) {
    this.publicLoc = publicLoc;
  }

  public String getComplement() {
    return complement;
  }

  public void setComplement(String complement) {
    this.complement = complement;
  }

  public String getNeighborhood() {
    return neighborhood;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getFu() {
    return fu;
  }

  public void setFu(String fu) {
    this.fu = fu;
  }

  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(code, address.code)
        && Objects.equals(publicLoc, address.publicLoc)
        && Objects.equals(complement, address.complement)
        && Objects.equals(neighborhood, address.neighborhood)
        && Objects.equals(location, address.location)
        && Objects.equals(fu, address.fu)
        && Objects.equals(number, address.number);
  }
}