package com.mavenweb.it;

import com.mavenweb.TestServer;
import org.junit.BeforeClass;
import org.junit.Test;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class ServerRunningIT {

    @BeforeClass
    public static void setup() throws Exception {
        TestServer.start();
    }

    @Test
    public void serverRootReturns200() throws Exception {
        URL url = new URL("http://localhost:9090/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        assertEquals(200, conn.getResponseCode());
    }
}