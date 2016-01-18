package com.apiumtech.domain;

import com.apiumtech.base.BaseTest;
import com.apiumtech.domain.ping.Ping;
import com.apiumtech.domain.ping.PingRepository;
import com.apiumtech.domain.ping.PingService;
import javafx.beans.binding.When;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;



/**
 * Created by roman on 18/01/16.
 */
public class PingServiceTest extends BaseTest {

    public static final Ping EXAMPLE_PING = new Ping("test");
    private PingService sut;
    
    @Before
    public void setUp(){
        PingRepository pingRepository = mock(PingRepository.class);
        when(pingRepository.save(any())).thenReturn(EXAMPLE_PING);
        when(pingRepository.findByName(anyString())).thenReturn(EXAMPLE_PING);
        when(pingRepository.findAll()).thenReturn(new ArrayList<Ping>());
        this.sut = new PingService(pingRepository);
    }
    
    @Test
    public void test_create_whenValidName_shouldReturnPing(){
        Ping actual = this.sut.create("test");
        Assert.assertEquals(EXAMPLE_PING, actual);
    }
    
    @Test
    public void test_findByName_whenValidName_shouldReturnPing(){
        Ping actual = this.sut.findByName("test");
        Assert.assertEquals(EXAMPLE_PING, actual);
    }
    
    @Test
    public void test_findAll_shouldReturnList(){
        List<Ping> pings = this.sut.findAll();
        Assert.assertTrue(pings.isEmpty());
    }
}
