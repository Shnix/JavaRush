package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Solution {
    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException {
        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
        byte[] file1 = new byte[fileInputStream.available()];
        fileInputStream.read(file1);
        fileInputStream.close();
            byte key = '5';

            switch (args[0]) {

                case ("-e"): {  for (int i = 0; i < file1.length; i++) { file1[i] = (byte) (file1[i] ^ key); }}break;

                case ("-d"): {  for (int i = 0; i < file1.length; i++) { file1[i] = (byte) (file1[i] ^ key); }}break;
            }
        for (int j = 0; j < file1.length; j++) {
            fileOutputStream.write(file1[j]);
            fileOutputStream.close();
        }
    }
}


