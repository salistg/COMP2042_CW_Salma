package p4_group_8_repo.Controllers;

import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;

/**
 * Test for the Launcher class. </br>
 * Tests that the application correctly launches.
 */
public class LauncherTest {
    /**
     * Rule to allow for testing on JavaFx applications.
     */
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();


    /**
     * Testing that the main method correctly launches
     * the application.
     */
    @Test
    public void testMainMethodRuns() {
        new Thread(() -> {
            try {
                String [] args = { "one", "two", "three" };
                Launcher.main(args);
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
            }
            System.exit(0);
        }).start();
    }


}

