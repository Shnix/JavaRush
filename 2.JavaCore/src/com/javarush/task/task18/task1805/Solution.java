package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream inputStream = new FileInputStream(file);
        while (inputStream.available() > 0) {
            list.add(inputStream.read());
        }
        inputStream.close();
        Set<Integer> s = new LinkedHashSet<>(list);
        list.clear();
        list.addAll(s);
        Collections.sort(list);
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
}
