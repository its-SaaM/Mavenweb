package com.mavenweb.it;

import org.junit.Test;
import static org.junit.Assert.*;
import java.net.*;
import java.io.*;

public class LoginFunctionalityIT {
    @Test
    public void validLoginReturnsSuccessJson() throws Exception {
        URL url = new URL("http://localhost:9090/authenticate");
        HttpURLConnection c = (HttpURLConnection) url.openConnection();
        c.setRequestMethod("POST");
        c.setDoOutput(true);
        String body = "username=admin&password=admin123";
        c.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        c.getOutputStream().write(body.getBytes("UTF-8"));
        int code = c.getResponseCode();
        assertEquals(200, code);

        BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
        StringBuilder sb = new StringBuilder(); String line;
        while ((line = br.readLine()) != null) sb.append(line);
        br.close();
        assertTrue(sb.toString().contains("\"login\":\"success\""));
    }
}