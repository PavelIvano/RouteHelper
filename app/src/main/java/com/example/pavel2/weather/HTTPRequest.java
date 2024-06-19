package com.example.pavel2.weather;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;

public class HTTPRequest implements Runnable {

    private URL url;
    private Handler handler;
    private String city;

    HTTPRequest(Handler h, String city) {
        try {
            this.url = new URL("https://experience.tripster.ru/api/web/v1/search/site/?limit=16&query="+ city +"&types=");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.city = city;
        this.handler = h;
    }

    @Override
    public void run() {
        try {
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            Scanner scanner = new Scanner(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            while(scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            scanner.close();
            connection.disconnect();
            Message m = Message.obtain();
            m.obj = response.toString();
            System.out.println(city);
            System.out.println(m.obj);
            handler.sendMessage(m);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}