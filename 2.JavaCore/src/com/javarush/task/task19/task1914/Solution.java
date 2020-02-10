package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String string = outputStream.toString();
        System.setOut(consoleStream);
        int answer = 0;
        String[] strArr = string.split("\\s");
        switch (strArr[1]){
            case "+":
                answer = Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[2]);
                break;
            case "-":
                answer = Integer.parseInt(strArr[0]) - Integer.parseInt(strArr[2]);
                break;
            case "*":
                answer = Integer.parseInt(strArr[0]) * Integer.parseInt(strArr[2]);
                break;
        }

        String str = string.replaceAll(System.lineSeparator(), String.valueOf(answer));
        System.out.print(str);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

