package com.ricardococati.swapi.gateways.repositories;

import com.ricardococati.swapi.domains.Planet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PlanetRepository extends ReactiveMongoRepository<Planet, String> {

  Mono<Planet> findByName(final String name);

}

