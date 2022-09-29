package integration_test.screen;

import autocontroldriver.bind.AutoControlDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;

public class TestScreenFunction {

    public static AutoControlDriverManager autoControlDriverManager;

    @BeforeClass
    public static void setDriver() {
        autoControlDriverManager = null;
        try {
            autoControlDriverManager = new AutoControlDriverManager(
                    "localhost",
                    9938,
                    "C:\\program_workspace\\java\\AutoControlJava\\test_resource\\generate_autocontrol_driver.exe",
                    "windows"
            );
            while (!autoControlDriverManager.isAlive()) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSize() {
        autoControlDriverManager.screen.screenSize();
    }

    @Test
    public void testScreenshot() {
        autoControlDriverManager.screen.screenshot();
        autoControlDriverManager.screen.screenshot(Path.of("").toAbsolutePath() + "/test.png");
        autoControlDriverManager.screen.screenshot(100, 100, 500 ,500);
        autoControlDriverManager.screen.screenshot(
                Path.of("").toAbsolutePath() + "/test1.png",
                100, 100, 500 ,500);
    }

    @AfterClass
    public static void afterTest(){
         autoControlDriverManager.quit();
    }
}
