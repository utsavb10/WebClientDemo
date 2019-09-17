package com.webClientApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

@Service
public class WebClientClass implements WebClientInterface{

  private static final Logger LOGGER = Logger.getLogger(WebClientClass.class.getName());
  private final WebClient webClient;

  @Value("${url1}")
  private String url1;

  @Value("${url2}")
  private String url2;

  @Value("${url3}")
  private String url3;

  public WebClientClass() {
    this.webClient = WebClient
      .builder()
      .build();
  }

  @Override
  public Mono<String> receiveResponse(String url) {
    Mono<String> res = webClient.get().uri(URI.create(url))
      .retrieve()
      .bodyToMono(String.class);
    return res;
  }



  public void getAllResponses(){

    Mono<String> res1 = receiveResponse(url1);
    Mono<String> res2 = receiveResponse(url2);
    Mono<String> res3 = receiveResponse(url3);

    Flux.merge(res1, res2, res3).subscribe(res -> System.out.println(res));
  }
}
