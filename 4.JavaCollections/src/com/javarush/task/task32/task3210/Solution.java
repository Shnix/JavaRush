package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {
        String filename = args[0];
        int position = Integer.parseInt(args[1]);
        String text = args[2];
        RandomAccessFile raf = new RandomAccessFile(filename,"rw");
        byte[] textBytes = new byte[text.getBytes().length];
        raf.seek(position);
        raf.read(textBytes,0,text.length());
        if (text.equals(new String(textBytes))){
            raf.seek(raf.length());
            raf.write("true".getBytes());
        }
        else{
            raf.seek(raf.length());
            raf.write("false".getBytes());
        }
    }
}
