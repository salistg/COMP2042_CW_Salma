package p4_group_8_repo.Views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Test for the StartScreenView class. </br>
 * Tests that the StartScreenView class is created correctly
 * with its buttons.
 */
public class StartScreenViewTest {
    /**
     * JavaFX rule to allow for testing of JavaFX applications.
     */
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
    /**
     * Creating a StartScreenView object for testing.
     */
    private StartScreenView startScreenView;
    /**
     * Stage object to add the StartScreenView to.
     */
    private Stage stage;

    /**
     * Set up before every test. </br>
     * Instantiates the StartScreenView and Stage objects.
     */
    @Before
    public void setUp(){
        stage = new Stage();
        startScreenView = new StartScreenView();
    }

    /**
     * Tests that the VBox has been correctly added.
     */
    @Test
    public void testVBoxAdded(){
        Scene scene = startScreenView.view(stage);
        assertNotNull(scene.getRoot());
        assertEquals(VBox.class, scene.getRoot().getClass());
    }

    /**
     * Tests that the VBox has 4 children each
     * of the type Button.
     */
    @Test
    public void testVBoxHas4Buttons(){
        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();

        assertEquals(4, vBox.getChildren().size());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(0).getClass());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(1).getClass());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(2).getClass());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(3).getClass());
    }

    /**
     * Tests that the VBox has the correct
     * width and height.
     */
    @Test
    public void testVBoxWidthAndHeight(){
        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();

        assertEquals(500,vBox.getWidth(),0.0001);
        assertEquals(600,vBox.getHeight(),0.0001);
    }

    /**
     * Tests that the VBox has the
     * correct StyleSheet.
     */
    @Test
    public void testVBoxHasStyleSheet(){

        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();

        assertTrue(Arrays.toString(vBox.getStylesheets().toArray()).contains("button.css"));
        assertEquals(1,vBox.getStylesheets().toArray().length);
        assertEquals("startScreenVBox", vBox.getId());
    }

    /**
     * Tests that the VBox background is correctly set.
     */
    @Test
    public void testVBoxBackgroundIsSet(){
        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();

        assertNotNull(vBox.getBackground());
       assertFalse(vBox.getBackground().isEmpty());
       assertEquals(1, vBox.getBackground().getImages().toArray().length);
    }

    /**
     * Tests that the Start button has been added to
     * the view with its action.
     */
    @Test
    public void testStartButtonAddedWithAction(){
        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button startButton = (Button) vBox.getChildren().get(0);
        assertEquals("Start Game", startButton.getText());
        assertNotNull(startButton.getOnAction());

    }

    /**
     * Tests that the Start button has the same minimum width and
     * height as its VBox's preferred width and height.
     */
    @Test
    public void testStartButtonPosition(){
        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button startButton = (Button) vBox.getChildren().get(0);
        assertEquals(vBox.getPrefHeight(), startButton.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), startButton.getMinWidth(),0.0001);
    }

    /**
     * Tests that the Help button has been added to
     * the view with its action.
     */
    @Test
    public void testHelpButtonAddedWithAction(){
        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button helpButton = (Button) vBox.getChildren().get(1);
        assertEquals("How to Play", helpButton.getText());
        assertNotNull(helpButton.getOnAction());
    }

    /**
     * Tests that the Help button has the same minimum width and
     * height as its VBox's preferred width and height.
     */
    @Test
    public void testHelpButtonPosition(){
        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button helpButton = (Button) vBox.getChildren().get(1);
        assertEquals(vBox.getPrefHeight(), helpButton.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), helpButton.getMinWidth(),0.0001);

    }

    /**
     * Tests that the Exit button has been added to
     * the view with its action.
     */
    @Test
    public void testExitButtonAddedWithAction(){
        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button exitButton = (Button) vBox.getChildren().get(3);
        assertEquals("Exit", exitButton.getText());
        assertNotNull(exitButton.getOnAction());

    }

    /**
     * Tests that the Exit button has the same minimum width and
     * height as its VBox's preferred width and height.
     */
    @Test
    public void testExitButtonPosition(){
        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button exitButton = (Button) vBox.getChildren().get(3);
        assertEquals(vBox.getPrefHeight(), exitButton.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), exitButton.getMinWidth(),0.0001);
    }

    /**
     * Tests that the High Score button has been added to
     * the view with its action.
     */
    @Test
    public void testHighScoreButtonAddedWithAction(){
        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button highScoreButton = (Button) vBox.getChildren().get(2);
        assertEquals("High-scores", highScoreButton.getText());
        assertNotNull(highScoreButton.getOnAction());

    }

    /**
     * Tests that the HighScores button has the same minimum width and
     * height as its VBox's preferred width and height.
     */
    @Test
    public void testHighScoreButtonPosition(){
        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button highScoreButton = (Button) vBox.getChildren().get(2);
        assertEquals(vBox.getPrefHeight(), highScoreButton.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), highScoreButton.getMinWidth(),0.0001);
    }
}