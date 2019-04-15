package com.ricardococati.swapi.gateways.http.converter;

import com.ricardococati.swapi.domains.PlanetFromSwapi;
import com.ricardococati.swapi.domains.PlanetFromSwapiPage;
import com.ricardococati.swapi.gateways.http.json.PlanetFromSwapiJson;
import com.ricardococati.swapi.gateways.http.json.PlanetFromSwapiPageJson;

public class PlanetFromSwapiConverter {

  public static PlanetFromSwapiPageJson convert(
      PlanetFromSwapiPage planet) {
    return PlanetFromSwapiPageJson.builder()
        .count(planet.getCount())
        .next(planet.getNext())
        .previous(planet.getPrevious())
        .results(planet.getResults())
        .build();
  }

}
