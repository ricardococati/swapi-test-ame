package com.ricardococati.swapi.usecases;

import com.ricardococati.swapi.domains.PlanetFromSwapiPage;
import reactor.core.publisher.Flux;

public interface FindPlanetFromSwapi {

  Flux<PlanetFromSwapiPage> execute(Integer page);

}
