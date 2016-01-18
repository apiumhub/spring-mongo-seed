package com.apiumtech.base;

import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by roman on 18/01/16.
 */

public abstract class BaseDatabaseTest extends BaseTest {
    @Autowired
    protected MongoTemplate mongo;

    @After
    public void tearDown() throws Exception {
        mongo.getDb().dropDatabase();
    }
}
