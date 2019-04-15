package com.ricardococati.swapi.usecases.impl;

import com.ricardococati.swapi.domains.Planet;
import com.ricardococati.swapi.gateways.PlanetGateway;
import com.ricardococati.swapi.usecases.CreatePlanet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreatePlanetImpl implements CreatePlanet {

  private final PlanetGateway planetGateway;

  @Override
  public Mono<Planet> execute(final Planet planet) {
    return planetGateway.save(planet);
  }
}
