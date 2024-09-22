package com.app.address.repository;

import com.app.address.entity.Address;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * AddressRepository.
 */
@Repository
public interface AddressRepository extends MongoRepository<Address, String> {

  Optional<Address> findByCode(String code);

}