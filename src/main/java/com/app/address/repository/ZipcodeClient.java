package com.app.address.repository;

import com.app.address.entity.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ZipcodeClient.
 */
@FeignClient(name = "zipcode", url = "https://zipcode.com.br/ws")
public interface ZipcodeClient {

  /**
   * findbycode.
   *
   * @param code the code
   * @return code
   */
  @GetMapping("/{code}/json")
  Address findByCode(@PathVariable("code") String code);

  /**
   * findbycep.
   *
   * @param cep the cep
   * @return address
   */
  @GetMapping("/{cep}/json")
  Address findByCep(@PathVariable("cep") String cep);
}
