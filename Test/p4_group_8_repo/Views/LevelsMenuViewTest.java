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
 * Test for the LevelsMenuView class. </br>
 * Tests that the LevelsMenuView class is created correctly
 * with its buttons.
 */
public class LevelsMenuViewTest {
    /**
     * JavaFX rule to allow for testing of JavaFX applications.
     */
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
    /**
     * LevelsMenuView object for testing.
     */
    private LevelsMenuView levelsMenuView;
    /**
     * Stage object to add the LevelsMenuView to
     */
    private Stage stage;

    /**
     * Set up before every test. </br>
     * Instantiates the Stage and the LevelsMenuView objects.
     */
    @Before
    public void setUp() {
        stage = new Stage();
        levelsMenuView = new LevelsMenuView();
    }

    /**
     * Tests that the VBox has been correctly
     * added to the view.
     */
    @Test
    public void testVBoxAdded(){
        Scene scene = levelsMenuView.view(stage);
        assertNotNull(scene.getRoot());
        assertEquals(VBox.class, scene.getRoot().getClass());
    }

    /**
     * Tests that the VBox has 6 children each
     * of the type Button.
     */
    @Test
    public void testVBoxHas6Buttons(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();

        assertEquals(6, vBox.getChildren().size());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(0).getClass());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(1).getClass());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(2).getClass());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(3).getClass());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(4).getClass());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(5).getClass());
    }

    /**
     * Tests that the VBox has the correct
     * width and height.
     */
    @Test
    public void testVBoxWidthAndHeight(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();

        assertEquals(500,vBox.getWidth(),0.0001);
        assertEquals(600,vBox.getHeight(),0.0001);
    }

    /**
     * Tests that the VBox has the
     * correct StyleSheet
     */
    @Test
    public void testVBoxHasCorrectStyleSheet(){

        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();

        assertTrue(Arrays.toString(vBox.getStylesheets().toArray()).contains("button.css"));
        assertEquals(1,vBox.getStylesheets().toArray().length);
    }

    /**
     * Tests that the VBox background is correctly set.
     */
    @Test
    public void testVBoxBackgroundIsSet(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();

        assertNotNull(vBox.getBackground());
        assertFalse(vBox.getBackground().isEmpty());
        //tests that the vbox has only one background
        assertEquals(1, vBox.getBackground().getImages().toArray().length);
    }

    /**
     * Tests that the Level 1 button has been added to
     * the view with its action.
     */
    @Test
    public void testLevel1ButtonAddedWithAction(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level1Button = (Button) vBox.getChildren().get(0);
        assertEquals("Level 1", level1Button.getText());
        assertNotNull(level1Button.getOnAction());
    }

    /**
     * Tests that the Level 1 button has the same minimum width and
     * height as its VBox's preferred width and height.
     */
    @Test
    public void testLevel1ButtonWidthAndHeight(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level2Button = (Button) vBox.getChildren().get(0);
        assertEquals(vBox.getPrefHeight(), level2Button.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), level2Button.getMinWidth(),0.0001);
    }

    /**
     * Tests that the Level 2 button has been added to
     * the view with its action.
     */
    @Test
    public void testLevel2ButtonAddedWithAction(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level2Button = (Button) vBox.getChildren().get(1);
        assertEquals("Level 2", level2Button.getText());
        assertNotNull(level2Button.getOnAction());
    }

    /**
     * Tests that the Level 2 button has the same minimum width and
     * height as tits VBox's preferred width and height.
     */
    @Test
    public void testLevel2ButtonWidthAndHeight(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level3Button = (Button) vBox.getChildren().get(1);
        assertEquals(vBox.getPrefHeight(), level3Button.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), level3Button.getMinWidth(),0.0001);
    }

    /**
     * Tests that the Level 3 button has been added to
     * the view with its action.
     */
    @Test
    public void testLevel3ButtonAddedWithAction(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level3Button = (Button) vBox.getChildren().get(2);
        assertEquals("Level 3", level3Button.getText());
        assertNotNull(level3Button.getOnAction());
    }

    /**
     * Tests that the Level 3 button has the same minimum width and
     * height as tits VBox's preferred width and height.
     */
    @Test
    public void testLevel3ButtonWidthAndHeight(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level3Button = (Button) vBox.getChildren().get(2);
        assertEquals(vBox.getPrefHeight(), level3Button.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), level3Button.getMinWidth(),0.0001);
    }

    /**
     * Tests that the Level 4 button has been added to
     * the view with its action.
     */
    @Test
    public void testLevel4ButtonAddedWithAction(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level4Button = (Button) vBox.getChildren().get(3);
        assertEquals("Level 4", level4Button.getText());
        assertNotNull(level4Button.getOnAction());
    }

    /**
     * Tests that the Level 4 button has the same minimum width and
     * height as tits VBox's preferred width and height.
     */
    @Test
    public void testLevel4ButtonWidthAndHeight(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level4Button = (Button) vBox.getChildren().get(3);
        assertEquals(vBox.getPrefHeight(), level4Button.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), level4Button.getMinWidth(),0.0001);
    }

    /**
     * Tests that the Level 5 button has been added to
     * the view with its action.
     */
    @Test
    public void testLevel5ButtonAddedWithAction(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level5Button = (Button) vBox.getChildren().get(4);
        assertEquals("Level 5", level5Button.getText());
        assertNotNull(level5Button.getOnAction());
    }

    /**
     * Tests that the Level 1 button has the same minimum width and
     * height as tits VBox's preferred width and height.
     */
    @Test
    public void testLevel5ButtonWidthAndHeight(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level5Button = (Button) vBox.getChildren().get(4);
        assertEquals(vBox.getPrefHeight(), level5Button.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), level5Button.getMinWidth(),0.0001);
    }

    /**
     * Tests that the Back button has been added to
     * the view with its action.
     */
    @Test
    public void testBackButtonAddedWithAction(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button backButton = (Button) vBox.getChildren().get(5);
        assertEquals("Back to Main Menu", backButton.getText());
        assertNotNull(backButton.getOnAction());
    }

    /**
     * Tests that the Back button has the same minimum width and
     * height as tits VBox's preferred width and height.
     */
    @Test
    public void testBackButtonWidthAndHeight(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button backButton = (Button) vBox.getChildren().get(5);
        assertEquals(vBox.getPrefHeight(), backButton.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), backButton.getMinWidth(),0.0001);
    }
}