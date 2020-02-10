package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(r.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(r.readLine());
        byte[] buffer =  new byte[fileInputStream.available()];
        int sum;
        while(fileInputStream.available()>0){
            sum=fileInputStream.read(buffer);
        }
        //List<Byte> list= new LinkedList(Collections.singleton(buffer));
        for (int i = buffer.length-1;i>=0;i--){
            fileOutputStream.write(buffer[i]);
        }
        fileInputStream.close();
        fileOutputStream.close();


    }
}
