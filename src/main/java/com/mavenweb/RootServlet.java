package com.mavenweb;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class RootServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("<html><head><title>Home</title></head><body><h1>Welcome to Maven Web Application</h1><p><a href=\"/login\">Login</a></p></body></html>");
    }
}