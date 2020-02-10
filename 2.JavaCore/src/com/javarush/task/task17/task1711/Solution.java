package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);


    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 0; i < args.length-2; i+=3) {
                        if (args[2 + i].equals("м")) {
                            allPeople.add(Person.createMale(args[1 + i], format.parse(args[3 + i])));
                        } else if (args[2 + i].equals("ж")) {
                            allPeople.add(Person.createFemale(args[1 + i], format.parse(args[3 + i])));
                        }
                        System.out.println(allPeople.size() - 1);
                    }
                } break;

            case "-u":
                synchronized (allPeople) {
                    int id;
                    for (int i = 0; i < args.length-1; i+=4) {
                        id = Integer.parseInt(args[1 + i]);
                        allPeople.get(id).setBirthDate(format.parse(args[4 + i]));
                        allPeople.get(id).setName(args[2 + i]);
                        if (args[3 + i].equals("м"))
                            allPeople.get(id).setSex(Sex.MALE);
                        else if (args[3 + i].equals("ж")) {
                            allPeople.get(id).setSex(Sex.FEMALE);
                        }
                    }
                }
                break;

            case "-d":
                synchronized (allPeople) {
                    int id;
                    for (int i = 0; i < args.length-1; i++) {
                        id = Integer.parseInt(args[1 + i]);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setName(null);
                        allPeople.get(id).setBirthDate(null);
                    }
                } break;

            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person currentPerson = allPeople.get(Integer.parseInt(args[i]));
                        String name = currentPerson.getName(), bd = dateformat.format(currentPerson.getBirthDate());
                        char sex;
                        if (currentPerson.getSex().equals(Sex.MALE)) sex = 'м';
                        else sex = 'ж';

                        System.out.println(name + " " + sex + " " + bd);
                    }
                } break;
        }
    }
}