package com.ricardococati.swapi.gateways.impl;

import static java.util.Objects.nonNull;

import com.ricardococati.swapi.domains.PlanetFromSwapiPage;
import com.ricardococati.swapi.domains.enums.ErrorType;
import com.ricardococati.swapi.exceptions.NotFoundException;
import com.ricardococati.swapi.gateways.PlanetFromSwapiGateway;
import com.ricardococati.swapi.gateways.rest.converter.PlanetsDataContractConverter;
import com.ricardococati.swapi.gateways.rest.data.PlanetsPageDataCrontract;
import com.ricardococati.swapi.utils.URLBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlanetFromSwapiGatewayImpl implements PlanetFromSwapiGateway {

  @Value("${rest.service.uri}")
  private String swapiUri;

  private final WebClient.Builder webClientBuilder;

  @Override
  public Flux<PlanetFromSwapiPage> findPlanetFromSwapi(Integer page) {
    log.info("Executing Star Wars Api");
    URLBuilder param = URLBuilder.builder()
        .service(swapiUri).resource("api/planets/");
        if(nonNull(page)){
          param.param("page", String.valueOf(page));
        }
    final Flux<PlanetFromSwapiPage> swapiFlux =
        webClientBuilder
            .build()
            .get()
            .uri(param.build())
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .retrieve()
            .onStatus(
                HttpStatus::is4xxClientError,
                response ->
                    Mono.error(
                        new NotFoundException(ErrorType.NOT_FOUND_RESOURCE.toString())))
            .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.empty())
            .bodyToFlux(PlanetsPageDataCrontract.class)
            .switchIfEmpty(Flux.empty())
            .map(PlanetsDataContractConverter::convert);
    log.info("Executed Star Wars Api");
    return swapiFlux;
  }
}
