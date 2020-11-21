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

public class HelpScreenViewTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
    HelpScreenView helpScreenView;
    Stage stage;

    @Before
    public void setUp() throws Exception {
        helpScreenView = new HelpScreenView();
        stage = new Stage();
    }

    @Test
    public void testVBoxAdded(){
        Scene scene = helpScreenView.view(stage);
        assertNotNull(scene.getRoot());
        assertEquals(VBox.class, scene.getRoot().getClass());
    }

    @Test
    public void testVBoxHas1Button(){
        Scene scene = helpScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();

        assertEquals(1, vBox.getChildren().size());
        assertEquals(javafx.scene.control.ToggleButton.class,
                vBox.getChildren().get(0).getClass());
    }

    @Test
    public void testVBoxBackgroundIsSet(){
        Scene scene = helpScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();

        assertNotNull(vBox.getBackground());
        assertFalse(vBox.getBackground().isEmpty());
        assertEquals(1, vBox.getBackground().getImages().toArray().length);
    }

    @Test
    public void testBackButtonAdded(){
        Scene scene = helpScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        ToggleButton backButton = (ToggleButton) vBox.getChildren().get(0);
        assertEquals("Back", backButton.getText());
    }

    @Test
    public void testBackButtonAction() {
        Scene scene = helpScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        ToggleButton backButton = (ToggleButton) vBox.getChildren().get(0);
        assertNotNull(backButton.getOnAction());
    }
}