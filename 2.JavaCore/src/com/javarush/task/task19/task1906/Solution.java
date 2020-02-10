package com.javarush.task.task19.task1906;

/* 
Четные символы
*/


import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            ArrayList<Integer> kek = new ArrayList<>();
            FileReader fileReader = new FileReader(r.readLine());
            FileWriter fileWriter = new FileWriter(r.readLine());
            r.close();
            int data;
            while(fileReader.ready()){
                data = fileReader.read();
                kek.add(data);
            }
            fileReader.close();
            for(int i = 1;i<kek.size();i=i+2) {
                fileWriter.write(kek.get(i));
            }

            fileWriter.close();
    }
}
