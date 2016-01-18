package com.apiumtech.infrastructure.ping;

import com.apiumtech.base.BaseDatabaseTest;
import com.apiumtech.domain.ping.Ping;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by roman on 18/01/16.
 */
public class MongoPingRepositoryTest extends BaseDatabaseTest {

    public static final String PING_NAME = "test";

    private MongoPingRepository repository() {
        return new MongoPingRepository(mongo);
    }
    
    public Ping exercise_createPing(String name, Date date){
        return new Ping(name, date);
    }
    
    @Test
    public void test_save_shouldNotThrowAnException() {
        repository().save(new Ping("Hello!"));
    }
    
    @Test
    public void test_save_whenValidPing_shouldSave() {
        Ping expected = this.exercise_createPing(PING_NAME, new Date(123456789));
        Ping actual = this.repository().save(expected);
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void test_findByName_whenValidName_shouldFind(){
        Ping expected = this.exercise_createPing(PING_NAME, new Date(123456789));
        this.repository().save(expected);
        Ping actual = this.repository().findByName(PING_NAME);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void test_findByName_whenInvalidName_shouldThrowException(){
        this.repository().findByName(PING_NAME);
    }
    
    @Test
    public void test_findAll_whenTwoPings_shouldReturnAll(){
        this.repository().save(this.exercise_createPing(PING_NAME, new Date(123456789)));
        this.repository().save(this.exercise_createPing(PING_NAME + "2", new Date(123456999)));
        List<Ping> pings = this.repository().findAll();
        Assert.assertEquals(2, pings.size());
    }
    
    @Test
    public void test_findAll_whenNoPings_shouldReturnEmptyList(){
        List<Ping> pings = this.repository().findAll();
        Assert.assertTrue(pings.isEmpty());
    }
}
