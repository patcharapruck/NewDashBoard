package com.example.pchrp.newdashboard.manager.http;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpKrystal  {

    public String getTest() throws IOException {

        URL url = new URL("http://103.13.31.63:8555/restaurant/api/restaurant/v1/bpm/dashboard/summary");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type","application/json");
        httpURLConnection.setRequestProperty("Authorization","eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0MTg3X0hEV18xIiwiYXVkIjoiNEUxQkUyN0Q0QTI3OURGNjM4M0EyQUVEREE0RUZBQkMiLCJleHAiOjE1NDg1MTMwNTAsImlhdCI6MTU0NzkwODI1MH0.pq7juV50vA5MYbWmy4lJuQZXT8MbhBPaKBbRnU0MIaTwFzJZH9pTZbxne1brsmKMa2HAfldR-4wEWlCeiAkB8g");

        httpURLConnection.setDoOutput(true);

        String reqBody = "{\"property\":[],\"criteria\":{},\"orderBy\":{\"InvoiceDocument-id\":\"desc\"},\"pagination\":{\"limitItem\":50,\"currentPage\":1}}";
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(reqBody.getBytes());
        outputStream.flush();
        outputStream.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuilder jsonResponse = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonResponse.append(line);
        }

        return jsonResponse.toString();
    }

}
