package com.example.demo.post;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface PostRepository extends ReactiveMongoRepository<Post, String> {

    Mono<Post> findByNo(Long no);
}
