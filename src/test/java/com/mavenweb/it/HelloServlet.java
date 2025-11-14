package com.mavenweb.it;

import org.junit.Test;
import static org.junit.Assert.*;
import java.net.*;
import java.io.*;

public class HelloServlet {
    @Test
    public void loginPageLoads() throws Exception {
        URL url = new URL("http://localhost:9090/login");
        HttpURLConnection c = (HttpURLConnection) url.openConnection();
        c.setRequestMethod("GET");
        c.setConnectTimeout(5000);
        assertEquals(200, c.getResponseCode());

        BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
        String line; boolean found = false;
        while ((line = br.readLine()) != null) {
            if (line.contains("<title>Login</title>") || line.contains("Login")) { found = true; break; }
        }
        br.close();
        assertTrue(found);
    }
}