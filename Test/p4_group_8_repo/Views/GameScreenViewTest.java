package p4_group_8_repo.Views;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.Controllers.SelectModelFactory;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.Models.*;

import static org.junit.Assert.*;

/**
 * Test for the GameScreenView class. </br>
 * Tests that the GameScreenView class is created correctly
 * according to the level chosen.
 */
public class GameScreenViewTest {
    /**
     * JavaFX rule to allow for testing of JavaFX applications.
     */
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    /**
     * Creating a GameScreenView object for testing.
     */
    private GameScreenView gameScreenView;
    /**
     * MyStage object to add the actors to
     */
    private World myStage;
    /**
     * Stage to add the view to
     */
    private Stage stage;

    /**
     * Setting up before every test. </br>
     * Instantiates the actor, myStage, gameScreenView and stage objects.
     */
    @Before
    public void setUp() {
        myStage = new MyStage();
        stage = new Stage();
        gameScreenView = new GameScreenView(0, myStage);
    }

    /**
     * Tests that initially the stage only has 3 children of
     * types VBox, ToggleButton and Animal.
     */
    @Test
    public void testInitalNodesInStage(){
        //since level is 0, when we call the view method
        //mystage should only have three children
        //vbox and togglebutton
        gameScreenView.view(stage);
        assertEquals(3, myStage.getChildren().size());
        assertEquals(VBox.class, myStage.getChildren().get(0).getClass());
        assertEquals(ToggleButton.class, myStage.getChildren().get(2).getClass());
        assertEquals(Animal.class, myStage.getChildren().get(1).getClass());
    }

    /**
     * Tests that the VBox and the ToggleButton are correctly added.</br>
     * Tests that they are at the correct positions and that the toggle button
     * has the correct label, "Back".
     */
    @Test
    public void testVBoxAndButtonCorrectlyCreated(){
        gameScreenView.view(stage);
        VBox vBox = (VBox) myStage.getChildren().get(0);
        assertEquals(559,vBox.getLayoutX(),0.0001);
        assertEquals(Pos.TOP_RIGHT,vBox.getAlignment());
        assertEquals(Button.class, vBox.getChildren().get(0).getClass());
        Button button = (Button) vBox.getChildren().get(0);
        assertEquals("Back", button.getText());
    }

    /**
     * Tests that the background of the stage is initially
     * empty.
     */
    @Test
    public void testBackgroundIsNullInitially(){
        //level 0, no background so should be null
        myStage.getBackground();
        assertNull(myStage.getBackground());
    }

    /**
     * Sets that the correct background is set when level 1 is chosen.
     */
    @Test
    public void testBackGroundIsSetLevel1(){
        gameScreenView = new GameScreenView(1, myStage);
        gameScreenView.view(stage);
        assertNotNull(myStage.getBackground());
        assertEquals(myStage.getBackground().getClass(),Background.class);
    }

    /**
     * Sets that the correct background is set when level 2 is chosen.
     */
    @Test
    public void testBackGroundIsSetLevel2(){
        gameScreenView = new GameScreenView(2, myStage);
        gameScreenView.view(stage);
        assertNotNull(myStage.getBackground());
        assertEquals(myStage.getBackground().getClass(),Background.class);
    }

    /**
     * Sets that the correct background is set when level 3 is chosen.
     */
    @Test
    public void testBackGroundIsSetLevel3(){
        gameScreenView = new GameScreenView(3, myStage);
        gameScreenView.view(stage);
        assertNotNull(myStage.getBackground());
        assertEquals(myStage.getBackground().getClass(),Background.class);
    }

    /**
     * Sets that the correct background is set when level 4 is chosen.
     */
    @Test
    public void testBackGroundIsSetLevel4(){
        gameScreenView = new GameScreenView(4, myStage);
        gameScreenView.view(stage);
        assertNotNull(myStage.getBackground());
        assertEquals(myStage.getBackground().getClass(),Background.class);
    }

    /**
     * Sets that the correct background is set when level 5 is chosen.
     */
    @Test
    public void testBackGroundIsSetLevel5(){
        gameScreenView = new GameScreenView(5, myStage);
        gameScreenView.view(stage);
        assertNotNull(myStage.getBackground());
        assertEquals(myStage.getBackground().getClass(),Background.class);
    }

    /**
     * Tests that there are no objects of type Actor in the stage
     * when the level is set to 0.
     */
    @Test
    public void testNoActorsAddedWhenLevelNotSpecified(){
        assertEquals(0, myStage.getChildren().size());
        assertEquals(0, myStage.getObjects(Log.class).size());
        assertEquals(0, myStage.getObjects(Obstacle.class).size());
        assertEquals(0, myStage.getObjects(Turtle.class).size());
        assertEquals(0, myStage.getObjects(WetTurtle.class).size());
        assertEquals(0, myStage.getObjects(EndGoal.class).size());
    }

    /**
     * Tests that the correct number of actors are added to level 1.
     */
    @Test
    public void testAddingAllActorsToLevel1() {
      //check if it has children
      gameScreenView = new GameScreenView(1, myStage);
      gameScreenView.view(stage);
      assertNotNull(myStage.getChildren());
      //make sure that it has all the children
      //it should have 33 children
      assertEquals(33, myStage.getChildren().size());
      assertEquals(8, myStage.getObjects(Log.class).size());
      assertEquals(10, myStage.getObjects(Obstacle.class).size());
      assertEquals(2, myStage.getObjects(Turtle.class).size());
      assertEquals(4, myStage.getObjects(WetTurtle.class).size());
      assertEquals(5, myStage.getObjects(EndGoal.class).size());
  }

    /**
     * Tests that the correct number of actors are added to level 2.
     */
    @Test
    public void testAddingAllActorsToLevel2(){
        //check if it has children
        gameScreenView = new GameScreenView(2, myStage);
        gameScreenView.view(stage);
        assertNotNull(myStage.getChildren());
        //make sure that it has all the children
        //it should have 34 children
        assertEquals(34, myStage.getChildren().size());
        assertEquals(8, myStage.getObjects(Log.class).size());
        assertEquals(11, myStage.getObjects(Obstacle.class).size());
        assertEquals(2, myStage.getObjects(Turtle.class).size());
        assertEquals(4, myStage.getObjects(WetTurtle.class).size());
        assertEquals(5, myStage.getObjects(EndGoal.class).size());
    }

    /**
     * Tests that the correct number of actors are added to level 3.
     */
    @Test
    public void testAddingAllActorsToLevel3(){
        //check if it has children
        gameScreenView = new GameScreenView(3, myStage);
        gameScreenView.view(stage);
        assertNotNull(myStage.getChildren());
        //make sure that it has all the children
        //it should have 37 children
        assertEquals(37, myStage.getChildren().size());
        assertEquals(9, myStage.getObjects(Log.class).size());
        assertEquals(13, myStage.getObjects(Obstacle.class).size());
        assertEquals(2, myStage.getObjects(Turtle.class).size());
        assertEquals(4, myStage.getObjects(WetTurtle.class).size());
        assertEquals(5, myStage.getObjects(EndGoal.class).size());
    }

    /**
     * Tests that the correct number of actors are added to level 4.
     */
    @Test
    public void testAddingAllActorsToLevel4(){
        //check if it has children
        gameScreenView = new GameScreenView(4, myStage);
        gameScreenView.view(stage);
        assertNotNull(myStage.getChildren());
        //make sure that it has all the children
        //it should have 41 children
        assertEquals(40, myStage.getChildren().size());
        assertEquals(12, myStage.getObjects(Log.class).size());
        assertEquals(3, myStage.getObjects(Obstacle.class).size());
        assertEquals(5, myStage.getObjects(Turtle.class).size());
        assertEquals(11, myStage.getObjects(WetTurtle.class).size());
        assertEquals(5, myStage.getObjects(EndGoal.class).size());
    }

    /**
     * Tests that the correct number of actors are added to level 5.
     */
    @Test
    public void testAddingAllActorsToLevel5(){
        // in level 1: addObstacle(1,false);
        //check if it has children
        gameScreenView = new GameScreenView(5, myStage);
        gameScreenView.view(stage);
        assertNotNull(myStage.getChildren());
        //make sure that it has all the children
        //it should have 41 children
        assertEquals(13, myStage.getObjects(Log.class).size());
        assertEquals(6, myStage.getObjects(Obstacle.class).size());
        assertEquals(5, myStage.getObjects(Turtle.class).size());
        assertEquals(11, myStage.getObjects(WetTurtle.class).size());
        assertEquals(5, myStage.getObjects(EndGoal.class).size());
    }

}