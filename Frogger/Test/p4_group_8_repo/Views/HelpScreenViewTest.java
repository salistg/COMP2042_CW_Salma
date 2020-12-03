package p4_group_8_repo.Views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;

import static org.junit.Assert.*;

/**
 * Test for the HelpScreenView class. </br>
 * Tests that the HelpScreenView class is created correctly
 * with its buttons.
 */
public class HelpScreenViewTest {
    /**
     * JavaFX rule to allow for testing of JavaFX applications.
     */
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
    /**
     * HelpScreenView object for testing.
     */
    private HelpScreenView helpScreenView;
    /**
     *  Stage object to add the HelpScreenView to
     */
    private Stage stage;

    /**
     * Set up before every test. </br>
     * Instantiates the Stage and the HelpScreenView objects.
     */
    @Before
    public void setUp() {
        helpScreenView = new HelpScreenView();
        stage = new Stage();
    }

    /**
     * Tests that the VBox has been correctly
     * added to the view.
     */
    @Test
    public void testVBoxAdded(){
        Scene scene = helpScreenView.view(stage);
        assertNotNull(scene.getRoot());
        assertEquals(VBox.class, scene.getRoot().getClass());
    }

    /**
     * Tests that the VBox has 2 children one of the
     * type ToggleButton and the other of type Button.
     */
    @Test
    public void testVBoxHas2Buttons(){
        Scene scene = helpScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();

        assertEquals(2, vBox.getChildren().size());
        assertEquals(javafx.scene.control.ToggleButton.class,
                vBox.getChildren().get(0).getClass());
        assertEquals(javafx.scene.control.Button.class,
                vBox.getChildren().get(1).getClass());
    }

    /**
     * Tests that the VBox's background is correctly set.
     */
    @Test
    public void testVBoxBackgroundIsSet(){
        Scene scene = helpScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();

        assertNotNull(vBox.getBackground());
        assertFalse(vBox.getBackground().isEmpty());
        assertEquals(1, vBox.getBackground().getImages().toArray().length);
    }

    /**
     * Tests that the toggle button (back button) is correctly added
     * and that it has the correct label, "Back".
     */
    @Test
    public void testBackButtonAdded(){
        Scene scene = helpScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        ToggleButton backButton = (ToggleButton) vBox.getChildren().get(0);
        assertEquals("Back", backButton.getText());
    }

    /**
     * Tests that the back button has an action.
     */
    @Test
    public void testBackButtonAction() {
        Scene scene = helpScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        ToggleButton backButton = (ToggleButton) vBox.getChildren().get(0);
        assertNotNull(backButton.getOnAction());
    }

    /**
     * Tests that the next button has been added.
     */
    @Test
    public void testNextButtonAdded(){
        Scene scene = helpScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button nextButton = (Button) vBox.getChildren().get(1);
        assertEquals("Next", nextButton.getText());
    }

    /**
     * Tests that the next button has an action.
     */
    @Test
    public void testNextButtonAction() {
        Scene scene = helpScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button nextButton = (Button) vBox.getChildren().get(1);
        assertNotNull(nextButton.getOnAction());
    }
}