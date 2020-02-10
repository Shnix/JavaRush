package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String fileData = "";
        StringBuilder stringBuilder = new StringBuilder();
        while(fileReader.ready()) {
            fileData = fileReader.readLine();
            stringBuilder.append(" " + fileData);
        }
        fileReader.close();
        String fullData = stringBuilder.toString();
        String[] s = fullData.split("\\W");
        int count = 0;
        for(int i=0;i<s.length;i++){
            if(s[i].equals("world")){
                count++;
            }
        }
        System.out.println(count);
    }
}
