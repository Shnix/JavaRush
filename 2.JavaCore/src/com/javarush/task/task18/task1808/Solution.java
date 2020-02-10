package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(r.readLine());
        FileOutputStream fileOutputStream1 = new FileOutputStream(r.readLine());
        FileOutputStream fileOutputStream2 = new FileOutputStream(r.readLine());
        int half = fileInputStream.available()/2;
        int sum = 0;
        while(fileInputStream.available()>half){
            sum = fileInputStream.read();
            fileOutputStream1.write(sum);
        }
        while(fileInputStream.available()>0){
            sum = fileInputStream.read();
            fileOutputStream2.write(sum);
        }
        fileInputStream.close();
        fileOutputStream1.close();
        fileOutputStream2.close();


    }
}
