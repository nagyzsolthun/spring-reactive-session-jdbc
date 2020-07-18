package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class AppRouter {

    @Bean
    public RouterFunction<ServerResponse> createRouter() {
        return RouterFunctions.route(GET("/hello"), this::handleGetHello);
    }

    private Mono<ServerResponse> handleGetHello(ServerRequest request) {
        return ServerResponse.ok().body(BodyInserters.fromValue("Hello World"));
    }

}

