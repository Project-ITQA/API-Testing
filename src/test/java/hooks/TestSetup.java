package hooks;

import org.junit.BeforeClass;
import java.io.IOException;

public class TestSetup {
    @BeforeClass
    public static void startDemoApi() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "java", "-jar", "libs/demo-0.0.1-SNAPSHOT.jar"
            );
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            Thread.sleep(5000);
            System.out.println("Demo API JAR started successfully.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to start Demo API JAR.", e);
        }
    }
}
