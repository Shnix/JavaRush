package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws InterruptedException, IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String nameOfFile = r.readLine();
            if (nameOfFile.equals("exit")){break;}
            ReadThread fileRead = new ReadThread(nameOfFile);
            fileRead.start();
            fileRead.join();
        }

    }

    public static class ReadThread extends Thread {
        String filename;
        FileInputStream fileInputStream;
        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            super(fileName);
            this.filename = fileName;


        }
        // implement file reading here - реализуйте чтение из файла тут



        @Override
        public void run(){
            ArrayList<Integer> listOfBytes = new ArrayList<>();
            try {
                fileInputStream= new FileInputStream(filename);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int sum;
            int count=0;
            while(true){
                try {
                    if (!(fileInputStream.available()>0)) break;
                    sum = fileInputStream.read();
                    listOfBytes.add(sum);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Integer byteCount=0;
            for(int i=0;i<listOfBytes.size();i++){
                int a = Collections.frequency(listOfBytes,listOfBytes.get(i));
                if (a>count){
                    count=a;
                    byteCount=listOfBytes.get(i);
                }
            }
            resultMap.put(filename,byteCount);
        }
    }
}
