package com.ricardococati.swapi.gateways.http.json;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanetFromSwapiJson {

  private String name;
  private String rotation_period;
  private String orbital_period;
  private String diameter;
  private String climate;
  private String gravity;
  private String terrain;
  private String surface_water;
  private String population;
  private List<String> residents;
  private List<String> films;
  private String created;
  private String edited;
  private String url;

}
