package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;

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
        String[] fileStrings = fileData.split(" ");
        for (int i = 0;i<fileStrings.length;i++){
            if (fileStrings[i].matches("\\d+")){fileWriter.write(fileStrings[i]+" ");}
        }
        fileWriter.close();
    }
}
