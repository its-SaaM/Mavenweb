package com.mavenweb.it;

import com.mavenweb.TestServer;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class HealthCheckIT {

    private static TestServer server;

    @BeforeClass
    public static void startServer() throws Exception {
        server = new TestServer(9090);   // start on port 9090
        server.start();
    }

    @AfterClass
    public static void stopServer() throws Exception {
        if (server != null) {
            server.stop();   // <-- You must add stop() in TestServer also
        }
    }

    @Test
    public void healthEndpointReturnsUp() throws Exception {
        URL url = new URL("http://localhost:9090/health");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        assertEquals(200, conn.getResponseCode());
    }
}