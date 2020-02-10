package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);
        BufferedReader reader = new BufferedReader(fileReader);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        String kek="";
        while(reader.ready()){
            String s = reader.readLine();
            if (s==null) break;
            String[] words = s.split("\\s");
            for (int i=0;i<words.length;i++){
                if (words[i].length()>6) kek+=words[i]+",";
            }
        }
        writer.write(kek.substring(0,kek.length()-1));
        reader.close();
        writer.close();
        fileReader.close();
        fileWriter.close();


    }
}
