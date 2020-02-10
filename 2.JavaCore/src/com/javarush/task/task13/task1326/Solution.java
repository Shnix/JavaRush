package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
/*
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        BufferedReader r =new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        FileReader f = new FileReader(s);
        ArrayList<Integer> arr = new ArrayList<>();
        try {
            r = new BufferedReader(new FileReader(s));
            String text = null;text.isEmpty();
            while ((text = r.readLine())!=null){
                arr.add(Integer.parseInt(text));
            }
        }
        catch (Exception e){
            r.close();
        }
        Collections.sort(arr);
        for (Integer kek : arr){
            System.out.println(kek);
        }
    }

}