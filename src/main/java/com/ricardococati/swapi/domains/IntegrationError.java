package com.ricardococati.swapi.domains;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
public class IntegrationError {

  private String id;
  private String number;
  private String message;
  @Setter(AccessLevel.NONE)
  private LocalDateTime date = LocalDateTime.now();
}
