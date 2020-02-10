package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();
        FileInputStream fis1 = new FileInputStream(name1);
        byte[] file1 = new byte[fis1.available()];
        fis1.read(file1);
        fis1.close();
        FileInputStream fis2 = new FileInputStream(name2);
        byte[] file2 = new byte[fis2.available()];
        fis2.read(file2);
        fis2.close();
        byte[] file = new byte[file1.length+file2.length];
        System.arraycopy(file2,0,file,0,file2.length);
        System.arraycopy(file1,0,file,file2.length,file1.length);
        FileOutputStream fos = new FileOutputStream(name1);
        fos.write(file);
        fos.close();
    }
}
