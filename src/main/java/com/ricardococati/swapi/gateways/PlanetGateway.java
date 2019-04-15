package com.ricardococati.swapi.gateways;

import com.ricardococati.swapi.domains.Planet;
import com.ricardococati.swapi.domains.PlanetFromSwapi;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlanetGateway {

  Mono<Planet> save(final Planet planet);

  Flux<Planet> findPlanet();

  Mono<Planet> findPlanetByName(final String name);

  Mono<Planet> findPlanetById(final String id);

  void deletePlanet(final String id);

}
