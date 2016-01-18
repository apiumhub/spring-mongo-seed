package com.apiumtech.domain.ping;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by roman on 18/01/16.
 */
public class Ping {
    @Id
    private String name;
    private Date created;

    public Ping(String name, Date created) {
        if(name.equals("")){
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
                "name='" + name + '\'' +
                ", created=" + created +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ping ping = (Ping) o;

        if (name != null ? !name.equals(ping.name) : ping.name != null) return false;
        return !(created != null ? !created.equals(ping.created) : ping.created != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }
}
