package com.mavenweb;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class TestServer {
    private final Server server;

    public TestServer(int port) {
        this.server = new Server(port);
    }

    public void start() throws Exception {
        ServletContextHandler handler = new ServletContextHandler();

        // Map all your servlets here
        handler.addServlet(RootServlet.class, "/");
        handler.addServlet(HelloServlet.class, "/hello");
        handler.addServlet(LoginServlet.class, "/login");
        handler.addServlet(AdminServlet.class, "/admin");
        handler.addServlet(HealthServlet.class, "/actuator/health");

        server.setHandler(handler);
        server.start();
    }

    public void stop() throws Exception {
        server.stop();
    }
}