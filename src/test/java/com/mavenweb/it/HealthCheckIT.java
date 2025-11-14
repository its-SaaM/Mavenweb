package com.mavenweb.it;

import org.junit.Test;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.junit.Assert.assertEquals;

public class HealthCheckIT {

    @Test
    public void healthCheckReturns200() throws Exception {
        URL url = new URL("http://localhost:9090/health");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        assertEquals(200, conn.getResponseCode());
    }
}