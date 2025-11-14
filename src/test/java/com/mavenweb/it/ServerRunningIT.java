package com.mavenweb.it;

import org.junit.Test;
import static org.junit.Assert.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServerRunningIT {
    @Test
    public void serverRootReturns200() throws Exception {
        URL url = new URL("http://localhost:9090/");
        HttpURLConnection c = (HttpURLConnection) url.openConnection();
        c.setRequestMethod("GET");
        c.setConnectTimeout(5000);
        int code = c.getResponseCode();
        assertEquals(200, code);
    }
}