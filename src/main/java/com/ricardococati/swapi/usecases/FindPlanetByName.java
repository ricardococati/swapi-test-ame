package com.ricardococati.swapi.usecases;

import com.ricardococati.swapi.domains.Planet;
import reactor.core.publisher.Mono;

public interface FindPlanetByName {

  Mono<Planet> execute(final String name);

}
