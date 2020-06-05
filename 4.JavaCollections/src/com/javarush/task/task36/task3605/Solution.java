package com.javarush.task.task36.task3605;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path path =  Paths.get(args[0]);
        TreeSet<Character> characters = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        for(String fileString : Files.readAllLines(path)){
            sb.append(fileString);
        }
        String result = sb.toString().replaceAll("\\s", "").replaceAll("\\d", "").replaceAll("\\W", "");
        for(int i =0;i<result.length();i++){
            if(Character.isLetter(result.charAt(i))){
                characters.add(result.toLowerCase().charAt(i));
            }
        }
        int i=1;
        for(Character a : characters){
            if(i>5){break;}
            System.out.print(a);
            i++;
        }
    }
}
