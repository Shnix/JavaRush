package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int kek = 0;
        int sum;
        int count=0;
        while(fileInputStream.available()>0){
            sum=fileInputStream.read();
            kek++;
            if (sum==32){
                count++;
            }
        }
        fileInputStream.close();
        float result = (float)count/( float)kek*100.f;
        System.out.printf("%.2f",result);
    }

}
