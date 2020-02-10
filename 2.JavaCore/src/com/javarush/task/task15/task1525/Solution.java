package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        try {
            FileReader fileInputStream = new FileReader(Statics.FILE_NAME);
            BufferedReader reader = new BufferedReader(fileInputStream);
            String s = reader.readLine();

            while (s!=null){
                lines.add(s);
                s = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        System.out.println(lines);
    }
}
