package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.Collections;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList<Throwable> list = new ArrayList<>();
        while(e!=null){
        list.add(e);
        e=e.getCause();
        }
        Collections.reverse(list);
        for (Throwable r : list){
            System.out.println(r.getClass().getName() + ": " + r.getMessage());
        }
    }

    public static void main(String[] args) {
        new Solution().uncaughtException(Thread.currentThread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}


