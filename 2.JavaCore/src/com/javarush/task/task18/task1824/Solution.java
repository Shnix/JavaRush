package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String fileName=r.readLine();
            try(FileInputStream fileInputStream = new FileInputStream(fileName);){
            int sum = fileInputStream.read();}
             catch (FileNotFoundException e) {
                System.out.println(fileName);
                break;
            }
        }
    }
}
