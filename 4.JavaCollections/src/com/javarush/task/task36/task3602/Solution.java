package com.javarush.task.task36.task3602;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
            System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class<?>[] classes = Collections.class.getDeclaredClasses();
        for (Class  clazz : classes){
            if(Arrays.asList(clazz.getInterfaces()).contains(List.class) ||
               Arrays.asList(clazz.getSuperclass().getInterfaces()).contains(List.class)){

                if(Modifier.isPrivate(clazz.getModifiers()) && Modifier.isStatic(clazz.getModifiers())) {
                    try {
                        if(clazz.getDeclaredConstructor().getParameterCount() == 0){
                            return clazz;
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        return List.class;
    }
}
