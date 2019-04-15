package com.ricardococati.swapi.gateways.rest.data;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanetsPageDataCrontract {

  private Integer count;
  private String next;
  private String previous;
  private List<PlanetsDataCrontract> results;

}
