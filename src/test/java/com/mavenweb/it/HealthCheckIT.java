package com.mavenweb.it;

import com.mavenweb.TestServer;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class HealthCheckIT 
{
    @BeforeClass
    public static void startServer() throws Exception {
        TestServer.start();   // correct way
    }

    @Test
    public void healthEndpointReturnsUp() throws Exception {
        URL url = new URL("http://localhost:9090/health");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        assertEquals(200, conn.getResponseCode());
    }
}
