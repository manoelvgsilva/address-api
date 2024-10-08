package com.app.address;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * addressapplication.
 */
@SpringBootApplication
@EnableFeignClients
public class AddressApplication {
  public static void main(String[] args) {
    SpringApplication.run(AddressApplication.class, args);
  }
}