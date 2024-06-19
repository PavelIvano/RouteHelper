package com.example.pavel2.weather;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class HTTPRequest2 implements Runnable{

    private URL url2;
    private Handler handler2;
    private String title;
    private String type;
    private int id;

    private  int visitors;


    HTTPRequest2(Handler h2, String title) {
        try {
            this.url2 = new URL("https://experience.tripster.ru/experience/Moscow/390-moscow-city/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.title = title;
        this.handler2 = h2;
    }

    @Override
    public void run() {
        try {
            HttpsURLConnection connection = (HttpsURLConnection) url2.openConnection();
            connection.setRequestMethod("GET");
            Scanner scanner2 = new Scanner(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            while(scanner2.hasNext()) {
                response.append(scanner2.nextLine());
            }
            scanner2.close();
            connection.disconnect();
            Message m2 = Message.obtain();
            m2.obj = response.toString();
            System.out.println(id);
            System.out.println(type);
            System.out.println(title);
            System.out.println(visitors);

            System.out.println(m2.obj);
            handler2.sendMessage(m2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
