package p4_group_8_repo.Controllers;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;

import static org.junit.Assert.*;

/**
 * Tests the Main class. </br>
 * Tests that it sets up the application with the correct title
 */
public class MainTest {
    /**
     * Rule to allow for testing on JavaFx applications.
     */
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    /**
     * To instantiate the Main class.
     */
    private Main main;
    /**
     * Creating a new Stage object.
     */
    private Stage stage;

    /**
     * Setting up before every test.</br>
     * Instantiates a new Stage object and the main class for testing.
     */
    @Before
    public void setUp() {
        main = new Main();
        stage = new Stage();
    }

    /**
     * Tests that the application's title is set correctly to 'Frogger'.
     */
    @Test
    public void testStageTitle(){
        main.start(stage);
        assertEquals("Frogger", stage.getTitle());
    }

    /**
     * Tests that the scene has a vbox as its root. </br>
     * This is because the scene set for the stage is the
     * Start scene which has a vbox as its root.
     */
    @Test
    public void testStageHasAScene(){
        main.start(stage);
        assertNotNull(stage.getScene());
        assertEquals(VBox.class, stage.getScene().getRoot().getClass());
    }


    /**
     * Tests that the Main method runs correctly.
     */
    @Test
    public void testMainMethodRuns() {
        new Thread(() -> {
            try {
                String [] args = { "one", "two", "three" };
                Main.main(args);
                Thread.sleep(3000);
            }
            catch (InterruptedException ignored) {
            }
            System.exit(0);
        }).start();
    }
}