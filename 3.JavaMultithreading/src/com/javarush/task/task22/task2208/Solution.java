package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        if (params.isEmpty())
            return "";
        for (Map.Entry<String, String> pair : params.entrySet()){
            if (pair.getValue()!=null){
                sb.append(pair.getKey());
                sb.append(" = '");
                sb.append(pair.getValue());
                sb.append("' and ");
            }
        }
        if (sb.length()==0)
            return "";
        sb.delete(sb.length()-5,sb.length());
        return sb.toString();
    }
}
