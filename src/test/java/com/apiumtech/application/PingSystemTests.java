package com.apiumtech.application;

import com.apiumtech.base.BaseTest;
import com.apiumtech.domain.ping.Ping;
import com.apiumtech.domain.ping.PingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by roman on 18/01/16.
 */
public class PingSystemTests extends BaseTest {
    
    public static final Ping EXAMPLE_PING = new Ping("test");
    private PingSystem sut;

    @Before
    public void setUp(){
        PingService pingService = mock(PingService.class);
        when(pingService.create(anyString())).thenReturn(EXAMPLE_PING);
        when(pingService.findByName(anyString())).thenReturn(EXAMPLE_PING);
        when(pingService.findAll()).thenReturn(new ArrayList<Ping>());
        this.sut = new PingSystem(pingService);
    }
    
    @Test 
    public void test_create_whenValidName_shouldCreate(){
        Ping actual = this.sut.create("test");
        Assert.assertEquals(EXAMPLE_PING, actual);
    }
    
    @Test
    public void test_findByName_whenValidName_shouldFindPing(){
        Ping actual = this.sut.findByName("test");
        Assert.assertEquals(EXAMPLE_PING, actual);
    }
    
    @Test
    public void test_findAll_shouldReturnList(){
        List<Ping> pings = this.sut.findAll();
        Assert.assertTrue(pings.isEmpty());
    }
}
