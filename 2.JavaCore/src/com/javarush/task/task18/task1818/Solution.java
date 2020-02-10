package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String file1 = r.readLine();
        String file2 = r.readLine();
        String file3 = r.readLine();
        FileInputStream fileInputStream2 = new FileInputStream(file2);
        FileInputStream fileInputStream3 = new FileInputStream(file3);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file1);
        int sum;
        while(fileInputStream2.available()>0){
            sum = fileInputStream2.read();
            fileOutputStream2.write(sum);
        }
        fileInputStream2.close();

        while(fileInputStream3.available()>0){
            sum = fileInputStream3.read();
            fileOutputStream2.write(sum);
        }
        fileInputStream3.close();
        fileOutputStream2.close();
    }
}
