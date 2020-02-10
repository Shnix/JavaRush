package com.javarush.task.task13.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileWriter f;
              try{
            while (true){
                String d = r.readLine();
                if (d.equals("exit"))
                    break;
                f = new FileWriter(d);

            }
        }
        catch (Exception e){
            r.close();

        }
        r.close();

    }
}
