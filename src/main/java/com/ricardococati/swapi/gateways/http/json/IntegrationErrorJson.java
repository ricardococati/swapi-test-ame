package com.ricardococati.swapi.gateways.http.json;

import lombok.Data;

@Data
public class IntegrationErrorJson {

  private String id;
  private String number;
  private String message;
}
