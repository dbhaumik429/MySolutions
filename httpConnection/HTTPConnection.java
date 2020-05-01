package com.debu.httpConnection;


import java.net.*;
import java.io.*;
import java.util.*;

public class HTTPConnection {

    public static void main(String[] args) {

        String url = "https://google.com";
        String filePath = "Google.html";

        try {

            URL urlObj = new URL(url);
            URLConnection urlCon = urlObj.openConnection();

            InputStream inputStream = urlCon.getInputStream();
            BufferedInputStream reader = new BufferedInputStream(inputStream);

            BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(filePath));

            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, bytesRead);
            }

            writer.close();
            reader.close();

            System.out.println("Web page saved");

        } catch (MalformedURLException e) {
            System.out.println("The specified URL is malformed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An I/O error occurs: " + e.getMessage());
        }

    }
}
