package com.ricardococati.swapi.gateways.http;

import com.ricardococati.swapi.gateways.http.converter.PlanetConverter;
import com.ricardococati.swapi.gateways.http.converter.PlanetFromSwapiConverter;
import com.ricardococati.swapi.gateways.http.json.PlanetFromSwapiPageJson;
import com.ricardococati.swapi.gateways.http.json.PlanetJson;
import com.ricardococati.swapi.usecases.CreatePlanet;
import com.ricardococati.swapi.usecases.DeletePlanet;
import com.ricardococati.swapi.usecases.FindPlanet;
import com.ricardococati.swapi.usecases.FindPlanetById;
import com.ricardococati.swapi.usecases.FindPlanetByName;
import com.ricardococati.swapi.usecases.FindPlanetFromSwapi;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/planets")
@RequiredArgsConstructor
@Slf4j
public class PlanetsController {

  private final CreatePlanet createPlanet;
  private final FindPlanet findPlanet;
  private final FindPlanetByName findPlanetByName;
  private final FindPlanetById findPlanetById;
  private final FindPlanetFromSwapi findPlanetFromSwapi;
  private final DeletePlanet deletePlanetById;

  @PostMapping
  public Mono<ResponseEntity> createPlanet(
      @Valid @RequestBody final PlanetJson planetJson) {
    return createPlanet
        .execute(PlanetConverter.convertPlanetJsonToPlanet(planetJson))
        .map(ResponseEntity::ok);
  }

  @GetMapping
  public Flux<PlanetJson> findAllPlanets() {
    return findPlanet
        .execute()
        .map(PlanetConverter::convertPlanetToJson);
  }

  @GetMapping("/swapi")
  public Flux<PlanetFromSwapiPageJson> findAllPlanetsFromSwapi(
      @RequestParam(value = "page", required = false) Integer page
  ) {
    return findPlanetFromSwapi
        .execute(page)
        .map(PlanetFromSwapiConverter::convert);
  }

  @GetMapping("/planetbyname")
  public Mono<ResponseEntity> findPlanetByName(
      @RequestParam(value = "name") String name
  ) {
    return findPlanetByName
        .execute(name)
        .map(ResponseEntity::ok);
  }

  @GetMapping("/{id}")
  public Mono<ResponseEntity> findPlanetById(
      @PathVariable String id
  ) {
    return findPlanetById
        .execute(id)
        .map(ResponseEntity::ok);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> removePlanet(
      @PathVariable String id
  ) {
    deletePlanetById.execute(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }

}
