package com.app.address;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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