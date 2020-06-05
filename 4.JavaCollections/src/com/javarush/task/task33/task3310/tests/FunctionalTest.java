package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Test;

import org.junit.Assert;

public class FunctionalTest {

    public void testStorage(Shortener shortener){
        String one = "kek";
        String two = "lmao";
        String three = "kek";

        Long first = shortener.getId(one);
        Long second = shortener.getId(two);
        Long third = shortener.getId(three);

        Assert.assertNotEquals(one,two);
        Assert.assertNotEquals(three,two);
        Assert.assertEquals(one,three);

        Assert.assertEquals(one,shortener.getString(first));
        Assert.assertEquals(two,shortener.getString(second));
        Assert.assertEquals(three,shortener.getString(third));
    }

    @Test
    public void testHashMapStorageStrategy() {
        Shortener shortener =  new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        Shortener shortener =  new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        Shortener shortener =  new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        Shortener shortener =  new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        Shortener shortener =  new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        Shortener shortener =  new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }
}
