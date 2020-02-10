package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader fileLinesReader = new BufferedReader(fileReader);
        while(fileLinesReader.ready()){
            String line = fileLinesReader.readLine();
            if (line==null) break;
            String[] lines = line.split("\\s");
            int count = 0;
            for (int i = 0;i<lines.length;i++){
                for (int j = 0;j<words.size();j++){
                    if (words.get(j).equals(lines[i])) count++;
                }
            }
            if (count==2) System.out.println(line);
        }
        fileReader.close();
        fileLinesReader.close();

    }
}
