package com.mavenweb.it;

import org.junit.Test;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.junit.Assert.assertEquals;

public class ServerRunningIT {

    @Test
    public void serverIsRunning() throws Exception {
        URL url = new URL("http://localhost:9090/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        assertEquals(200, conn.getResponseCode());
    }
}