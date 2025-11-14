package com.mavenweb.it;

import com.mavenweb.TestServer;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class LoginFunctionalityIT {

    @BeforeClass
    public static void start() throws Exception {
        TestServer.start();
    }

    @Test
    public void validLoginReturnsSuccessJson() throws Exception {
        URL url = new URL("http://localhost:8080/login");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        String data = "username=admin&password=admin";

        try(OutputStream os = conn.getOutputStream()) {
            os.write(data.getBytes());
        }

        assertEquals(200, conn.getResponseCode());
    }
}