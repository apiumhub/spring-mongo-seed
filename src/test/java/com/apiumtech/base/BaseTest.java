package com.apiumtech.base;

import com.apiumtech.SpringSeedApplication;
import com.apiumtech.configuration.MongoTemplateConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by roman on 18/01/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { SpringSeedApplication.class, MongoTemplateConfiguration.class })
@WebAppConfiguration
public abstract class BaseTest {
}
