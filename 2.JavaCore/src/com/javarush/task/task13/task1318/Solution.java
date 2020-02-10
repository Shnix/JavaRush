package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String d = reader.readLine();
        InputStream i = new FileInputStream(d);
        reader.close();
        try {
            while (i.available() > 0) {
                int data = i.read();
                System.out.write(data);
            }
        }
        catch (IOException e){
            i.close();
        }
        i.close();

    }
}