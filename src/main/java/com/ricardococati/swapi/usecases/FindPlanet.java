package com.ricardococati.swapi.usecases;

import com.ricardococati.swapi.domains.Planet;
import reactor.core.publisher.Flux;

public interface FindPlanet {

  Flux<Planet> execute();

}
