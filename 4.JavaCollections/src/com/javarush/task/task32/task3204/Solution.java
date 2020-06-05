package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        String allowed1 = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
        String allowed2 = "abcdefghigklmnopqrstuvwxyz";
        String allowed3 ="1234567890";
        byteStream.write(allowed1.charAt((int)(Math.random()*allowed1.length())));
        byteStream.write(allowed3.charAt((int)(Math.random()*allowed3.length())));
        for (int i=0;i<2;i++){
            byteStream.write(allowed1.charAt((int)(Math.random()*allowed1.length())));
            byteStream.write(allowed2.charAt((int)(Math.random()*allowed2.length())));
            byteStream.write(allowed3.charAt((int)(Math.random()*allowed3.length())));
        }
        return byteStream;
    }
}