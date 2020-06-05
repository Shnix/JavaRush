package com.javarush.task.task40.task4011;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.jsoup.helper.HttpConnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* 
Свойства URL
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        decodeURLString("https://www.amrood.com/index.htm?language=en#j2se");
    }

    public static void decodeURLString(String s)  {
        URL address = null;
        try {
            address = new URL(s);
            System.out.println(address.getProtocol());
            System.out.println(address.getAuthority());
            System.out.println(address.getFile());
            System.out.println(address.getHost());
            System.out.println(address.getPath());
            System.out.println(address.getPort());
            System.out.println(address.getDefaultPort());
            System.out.println(address.getQuery());
            System.out.println(address.getRef());

        } catch (MalformedURLException e) {
            System.out.format("Parameter %s is not a valid URL.",s);
        }
    }
}

