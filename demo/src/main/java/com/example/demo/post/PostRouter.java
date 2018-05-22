package com.example.demo.post;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RenderingResponse;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class PostRouter {

    @Bean
    public RouterFunction<ServerResponse> apis(PostHandler handler) {
        return RouterFunctions
                .route(GET("/api/posts")
                .and(accept(MediaType.APPLICATION_JSON)), handler::fetchAll);
    }

    @Bean
    public RouterFunction<RenderingResponse> pages(PostHandler handler) {
        return RouterFunctions
                .route(GET("/")
                .and(accept(MediaType.TEXT_HTML)), handler::index);
    }

}
