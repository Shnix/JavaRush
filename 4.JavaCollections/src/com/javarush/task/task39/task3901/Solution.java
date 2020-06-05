package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int help = 1;
        int result = 1;
        int n = 0;
        for(int i = 1;i<s.length();i++){
        String res = s.substring(n,i);
        if(res.contains(s.substring(i,i+1))){
            help = 1;
            n = i;
        }
         else{
             help++;
            if(result<=help)
             result = help;
        }
    }
        return result;
}
}
