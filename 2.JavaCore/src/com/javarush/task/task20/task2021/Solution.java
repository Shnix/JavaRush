package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution  {
        public void writeObject(ObjectOutput out) throws IOException {
            throw new NotSerializableException("Не сегодня!");
        }
        public void readObject(ObjectInput in) throws IOException {
            throw new NotSerializableException("Не сегодня!");
        }
    }

    public static void main(String[] args) {

    }
}
