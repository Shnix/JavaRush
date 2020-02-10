package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader r =new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1Reader = new BufferedReader(new FileReader(r.readLine()));
        BufferedReader file2Reader = new BufferedReader(new FileReader(r.readLine()));

        String file1Line = file1Reader.readLine();
        String file2Line = file2Reader.readLine();
        while(file1Line!=null){
            allLines.add(file1Line);
            file1Line = file1Reader.readLine();
        }
        while (file2Line!=null){
            forRemoveLines.add(file2Line);
            file2Line = file2Reader.readLine();
        }
        Solution solution = new Solution();
        solution.joinData();


    }

    public void joinData() throws CorruptedDataException  {
        List<String> general = new ArrayList<String>();
        for(String all:allLines) {
            for(String fo:forRemoveLines) {
                if(fo.equals(all)) {
                    general.add(all);
                }
            }
        }
        Collections.sort(general);
        Collections.sort(forRemoveLines);

        if(general.equals(forRemoveLines)) {
            allLines.removeAll(general);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
