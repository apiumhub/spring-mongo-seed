package com.apiumtech.domain.ping;

import java.util.List;

/**
 * Created by roman on 18/01/16.
 */
public interface PingRepository {
    Ping save(Ping ping);
    Ping findByName(String name);

    List<Ping> findAll();
}
