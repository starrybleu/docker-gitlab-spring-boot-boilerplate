package com.example.demo.config;

import com.mongodb.ConnectionString;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.example.demo.post.PostRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableMongoAuditing
@EnableReactiveMongoRepositories(
        basePackageClasses = {PostRepository.class}
        )
public class MongoDBConfig extends AbstractReactiveMongoConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.uri}")
    private String uri;

    @Override
    protected String getDatabaseName() {
        System.out.println(database);
        return database;
    }

    @Bean
    @Override
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
    }

    @Bean
    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create(new ConnectionString(uri));
    }

}
