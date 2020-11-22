package p4_group_8_repo.Controllers;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;

import static org.junit.Assert.*;

public class MainTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
    Main main;
    Stage stage;

    @Before
    public void setUp() {
        main = new Main();
        stage = new Stage();
    }

    @Test
    public void testStageTitle(){
        main.start(stage);
        assertEquals("Frogger", stage.getTitle());
    }

    @Test
    public void testStageHasAScene(){
        main.start(stage);
        assertNotNull(stage.getScene());
        //tests that the scene has a vbox as its root
        //this is because the scene set for the stage is the
        //start scene which has a vbox as its root

        assertEquals(VBox.class, stage.getScene().getRoot().getClass());
    }


    @Test
    public void testMainMethodRuns() {
        new Thread(() -> {
            try {
                String [] args = { "one", "two", "three" };
                Main.main(args);
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
            }
            System.exit(0);
        }).start();
    }
}