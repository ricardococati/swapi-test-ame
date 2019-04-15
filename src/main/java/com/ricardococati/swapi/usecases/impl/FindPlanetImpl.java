package com.ricardococati.swapi.usecases.impl;

import com.ricardococati.swapi.domains.Planet;
import com.ricardococati.swapi.gateways.PlanetGateway;
import com.ricardococati.swapi.usecases.FindPlanet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindPlanetImpl implements FindPlanet {

  private final PlanetGateway planetGateway;

  @Override
  public Flux<Planet> execute() {
    return planetGateway.findPlanet();
  }
}
