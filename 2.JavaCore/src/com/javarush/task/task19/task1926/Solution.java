package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        BufferedReader fReader = new BufferedReader(fileReader);
        while(true){
            String s = fReader.readLine();
            if (s==null) break;;
            String[] words = s.split("");
            for(int i = words.length-1;i>=0;i--){
            System.out.print(words[i]);}
            System.out.println("");
        }
        fileReader.close();
        fReader.close();
        reader.close();
    }
}
