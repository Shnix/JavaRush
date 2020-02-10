package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        FileReader fileReader = new FileReader(r.readLine());
        r.close();

        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.startsWith(args[0]+" ")) {
                System.out.print(line);
            }

        }
        fileReader.close();
    }
}

