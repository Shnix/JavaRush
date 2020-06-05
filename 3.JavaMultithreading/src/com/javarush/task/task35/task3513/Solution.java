package com.javarush.task.task35.task3513;


    public class Solution {
        public static void main(String[] args) {
            System.out.println(accum("abcD"));
        }


            public static String accum(String s) {
                // your code
                String[] result = s.split("");
                StringBuilder text = new StringBuilder();
                for(int i=0;i<result.length;i++){
                    text.append(result[i].toUpperCase());
                    for(int j=0;j<i;j++){
                        text.append(result[i].toLowerCase());
                    }
                    text.append("-");
                }
                text.replace(text.length()-1,text.length(),"");
                return text.toString();
            }
    }

