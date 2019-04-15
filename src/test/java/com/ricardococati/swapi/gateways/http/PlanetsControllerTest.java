package com.ricardococati.swapi.gateways.http;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

import com.ricardococati.swapi.domains.Planet;
import com.ricardococati.swapi.domains.PlanetFromSwapiPage;
import com.ricardococati.swapi.gateways.http.json.PlanetFromSwapiPageJson;
import com.ricardococati.swapi.gateways.http.json.PlanetJson;
import com.ricardococati.swapi.usecases.CreatePlanet;
import com.ricardococati.swapi.usecases.DeletePlanet;
import com.ricardococati.swapi.usecases.FindPlanet;
import com.ricardococati.swapi.usecases.FindPlanetById;
import com.ricardococati.swapi.usecases.FindPlanetByName;
import com.ricardococati.swapi.usecases.FindPlanetFromSwapi;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@WebFluxTest(PlanetsController.class)
public class PlanetsControllerTest {

  @MockBean
  private CreatePlanet createPlanet;
  @MockBean
  private FindPlanet findPlanet;
  @MockBean
  private FindPlanetFromSwapi findPlanetFromSwapi;
  @MockBean
  private FindPlanetByName findPlanetByName;
  @MockBean
  private FindPlanetById findPlanetById;
  @MockBean
  private DeletePlanet deletePlanet;
  @Autowired
  private WebTestClient client;

  private static final String BASE_URL = "/api/planets";

  @Test
  public void createPlanet() {
    Planet domain = getPlanet();
    PlanetJson json = getPlanetJson();
    given(this.createPlanet.execute(Mockito.any()))
        .willReturn(Mono.just(domain));

    client
        .post()
        .uri(BASE_URL)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .body(Mono.just(json), PlanetJson.class)
        .exchange()
        .expectStatus()
        .isOk();
  }

  @Test
  public void createPlanetError() {
    Planet domain = getPlanet();
    PlanetJson json = getPlanetJson();
    given(this.createPlanet.execute(Mockito.any()))
        .willReturn(null);

    client
        .post()
        .uri(BASE_URL)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .body(Mono.just(json), PlanetJson.class)
        .exchange()
        .expectStatus()
        .is5xxServerError();
  }

  @Test
  public void findAllPlanets() {
    List<PlanetJson> returnedJSON = new ArrayList<>();
    returnedJSON.add(getPlanetJson());
    returnedJSON.add(getPlanetJson());
    List<Planet> returnedDomain = new ArrayList<>();
    returnedDomain.add(getPlanet());
    returnedDomain.add(getPlanet());
    given(findPlanet.execute())
        .willReturn(Flux.fromIterable(returnedDomain));

    client.get()
        .uri(BASE_URL)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBodyList(PlanetJson.class)
        .hasSize(2);
  }

  @Test
  public void findAllPlanetsError() {
    List<PlanetJson> returnedJSON = new ArrayList<>();
    returnedJSON.add(getPlanetJson());
    returnedJSON.add(getPlanetJson());
    List<Planet> returnedDomain = new ArrayList<>();
    returnedDomain.add(getPlanet());
    returnedDomain.add(getPlanet());
    given(findPlanet.execute())
        .willReturn(null);

    client.get()
        .uri(BASE_URL)
        .exchange()
        .expectStatus()
        .is5xxServerError();
  }

  @Test
  public void findAllPlanetsFromSwapi() {
    List<PlanetFromSwapiPageJson> returnedJSON = new ArrayList<>();
    returnedJSON.add(getPlanetFromSwapiPageJson());
    returnedJSON.add(getPlanetFromSwapiPageJson());
    List<PlanetFromSwapiPage> returnedDomain = new ArrayList<>();
    returnedDomain.add(getPlanetFromSwapiPage());
    returnedDomain.add(getPlanetFromSwapiPage());
    given(findPlanetFromSwapi.execute(anyInt()))
        .willReturn(Flux.fromIterable(returnedDomain));

    client.get()
        .uri(BASE_URL + "/swapi/?page=1")
        .exchange()
        .expectStatus()
        .isOk()
        .expectBodyList(PlanetFromSwapiPageJson.class)
        .hasSize(2);
  }

  @Test
  public void findPlanetByName() {
    Planet domain = getPlanet();
    PlanetJson json = getPlanetJson();
    given(this.findPlanetByName.execute(Mockito.any()))
        .willReturn(Mono.just(domain));

    client.get()
        .uri(BASE_URL + "/planetbyname/?name='1234'")
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody(PlanetJson.class);
  }

  @Test
  public void findPlanetById() {
    Planet domain = getPlanet();
    PlanetJson json = getPlanetJson();
    given(this.findPlanetById.execute(Mockito.any()))
        .willReturn(Mono.just(domain));

    client.get()
        .uri(BASE_URL + "/'1234'")
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody(PlanetJson.class);
  }

  @Test
  public void removePlanet() {
    client.delete()
        .uri(BASE_URL + "/'1234'")
        .exchange()
        .expectStatus()
        .isNoContent();
  }

  @Test
  public void removePlanetError() {
    client.delete()
        .uri(BASE_URL + "/")
        .exchange()
        .expectStatus()
        .is4xxClientError();
  }

  private Planet getPlanet() {
    return Planet
        .builder()
        .id("1234")
        .climate("Hot")
        .name("Saturn")
        .terrain("1234")
        .build();
  }

  private PlanetJson getPlanetJson() {
    return PlanetJson
        .builder()
        .id("1234")
        .climate("Hot")
        .name("Saturn")
        .terrain("1234")
        .build();
  }

  private PlanetFromSwapiPageJson getPlanetFromSwapiPageJson() {
    return PlanetFromSwapiPageJson.builder()
        .count(1)
        .next("1")
        .previous("")
        .results(new ArrayList<>())
        .build();
  }

  private PlanetFromSwapiPage getPlanetFromSwapiPage() {
    return PlanetFromSwapiPage.builder()
        .count(1)
        .next("1")
        .previous("")
        .results(new ArrayList<>())
        .build();
  }

}