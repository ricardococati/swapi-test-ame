package com.ricardococati.swapi.gateways;

import com.ricardococati.swapi.domains.Planet;
import com.ricardococati.swapi.domains.PlanetFromSwapi;
import com.ricardococati.swapi.domains.PlanetFromSwapiPage;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlanetFromSwapiGateway {

  Flux<PlanetFromSwapiPage> findPlanetFromSwapi(Integer page);

}
