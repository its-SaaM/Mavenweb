package com.mavenweb;

import org.eclipse.jetty.server.Server;

public class TestServer {

    private Server server;
    private int port;

    // ✔ Add constructor accepting port
    public TestServer(int port) {
        this.port = port;
        this.server = new Server(port);
    }

    // ✔ Old default constructor (keep it if needed)
    public TestServer() {
        this(9090); // default port
    }

    // ✔ Start server
    public void start() throws Exception {
        server.start();
        System.out.println("Test server started on port " + port);
    }

    // ✔ Stop server
    public void stop() throws Exception {
        if (server != null && server.isRunning()) {
            server.stop();
            System.out.println("Test server stopped");
        }
    }
}
