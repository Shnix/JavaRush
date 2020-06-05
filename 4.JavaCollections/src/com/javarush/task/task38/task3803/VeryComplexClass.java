package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class VeryComplexClass {
    public void methodThrowsClassCastException() throws ClassCastException {
        HashMap<Integer,Integer> map = new HashMap<>();
        System.out.println((Set) map);
    }

    public void methodThrowsNullPointerException() throws NullPointerException  {
        ArrayList<Integer> k = null;
        k.get(1);
    }

    public static void main(String[] args) {

    }
}
