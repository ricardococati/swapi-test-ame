package com.ricardococati.swapi.gateways.http.converter;

import com.ricardococati.swapi.gateways.http.json.PlanetJson;
import com.ricardococati.swapi.domains.Planet;

public class PlanetConverter {

  public static PlanetJson convertPlanetToJson(
      Planet planet) {
    return PlanetJson.builder()
        .id(planet.getId())
        .name(planet.getName())
        .climate(planet.getClimate())
        .terrain(planet.getTerrain())
        .build();
  }

  public static Planet convertPlanetJsonToPlanet(
      PlanetJson json) {
    return Planet.builder()
        .id(json.getId())
        .name(json.getName())
        .climate(json.getClimate())
        .terrain(json.getTerrain())
        .build();
  }
}
