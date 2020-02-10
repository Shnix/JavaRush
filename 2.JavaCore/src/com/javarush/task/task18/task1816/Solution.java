package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/


import java.io.FileInputStream;
import java.io.IOException;


public class Solution {
    public static void main(String[] args) throws IOException {


        String fileName = args[0];
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int count = 0;
        int sum;
        while(fileInputStream.available()>0){
            sum = fileInputStream.read();
            if (sum>64 & sum<91 || sum>96 & sum<123){
                count++;
            }
        }
        fileInputStream.close();
        System.out.println(count);



    }
}
