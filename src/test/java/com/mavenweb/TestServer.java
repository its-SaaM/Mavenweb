package com.mavenweb;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class TestServer {

    private static HttpServer server;
    private static int port = 9090;  // Default port

    // Start server only once
    public static void start() throws IOException {
        if (server != null) {
            return; // server already running
        }

        server = HttpServer.create(new InetSocketAddress(port), 0);

        // Root endpoint
        server.createContext("/", new RootHandler());

        // Login endpoint
        server.createContext("/login", new LoginHandler());

        // Health endpoint
        server.createContext("/health", new HealthHandler());

        // Admin endpoint (unauthorized)
        server.createContext("/admin", new AdminHandler());

        server.setExecutor(null);
        server.start();
        System.out.println("Test server started on port " + port);
    }

    // Stop server
    public static void stop() {
        if (server != null) {
            server.stop(0);
            server = null;
            System.out.println("Test server stopped.");
        }
    }

    // ------ Handlers ------

    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Server Running";
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }

    static class LoginHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (!"POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(405, -1);
                return;
            }

            String response = "{\"status\": \"success\"}";
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }

    static class HealthHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "UP";
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }

    static class AdminHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Always return 401 Unauthorized
            exchange.sendResponseHeaders(401, -1);
            exchange.close();
        }
    }
}