package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
6. Не используй статические переменные.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> fileNames = new ArrayList<>();
        while(true){
            String fileName = r.readLine();
            if (fileName.equals("end")){break;}
                fileNames.add(fileName);
        }
        Collections.sort(fileNames);

        String[] fileN = fileNames.get(0).split(".part");
        String newFileName = fileN[0];

        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(newFileName, true));

        BufferedInputStream inputStream = null;
        for (String a : fileNames)   {
            inputStream = new BufferedInputStream(new FileInputStream(a));

            int c;
            while ((c = inputStream.available()) != 0)
            {
                int data = inputStream.read();
                outputStream.write(data);
                outputStream.close();
            }inputStream.close();}


        }
    }

