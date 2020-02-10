package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {


    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query,delimiter);
        List<String> result = new ArrayList<>();
        int i=0;
        while (st.hasMoreTokens()){
            String token =st.nextToken();
            result.add(token);
            i++;
        }
        return result.toArray(new String[0]);
    }
}
