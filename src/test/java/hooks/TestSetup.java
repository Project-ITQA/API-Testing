package hooks;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

import java.io.File;
import java.io.IOException;

public class TestSetup {
    private static Process process;

    @BeforeAll
    public static void startDemoApi() {
        try {
            System.out.println("[Demo API] =====> JAR starting.");
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "java", "-jar", "libs/demo-0.0.1-SNAPSHOT.jar"
            );

            File outputFile = new File("demo-api-output.log");
            processBuilder.redirectOutput(outputFile);
            process = processBuilder.start();

            Thread.sleep(6000);
            System.out.println("[Demo API] =====> JAR started successfully.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to start Demo API JAR.", e);
        }
    }

    @AfterAll
    public static void stopDemoApi() {
        System.out.println("[Demo API] =====> JAR stopping.");
        try{
            if (process != null) {
                process.destroy();
                System.out.println("[Demo API] =====> JAR stopped successfully.");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to stop Demo API JAR.", e);
        }
    }
}
