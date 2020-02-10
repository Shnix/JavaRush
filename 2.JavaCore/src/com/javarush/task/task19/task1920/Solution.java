package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    static TreeSet<Human> people = new TreeSet<>();
    static Double max = 0.0;


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new FileReader(args[0]));
        while (sc.hasNextLine()) {
            String par = String.valueOf(sc.nextLine());
            String[] pair = par.split("\\s");
            toSet(pair);
        }
        sc.close();





        for (Human h : people) {
            if (h.getSalary() > max) {
                max = h.getSalary();
            }
        }


        for(Human j: people){
            if(j.salary.equals(max)){
                System.out.println(j.getName());
            }
        }

    }



    private static void toSet(String[] pair) {
        String name = pair[0];
        Double doub = Double.valueOf(pair[1]);

        Human human = new Human(name,doub);

        if(people.isEmpty()|| !people.contains(human)){
            people.add(human);
        }else {
            for(Human h: people){
                if(h.equals(human)){
                    h.setSalary(doub);
                    break;

                }
            }
        }
    }







    static class Human implements Comparable<Human> {
        private String name;
        private Double salary;





        public Double getSalary() {
            return salary;
        }


        Human(String name, Double sal){
            this.name = name;
            this.salary = sal;
        }
        String getName(){
            return name;
        }
        void setSalary(Double d){
            salary += d;

        }



        @Override
        public String toString() {
            return name + " " + salary;
        }



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            return name.equals(human.name);
        }



        @Override
        public int compareTo(Human o) {
            return name.compareTo(o.getName());
        }
    }

}