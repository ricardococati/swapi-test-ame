package com.ricardococati.swapi.gateways.impl;

import com.ricardococati.swapi.domains.Planet;
import com.ricardococati.swapi.gateways.PlanetGateway;
import com.ricardococati.swapi.gateways.repositories.PlanetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PlanetGatewayImpl implements PlanetGateway {

  private final PlanetRepository repository;

  @Override
  public Mono<Planet> save(final Planet planet) {
    return repository.save(planet);
  }

  @Override
  public Flux<Planet> findPlanet() {
    return repository.findAll();
  }

  @Override
  public Mono<Planet> findPlanetByName(final String name) {
    return repository.findByName(name);
  }

  @Override
  public Mono<Planet> findPlanetById(final String id) {
    return repository.findById(id);
  }

  @Override
  public void deletePlanet(final String id) {
    repository.deleteById(id);
  }

}
