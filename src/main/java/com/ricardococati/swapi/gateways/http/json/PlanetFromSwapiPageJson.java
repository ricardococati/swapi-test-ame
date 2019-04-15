package com.ricardococati.swapi.gateways.http.json;

import com.ricardococati.swapi.domains.PlanetFromSwapi;
import com.ricardococati.swapi.gateways.rest.data.PlanetsDataCrontract;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanetFromSwapiPageJson {

  private Integer count;
  private String next;
  private String previous;
  private List<PlanetsDataCrontract> results;

}
