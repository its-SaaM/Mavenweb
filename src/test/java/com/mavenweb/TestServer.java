package com.mavenweb;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class TestServer {

    private static HttpServer server;

    public static void start() throws IOException {
        if (server != null) {
            return; // server already started
        }

        server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Root handler -> returns 200 OK
        server.createContext("/", new RootHandler());

        // Login handler -> POST -> returns 200 OK
        server.createContext("/login", new LoginHandler());

        server.setExecutor(null);
        server.start();
        System.out.println("Test server started on port 8080");
    }

    // ----- Handlers -----

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

            // Always return success for testing
            String response = "{\"status\": \"success\"}";
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.length());

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }
}
