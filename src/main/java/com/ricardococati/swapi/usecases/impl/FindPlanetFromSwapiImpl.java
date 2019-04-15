package com.ricardococati.swapi.usecases.impl;

import com.ricardococati.swapi.domains.PlanetFromSwapiPage;
import com.ricardococati.swapi.gateways.PlanetFromSwapiGateway;
import com.ricardococati.swapi.usecases.FindPlanetFromSwapi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindPlanetFromSwapiImpl implements FindPlanetFromSwapi {

  private final PlanetFromSwapiGateway planetGateway;

  @Override
  public Flux<PlanetFromSwapiPage> execute(Integer page) {
    return planetGateway.findPlanetFromSwapi(page);
  }

}
