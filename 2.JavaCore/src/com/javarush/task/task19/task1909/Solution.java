package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(r.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(r.readLine()));
        r.close();
        StringBuilder stringBuilder = new StringBuilder();
        while(fileReader.ready()){
            stringBuilder.append((char) fileReader.read());
        }
        fileReader.close();
        String fileData = stringBuilder.toString();
        String[] words = fileData.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        for (String a : words){
            fileWriter.write(a);
        }
        fileWriter.close();
    }
}
