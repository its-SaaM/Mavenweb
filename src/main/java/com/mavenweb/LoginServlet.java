package com.mavenweb;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("<html><head><title>Login</title></head><body>"
            + "<h1>Login</h1>"
            + "<form method='post' action='/authenticate'>"
            + "Username: <input name='username'/><br/>"
            + "Password: <input name='password' type='password'/><br/>"
            + "<button type='submit'>Login</button>"
            + "</form></body></html>");
    }
}