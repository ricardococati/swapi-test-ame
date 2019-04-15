package com.ricardococati.swapi.gateways.http.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanetJson {

  private String id;
  private String name;
  private String climate;
  private String terrain;

}
