package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(r.readLine());
        int sum=0;
        int result = 0;
        while (fileInputStream.available()>0){
            sum=fileInputStream.read();
            if (sum==44){
                result++;
            }
        }
        fileInputStream.close();
        System.out.print(result);

    }
}
