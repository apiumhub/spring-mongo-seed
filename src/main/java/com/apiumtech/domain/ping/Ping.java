package com.apiumtech.domain.ping;

import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * Created by roman on 18/01/16.
 */
public class Ping {
	@Id
	private String name;
	private Date created;

	public Ping(String name, Date created) {
		if (name.equals("")) {
			throw new IllegalArgumentException("invalid name");
		}
		this.name = name;
		this.created = created;
	}

	public Ping(String name) {
		this(name, new Date());
	}

	public Ping() {
	}

	@Override
	public String toString() {
		return "Ping{" +
				"name='" + this.name + '\'' +
				", created=" + this.created +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Ping ping = (Ping) o;

		if (this.name != null ? !this.name.equals(ping.name) : ping.name != null) {
			return false;
		}
		boolean found = this.created != null ? !this.created.equals(ping.created) : ping.created != null;
		return !found;

	}

	@Override
	public int hashCode() {
		int result = this.name != null ? this.name.hashCode() : 0;
		result = 31 * result + (this.created != null ? this.created.hashCode() : 0);
		return result;
	}
}
