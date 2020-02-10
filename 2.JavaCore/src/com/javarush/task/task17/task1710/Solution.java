

package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        switch(args[0]){
            case "-c":
                if (args[2].equals("м")){
                    allPeople.add(Person.createMale(args[1],format.parse(args[3])));
                }
                else if (args[2].equals("ж")){
                    allPeople.add(Person.createFemale(args[1],format.parse(args[3])));
                }
                System.out.println(allPeople.size()-1);
                break;

            case "-u":
                int id = Integer.parseInt(args[1]);
                allPeople.get(id).setBirthDate(format.parse(args[4]));
                allPeople.get(id).setName(args[2]);
                if (args[3].equals("м"))
                    allPeople.get(id).setSex(Sex.MALE);
                else if (args[3].equals("ж")){
                    allPeople.get(id).setSex(Sex.FEMALE);}
                break;

            case "-d":
                id = Integer.parseInt(args[1]);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setName(null);
                allPeople.get(id).setBirthDate(null);
                break;

            case "-i":
                id = Integer.parseInt(args[1]);
                if (allPeople.get(id).getSex().equals(Sex.MALE)){
                    System.out.println(allPeople.get(id).getName() + " м " + dateformat.format(allPeople.get(id).getBirthDate()));}
                else if (allPeople.get(id).getSex().equals(Sex.MALE)){
                    System.out.println(allPeople.get(id).getName() + " ж " + dateformat.format(allPeople.get(id).getBirthDate()));}
                break;
        }
    }
}

