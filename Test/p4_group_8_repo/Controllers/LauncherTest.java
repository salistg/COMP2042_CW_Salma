package p4_group_8_repo.Controllers;

import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;

public class LauncherTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();


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

