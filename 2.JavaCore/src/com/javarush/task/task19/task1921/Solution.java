package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fileReader);
        while (reader.ready()) {
            String stroke = reader.readLine();
            if (stroke == null) break;
            String[] nameAndDate = stroke.split("\\s");
            String date = nameAndDate[nameAndDate.length - 3] + " " + nameAndDate[nameAndDate.length - 2] + " " + nameAndDate[nameAndDate.length - 1];
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            Date birthday = simpleDateFormat.parse(date);
            String name = "";
            for (int i = 0; i < nameAndDate.length - 3; i++) {
                name = name + nameAndDate[i]+ " ";
            }
            name = name.substring(0,name.length()-1);
            PEOPLE.add(new Person(name, birthday));

        }
        fileReader.close();
        reader.close();
        for (Person person : PEOPLE) {
            System.out.println(person.getName());
            System.out.println(person.getBirthDate());
        }
    }
}

