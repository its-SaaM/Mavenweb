package com.mavenweb;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class TestServer {
    private Server server;
    private int port;

    public TestServer(int port) {
        this.port = port;
        this.server = new Server(port);
    }

    public void start() throws Exception {
        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(HealthServlet.class, "/actuator/health");

        server.setHandler(handler);
        server.start();
    }

    public void stop() throws Exception {
        server.stop();
    }
}