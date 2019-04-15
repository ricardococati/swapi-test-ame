package com.ricardococati.swapi.usecases.impl;

import com.ricardococati.swapi.domains.Planet;
import com.ricardococati.swapi.gateways.PlanetGateway;
import com.ricardococati.swapi.usecases.DeletePlanet;
import com.ricardococati.swapi.usecases.FindPlanetById;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeletePlanetImpl implements DeletePlanet {

  private final PlanetGateway planetGateway;

  @Override
  public void execute(final String id) {
    planetGateway.deletePlanet(id);
  }
}
