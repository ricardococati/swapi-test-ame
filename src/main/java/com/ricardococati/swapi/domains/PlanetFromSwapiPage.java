package com.ricardococati.swapi.domains;

import com.ricardococati.swapi.gateways.rest.data.PlanetsDataCrontract;
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
public class PlanetFromSwapiPage {

  private Integer count;
  private String next;
  private String previous;
  private List<PlanetsDataCrontract> results;

}
