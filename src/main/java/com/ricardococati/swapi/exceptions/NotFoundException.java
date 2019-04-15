package com.ricardococati.swapi.exceptions;

public class NotFoundException extends RuntimeException {

  private static final long serialVersionUID = -1707366746575276436L;
  private final String error;

  public NotFoundException(String error) {
    super(error);
    this.error = error;
  }
}
