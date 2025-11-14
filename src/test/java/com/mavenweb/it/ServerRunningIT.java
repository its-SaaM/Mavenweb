package com.mavenweb.it;

import com.mavenweb.TestServer;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class ServerRunningIT {

    private static TestServer server;

    @BeforeClass
    public static void setup() throws Exception {
        server = new TestServer(9090);   // start on port 9090
        server.start();
    }

    @AfterClass
    public static void teardown() throws Exception {
        if (server != null) {
            server.stop();   // MUST add stop() in TestServer
        }
    }

    @Test
    public void serverRootReturns200() throws Exception {
        URL url = new URL("http://localhost:9090/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        assertEquals(200, conn.getResponseCode());
    }
}