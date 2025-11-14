package com.mavenweb.it;

import com.mavenweb.TestServer;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class LoginFunctionalityIT {

    private static TestServer server;

    @BeforeClass
    public static void startServer() throws Exception {
        server = new TestServer(9090);
        server.start();
    }

    @AfterClass
    public static void stopServer() throws Exception {
        if (server != null) {
            server.stop();
        }
    }

    @Test
    public void validLoginReturnsSuccessJson() throws Exception {

        URL url = new URL("http://localhost:9090/login");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        String data = "username=admin&password=admin";

        try (OutputStream os = conn.getOutputStream()) {
            os.write(data.getBytes());
        }

        assertEquals(200, conn.getResponseCode());
    }
}