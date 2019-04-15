package com.ricardococati.swapi.usecases;

import com.ricardococati.swapi.domains.Planet;
import reactor.core.publisher.Mono;

public interface FindPlanetById {

  Mono<Planet> execute(final String id);

}
