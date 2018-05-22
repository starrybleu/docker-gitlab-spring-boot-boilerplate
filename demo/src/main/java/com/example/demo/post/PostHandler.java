package com.example.demo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RenderingResponse;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PostHandler {

    @Autowired
    private final PostRepository postRepository;

    public PostHandler(@Qualifier("postRepository") PostRepository repository) {
        this.postRepository = repository;
    }

    Mono<ServerResponse> fetchAll(ServerRequest request) {
        Flux<Post> posts = postRepository.findAll();
        System.out.println(posts);
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(posts, Post.class);
    }

    Mono<RenderingResponse> index(ServerRequest request) {
        Flux<Post> posts = postRepository.findAll();
        return RenderingResponse.create("index")
                .modelAttribute("posts", posts)
                .build();
    }

}
