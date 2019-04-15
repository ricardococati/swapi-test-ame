package com.ricardococati.swapi.domains.enums;

public enum ErrorType {

  NOT_FOUND_RESOURCE;

  @Override
  public String toString() {
    return "planets.api.error." + super.toString().toLowerCase().replaceAll("_", ".");
  }
}
