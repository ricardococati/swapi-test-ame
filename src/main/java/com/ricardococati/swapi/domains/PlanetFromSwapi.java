package com.ricardococati.swapi.domains;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanetFromSwapi {

  @Id
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
