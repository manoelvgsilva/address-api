package com.app.address.docs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Configuration;

/**
 * Class to configure the OpenAPI documentation.
 */
@Configuration
public class OpenApiConfig implements OpenApiCustomizer {

  @Override
  public void customise(OpenAPI openApi) {
    Info info = new Info()
        .title("API de endereço")
        .description("Este projeto apresenta uma API RESTful que gerencia a "
            + "localização geografica de usuarios de acordo com o cep "
            + " , possibilitando às pessoas usuárias criar, visualizar, atualizar e excluir"
            + " seu endereço, de forma intuitiva e prática. A"
            + " API "
            + "oferece"
            + " endpoints específicos para"
            + " operações CRUD (Create, Read, Update, Delete) em listas de "
            + "endereço,"
            + " visando"
            + " proporcionar uma experiência consistente e confiável.")
        .version("1.0.0");

    openApi.info(info);
  }
}