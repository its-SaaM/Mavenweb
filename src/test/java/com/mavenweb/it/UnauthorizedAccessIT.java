package com.mavenweb.it;

import org.junit.Test;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.junit.Assert.assertEquals;

public class UnauthorizedAccessIT {

    @Test
    public void unauthorizedAccessReturns200() throws Exception {
        URL url = new URL("http://localhost:9090/HelloServlet");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        assertEquals(200, con.getResponseCode());
    }
}