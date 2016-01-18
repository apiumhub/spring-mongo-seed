package com.apiumtech.configuration;

import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * Created by roman on 18/01/16.
 */
@Configuration
public class MongoTemplateConfiguration {
    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClientURI("mongodb://localhost:27017/spring_tests"));
    }
}
