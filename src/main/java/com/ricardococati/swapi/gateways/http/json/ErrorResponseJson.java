package com.ricardococati.swapi.gateways.http.json;

import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ErrorResponseJson implements Serializable {

  private static final long serialVersionUID = 4435959686991135330L;

  private String error;

  public ErrorResponseJson(String error) {
    this.error = error;
  }
}
