package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();

        String tagName = "span";
        String htmlStr = null;
        reader = new BufferedReader(new FileReader(name));
        while (reader.ready()){
            htmlStr+=reader.readLine();
        }
        reader.close();

        Document doc = Jsoup.parse(htmlStr, "", Parser.xmlParser());
        Elements elements = doc.getElementsByTag(tagName);
        for (Element el : elements){
            System.out.println(el.toString());
        }
    }
}
