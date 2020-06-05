package com.javarush.task.task34.task3403;

import java.util.SimpleTimeZone;

/*
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recurse(int n) {
        if (n<=1){return;}
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    System.out.print(i + " ");
                    recurse(n / i);
                    break;
                }
            }
    }



    public static void main(String[] args) {
        new Solution().recurse(132);
    }
}
