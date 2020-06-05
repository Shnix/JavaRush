package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(),10000);
        testStrategy(new OurHashMapStorageStrategy(),10000);
        testStrategy(new FileStorageStrategy(),100);
        testStrategy(new OurHashBiMapStorageStrategy(),10000);
        testStrategy(new HashBiMapStorageStrategy(),10000);
        testStrategy(new DualHashBidiMapStorageStrategy(),10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> longSet = new HashSet<>();
        for(String string : strings){
            longSet.add(shortener.getId(string));
        }
        return longSet;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> stringSet = new HashSet<>();
        for(Long key : keys){
            stringSet.add(shortener.getString(key));
        }
        return stringSet;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());
        HashSet<String> s = new HashSet<>();
        for (int i=0;i<elementsNumber;i++) {
            s.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        Date date1 = new Date();
        Set<Long> longs = getIds(shortener,s);
        Date date2 = new Date();
        Helper.printMessage(String.valueOf(date2.getTime()-date1.getTime()));
        Date date3 = new Date();
        Set<String> resultStrings = getStrings(shortener,longs);
        Date date4 = new Date();
        Helper.printMessage(String.valueOf(date4.getTime()-date3.getTime()));
        if(resultStrings.equals(s)){
            Helper.printMessage("Тест пройден.");
        }
        else {
            Helper.printMessage("Тест не пройден.");
        }
    }
}
