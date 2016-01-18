package com.apiumtech;

import com.mongodb.MongoClientURI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@SpringBootApplication
public class SpringSeedApplication {

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClientURI("mongodb://localhost:27017/seed"));
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSeedApplication.class, args);
	}
}
