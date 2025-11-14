package com.mavenweb.it;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;

public class BuildVerificationIT {
    @Test
    public void warExistsInTarget() {
        File war = new File("target/mavenweb.war");
        assertTrue("WAR file must exist in target/", war.exists());
    }
}