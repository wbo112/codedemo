package com.itheima.consumer;

import com.itheima.interf.service.Invocation;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class HttpClient {
    public String post(String hostName, int port, Invocation invocation) throws IOException {
        URL url = new URL("http", hostName, port, "/client");
        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);

        OutputStream outputStream = httpURLConnection.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(invocation);
objectOutputStream.flush();
objectOutputStream.close();
        InputStream inputStream = httpURLConnection.getInputStream();

            byte[] bytes = inputStream.readAllBytes();


        return new String(bytes, StandardCharsets.UTF_8);
    }

}
