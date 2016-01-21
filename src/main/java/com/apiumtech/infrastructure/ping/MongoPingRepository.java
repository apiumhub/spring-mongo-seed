package com.apiumtech.infrastructure.ping;

import java.util.List;
import java.util.NoSuchElementException;

import com.apiumtech.domain.ping.Ping;
import com.apiumtech.domain.ping.PingRepository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Created by roman on 18/01/16.
 */
public class MongoPingRepository implements PingRepository {
	private MongoTemplate mongoTemplate;

	public MongoPingRepository(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public Ping save(Ping ping) {
		this.mongoTemplate.save(ping);
		return ping;
	}

	public Ping findByName(String name) {
		Ping ping = this.mongoTemplate.findOne(idQuery(name), Ping.class);
		if (ping == null) {
			throw new NoSuchElementException("Ping with name:" + name + " does not exist.");
		}
		return ping;
	}

	public List<Ping> findAll() {
		return this.mongoTemplate.findAll(Ping.class);
	}

	private Query idQuery(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		return query;
	}
}
