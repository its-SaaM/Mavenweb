package com.mavenweb.it;

import org.junit.Test;
import static org.junit.Assert.*;
import java.net.*;

public class UnauthorizedAccessIT {
    @Test
    public void adminWithoutSessionReturns401() throws Exception {
        URL url = new URL("http://localhost:9090/admin");
        HttpURLConnection c = (HttpURLConnection) url.openConnection();
        c.setRequestMethod("GET");
        c.setConnectTimeout(5000);
        int code = c.getResponseCode();
        assertEquals(401, code);
    }
}