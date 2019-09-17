package com.webClientApp;

import reactor.core.publisher.Mono;

public interface WebClientInterface {
  public Mono<String> receiveResponse(String url);
}
