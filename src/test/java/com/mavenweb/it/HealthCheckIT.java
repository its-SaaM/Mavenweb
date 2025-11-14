package com.mavenweb.it;

import com.mavenweb.TestServer;

import org.junit.BeforeClass;
import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class HealthCheckIT {

    private static TestServer server;

    @BeforeClass
    public static void startServer() throws Exception {
        server = new TestServer(8080);
        server.start();
    }

    @Test
    public void actuatorHealthIsUp() throws Exception {
        URL url = new URL("http://localhost:8080/actuator/health");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        assertEquals(200, conn.getResponseCode());
    }
}