package com.mavenweb.it;

import org.junit.Test;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.junit.Assert.assertEquals;

public class UnauthorizedAccessIT {

    @Test
    public void adminWithoutAuthReturns404() throws Exception {
        URL url = new URL("http://localhost:9090/admin");
        HttpURLConnection c = (HttpURLConnection) url.openConnection();
        c.setRequestMethod("GET");

        assertEquals(404, c.getResponseCode());
    }
}