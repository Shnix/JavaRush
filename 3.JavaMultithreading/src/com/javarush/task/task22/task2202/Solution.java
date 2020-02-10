package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string==null){throw new TooShortStringException();}
        String[] kek = string.split("\\s");
        if (kek.length<5){ throw new TooShortStringException();}
        String result = "";
        for (int i=1;i<=4;i++){
            result+=kek[i] + " ";
        }
        result = result.trim();
        return result;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
