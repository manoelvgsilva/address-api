package com.app.address.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "address")
@EntityListeners(AuditingEntityListener.class)
public class Address {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true)
  private String code;
  private String publicLoc;
  private String complement;
  private String neighborhood;
  private String location;
  private String fu;

  public Address(String publicLoc, String complement, String neighborhood, String location, String fu) {
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
        && Objects.equals(fu, address.fu);
  }
}