package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);
        BufferedReader reader = new BufferedReader(fileReader);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        while(reader.ready()){
            String s = reader.readLine();
            if (s==null) break;
            String[] words = s.split("\\s");
            for (int i = 0;i<words.length;i++){
                if (words[i].matches(".*[0-9]+.*")) writer.write(words[i]+" ");
            }
        }
        reader.close();
        writer.close();
        fileReader.close();
        fileWriter.close();

    }
}
