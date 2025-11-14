package com.mavenweb;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.json.JSONObject;

public class AuthenticateServlet extends HttpServlet {
    // Example simple credential check (DO NOT use in production)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        resp.setContentType("application/json");
        JSONObject json = new JSONObject();

        if ("admin".equals(username) && "admin123".equals(password)) {
            // create session
            HttpSession session = req.getSession(true);
            session.setAttribute("user", username);
            json.put("login", "success");
            resp.setStatus(200);
        } else {
            json.put("login", "failure");
            resp.setStatus(401);
        }
        resp.getWriter().write(json.toString());
    }
}