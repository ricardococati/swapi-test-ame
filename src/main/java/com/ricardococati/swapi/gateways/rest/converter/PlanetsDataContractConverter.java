package com.ricardococati.swapi.gateways.rest.converter;

import com.ricardococati.swapi.domains.PlanetFromSwapiPage;
import com.ricardococati.swapi.gateways.rest.data.PlanetsPageDataCrontract;

public class PlanetsDataContractConverter {

  public static PlanetFromSwapiPage convert(PlanetsPageDataCrontract planet) {
    return PlanetFromSwapiPage.builder()
        .count(planet.getCount())
        .next(planet.getNext())
        .previous(planet.getPrevious())
        .results(planet.getResults())
        .build();
  }
}
