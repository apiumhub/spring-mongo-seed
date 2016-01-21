package com.apiumtech.domain.ping;

import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * Created by roman on 18/01/16.
 */
public class PingService {
	private PingRepository repository;

	public PingService(@NotNull PingRepository repository) {
		this.repository = repository;
	}

	public Ping create(String name) {
		Ping ping = new Ping(name);
		return this.repository.save(ping);
	}

	public Ping findByName(String name) {
		return this.repository.findByName(name);
	}

	public List<Ping> findAll() {
		return this.repository.findAll();
	}
}
