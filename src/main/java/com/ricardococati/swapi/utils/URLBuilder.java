package com.ricardococati.swapi.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public class URLBuilder {

  private String service;
  private String resource;
  private Map<String, String> params;

  private URLBuilder() {
    this.service = StringUtils.EMPTY;
    this.resource = StringUtils.EMPTY;
    this.params = new LinkedHashMap<>();
  }

  public static URLBuilder builder() {
    return new URLBuilder();
  }

  public URLBuilder service(String service) {
    this.service = service;
    return this;
  }

  public URLBuilder resource(String resource) {
    this.resource = resource;
    return this;
  }

  public URLBuilder param(String key, String value) {
    this.params.put(key, value);
    return this;
  }

  public String build() {
    String uri = String.format("https://%s/%s", this.service, this.resource);
    if (!this.params.isEmpty()) {
      uri = uri.concat("?").concat(this.params.entrySet().stream()
          .map(entry -> entry.getKey().concat("=").concat(entry.getValue()))
          .collect(Collectors.joining("&")));
    }
    return uri;
  }
}
