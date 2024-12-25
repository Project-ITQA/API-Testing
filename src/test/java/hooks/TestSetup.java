package hooks;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import java.io.IOException;

public class TestSetup {
    private static Process process;

    @BeforeClass
    public static void startDemoApi() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "java", "-jar", "libs/demo-0.0.1-SNAPSHOT.jar"
            );
            processBuilder.redirectErrorStream(true);
            process = processBuilder.start();

            Thread.sleep(5000);
            System.out.println("Demo API JAR started successfully.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to start Demo API JAR.", e);
        }
    }

    @AfterClass
    public static void stopDemoApi() {
        try{
            if (process != null) {
                process.destroy();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to stop Demo API JAR.", e);
        }
    }
}
