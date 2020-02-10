package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //System.out.println(new Solution(4));

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\Popa.txt"));
        Solution savedObject = new Solution(5);
        objectOutputStream.writeObject(savedObject);
        objectOutputStream.flush();
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\Popa.txt"));
        Solution loadedObject = new Solution(8);
        loadedObject = (Solution) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(loadedObject.toString().equals(savedObject.toString()));

    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
