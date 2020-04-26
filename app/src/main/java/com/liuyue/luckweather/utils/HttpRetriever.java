package com.liuyue.luckweather.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRetriever {

    public static String retrieve(String url) {
        URL targetURL;
        try {
            targetURL = new URL(url);
        } catch (MalformedURLException e) {
            return null;
        }
        HttpURLConnection urlConnection = null;
        String response;
        try {
            urlConnection = (HttpURLConnection) targetURL.openConnection();
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:62.0) Gecko/20100101 Firefox/62.0");
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoInput(true);
            urlConnection.connect();
            response = readStream(urlConnection.getInputStream());
        } catch (IOException e) {
            return null;
        } finally {
            if (urlConnection != null) urlConnection.disconnect();
        }
        return response;
    }

    private static String readStream(InputStream inputStream) {
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            return null;
        }
        return builder.toString();
    }
}
