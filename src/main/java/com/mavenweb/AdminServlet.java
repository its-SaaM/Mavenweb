package com.mavenweb;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.setContentType("application/json");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().write("{\"error\":\"unauthorized\"}");
            return;
        }

        resp.setContentType("text/html");
        resp.getWriter().write("<html><body><h1>Admin Page</h1><p>Hello " + session.getAttribute("user") + "</p></body></html>");
    }
}