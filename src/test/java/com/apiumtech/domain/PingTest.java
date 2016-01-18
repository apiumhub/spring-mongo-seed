package com.apiumtech.domain;

import com.apiumtech.base.BaseTest;
import com.apiumtech.domain.ping.Ping;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by roman on 18/01/16.
 */
public class PingTest extends BaseTest {
    
     @Test
    public void test_ping_whenValidParams_shouldConstructPing(){
         Ping ping = new Ping("test", new Date(123456789)); 
         Assert.assertEquals(ping.toString(), "Ping{name='test', created=Fri Jan 02 11:17:36 CET 1970}");
     }
    @Test(expected = IllegalArgumentException.class)
    public void test_ping_whenInvalidParams_shouldThrowException(){
        new Ping("");
    }
}
