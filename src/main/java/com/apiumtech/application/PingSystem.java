package com.apiumtech.application;

import java.util.List;

import com.apiumtech.domain.ping.Ping;
import com.apiumtech.domain.ping.PingService;


/**
 * Created by roman on 18/01/16.
 */
public class PingSystem {

	private PingService pingService;

	public PingSystem(PingService pingService) {
		this.pingService = pingService;
	}

	public Ping create(String name) {
		return this.pingService.create(name);
	}

	public Ping findByName(String name) {
		return this.pingService.findByName(name);
	}

	public List<Ping> findAll() {
		return this.pingService.findAll();
	}
}
