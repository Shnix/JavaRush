package com.javarush.task.task19.task1924;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        BufferedReader fileReader1 = new BufferedReader(fileReader);
        while(true){
            String result = "";
            String s = fileReader1.readLine();
            if (s==null) break;
            String[] phrase = s.split("\\s");
            for(int i = 0;i<phrase.length;i++){
                String kek = "";
                if(phrase[i].matches("\\d")||phrase[i].matches("12")||phrase[i].matches("11")) kek=map.get(Integer.parseInt(phrase[i]));
                else kek = phrase[i];
                result=result+ kek + " ";
            }
            System.out.println(result.substring(0,result.length()-1));
        }
        reader.close();
        fileReader.close();
        fileReader1.close();


    }
}
