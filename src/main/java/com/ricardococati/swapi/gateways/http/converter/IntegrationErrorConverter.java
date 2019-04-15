package com.ricardococati.swapi.gateways.http.converter;

import com.ricardococati.swapi.gateways.http.json.IntegrationErrorJson;
import com.ricardococati.swapi.domains.IntegrationError;

public class IntegrationErrorConverter {

  public static IntegrationError toDomain(
      IntegrationErrorJson json) {
    return IntegrationError.builder()
        .id(json.getId())
        .number(json.getNumber())
        .message(json.getMessage())
        .build();

  }
}
