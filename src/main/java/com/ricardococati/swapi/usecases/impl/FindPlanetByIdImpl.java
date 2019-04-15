package com.ricardococati.swapi.usecases.impl;

import com.ricardococati.swapi.domains.Planet;
import com.ricardococati.swapi.gateways.PlanetGateway;
import com.ricardococati.swapi.usecases.FindPlanetById;
import com.ricardococati.swapi.usecases.FindPlanetByName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindPlanetByIdImpl implements FindPlanetById {

  private final PlanetGateway planetGateway;

  @Override
  public Mono<Planet> execute(final String id) {
    return planetGateway.findPlanetByName(id);
  }
}
