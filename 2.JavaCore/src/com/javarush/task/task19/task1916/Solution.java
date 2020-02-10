package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader file1Reader = new FileReader(reader.readLine());
        FileReader file2Reader = new FileReader(reader.readLine());
        BufferedReader file1BR = new BufferedReader(file1Reader);
        BufferedReader file2BR = new BufferedReader(file2Reader);
        ArrayList<String> file1 = new ArrayList<>();
        ArrayList<String> file2 = new ArrayList<>();
        while(file1BR.ready()){
            file1.add(file1BR.readLine());
        }
        file1BR.close();
        file1Reader.close();
        while(file2BR.ready()){
            file2.add(file2BR.readLine());
        }
        file2BR.close();
        file2Reader.close();
        while(true){
            try {
                if (file1.get(0).equals(file2.get(0))) {
                    lines.add(new LineItem(Type.SAME, file1.get(0)));
                    file1.remove(0);
                    file2.remove(0);
                } else {
                    if (file1.get(1).equals(file2.get(0))) {
                        lines.add(new LineItem(Type.REMOVED, file1.get(0)));
                        file1.remove(0);
                    } else if (file1.get(0).equals(file2.get(1))) {
                        lines.add(new LineItem(Type.ADDED, file2.get(0)));
                        file2.remove(0);
                    }
                }
            }
            catch (Exception e){
                break;
            }
        }
        while(file1.size()!=0||file2.size()!=0){
            if (file1.size()!=0){
                lines.add(new LineItem(Type.REMOVED,file1.get(0)));
                file1.remove(0);
            }
            else if(file2.size()!=0){
                lines.add(new LineItem(Type.ADDED,file2.get(0)));
                file2.remove(0);
            }
        }
        reader.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
