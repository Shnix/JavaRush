package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(r.readLine());
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while (fileInputStream.available()>0){
            sum = fileInputStream.read();
            if (sum<result){
                result = sum;
            }
        }
        fileInputStream.close();
        System.out.println(result);
    }
}
