package com.mavenweb;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    com.mavenweb.it.HealthCheckIT.class,
    com.mavenweb.it.ServerRunningIT.class,
    com.mavenweb.it.LoginFunctionalityIT.class,
    com.mavenweb.it.UnauthorizedAccessIT.class,
    com.mavenweb.it.BuildVerificationIT.class
})
public class IntegrationTestSuite {

    private static TestServer server;

    @org.junit.BeforeClass
    public static void startServer() throws Exception {
        server = new TestServer(9090);
        server.start();
    }

    @org.junit.AfterClass
    public static void stopServer() throws Exception {
        server.stop();
    }
}