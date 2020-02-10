package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

/*
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();

        reader.close();

        FileInputStream fileRead = new FileInputStream(s);

        List<Integer> list = new ArrayList<Integer>();

        while (fileRead.available() > 0) {
            list.add(fileRead.read());
        }

        fileRead.close();

        int f = 0; // максимальное количество повторений
        int kek = 0;
        for (int i = 0; i < list.size(); i++) {
            int k = 0;
            for (int j = 1; j < list.size(); j++) {
                if (list.get(j) == list.get(i)) k++;
            }
            if (k > f) {
                f = k;
                kek = list.get(i);
            }
        }
        System.out.print(kek+" ");

        for (int i = 0; i < list.size(); i++) {
            int k = 0;
            for (int j = 1; j < list.size(); j++) {
                if (list.get(j) == list.get(i)) k++;
            }
            if (k == f && list.get(i)!=kek) {
                System.out.print(list.get(i) + " ");
            }
        }
    }
}
