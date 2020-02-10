package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        while (!key.isEmpty())
        {
            key = reader.readLine();
            if (key.equals("user")){
                person = new Person.User();
            }
            else if (key.equals("loser")){
                person = new Person.Loser();
            }
            else if (key.equals("coder")){
                person = new Person.Coder();
            }
            else if (key.equals("proger")){
                person = new Person.Proger();
            }
            else {
                break;}

            doWork(person); //вызываем doWork

        
    }
    reader.close();
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User){
            Person.User user = new Person.User();
            user.live();
        }
        if (person instanceof Person.Loser){
            Person.Loser loser = new Person.Loser();
            loser.doNothing();
        }
        if (person instanceof Person.Coder){
            Person.Coder coder = new Person.Coder();
            coder.writeCode();
        }
        if (person instanceof Person.Proger){
            Person.Proger proger = new Person.Proger();
            proger.enjoy();
        }
        
    }

}
