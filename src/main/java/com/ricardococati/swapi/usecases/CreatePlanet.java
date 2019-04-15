package com.ricardococati.swapi.usecases;

import com.ricardococati.swapi.domains.Planet;
import reactor.core.publisher.Mono;

public interface CreatePlanet {

  Mono<Planet> execute(final Planet planet);

}
