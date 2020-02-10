package com.javarush.task.task13.task1325;

/*
Компиляция программы
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Fox bigFox = new BigFox();
        System.out.println(bigFox.getName());
        System.out.println(bigFox.getColor());
    }

    public interface Animal {
        Fox getColor();
    }

    public static class Fox implements Animal {
        public String getName() {
            return "Fox";
        }
        public Fox getColor(){
            return this;
        }
    }

    public static class BigFox extends Fox {
        
    }

}
