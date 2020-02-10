package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* 
НОД
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader r =new BufferedReader(new InputStreamReader(System.in));
        int k =0;
        int a=0;
        int b=0;
        try{
            a = Integer.parseInt(r.readLine());
            b = Integer.parseInt(r.readLine());
        }
        catch(Exception e){
            
        }

        for (int i = 1;i<Integer.MAX_VALUE;i++){
            if (a%i==0&&b%i==0){
                k=i;
            }
            else{
                System.out.println(k);
                break;
            }
        }
    }
}
