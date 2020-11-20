package p4_group_8_repo.Views;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.Models.*;

import static org.junit.Assert.*;

public class GameScreenViewTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    GameScreenView gameScreenView;
    Actor animal;
    World myStage;
    Stage stage;

    @Before
    public void setUp() {
        animal = new SelectModelFactory().getAnimal();
        myStage = new MyStage();
        stage = new Stage();
        gameScreenView = new GameScreenView(0,animal, myStage);
    }

    /**
     * Tests whether a VBox and a ToggleButton
     * are added to the stage.
     *
     * When the GameScreenView class is initiated with level 0,
     * the stage should only have those two as its children.
     */
    @Test
    public void testAddingOfNodesToStage(){
        //since level is 0, when we call the view method
        //mystage should only have two children
        //vbox and togglebutton
        gameScreenView.view(stage);
        //System.out.println(Arrays.toString(mystage.getChildren().toArray()));
        assertEquals(2, myStage.getChildren().size());
        assertEquals(VBox.class, myStage.getChildren().get(0).getClass());
        assertEquals(ToggleButton.class, myStage.getChildren().get(1).getClass());


    }

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
     * Tests that when no level is picked,
     * the background is null.
     */
    @Test
    public void testBackgroundIsNull(){
        //level 0, no background so should be null
        myStage.getBackground();
        assertNull(myStage.getBackground());
    }

    /**
     * Tests that a background is set
     * when a level is chosen.
     */
    @Test
    public void testBackGroundIsSetLevel1(){
        gameScreenView = new GameScreenView(1,animal, myStage);
        gameScreenView.view(stage);
        assertNotNull(myStage.getBackground());
        assertEquals(myStage.getBackground().getClass(),Background.class);
    }

    @Test
    public void testBackGroundIsSetLevel2(){
        gameScreenView = new GameScreenView(2,animal, myStage);
        gameScreenView.view(stage);
        assertNotNull(myStage.getBackground());
        assertEquals(myStage.getBackground().getClass(),Background.class);
    }

    @Test
    public void testBackGroundIsSetLevel3(){
        gameScreenView = new GameScreenView(3,animal, myStage);
        gameScreenView.view(stage);
        assertNotNull(myStage.getBackground());
        assertEquals(myStage.getBackground().getClass(),Background.class);
    }

    @Test
    public void testBackGroundIsSetLevel4(){
        gameScreenView = new GameScreenView(4,animal, myStage);
        gameScreenView.view(stage);
        assertNotNull(myStage.getBackground());
        assertEquals(myStage.getBackground().getClass(),Background.class);
    }

    @Test
    public void testBackGroundIsSetLevel5(){
        gameScreenView = new GameScreenView(5,animal, myStage);
        gameScreenView.view(stage);
        assertNotNull(myStage.getBackground());
        assertEquals(myStage.getBackground().getClass(),Background.class);
    }

    @Test
    public void testNoActorsAddedWhenLevelNotSpecified(){
        assertEquals(0, myStage.getChildren().size());
        assertEquals(0, myStage.getObjects(Log.class).size());
        assertEquals(0, myStage.getObjects(Obstacle.class).size());
        assertEquals(0, myStage.getObjects(Turtle.class).size());
        assertEquals(0, myStage.getObjects(WetTurtle.class).size());
        assertEquals(0, myStage.getObjects(End.class).size());
    }
  @Test
    public void testAddingAllActorsToLevel1() {
      //check if it has children
      gameScreenView = new GameScreenView(1, animal, myStage);
      gameScreenView.view(stage);
      assertNotNull(myStage.getChildren());
      //make sure that it has all the children
      //it should have 33 children
      assertEquals(33, myStage.getChildren().size());
      assertEquals(8, myStage.getObjects(Log.class).size());
      assertEquals(10, myStage.getObjects(Obstacle.class).size());
      assertEquals(2, myStage.getObjects(Turtle.class).size());
      assertEquals(4, myStage.getObjects(WetTurtle.class).size());
      assertEquals(5, myStage.getObjects(End.class).size());
  }

    @Test
    public void testAddingAllActorsToLevel2(){
        //check if it has children
        gameScreenView = new GameScreenView(2,animal, myStage);
        gameScreenView.view(stage);
        assertNotNull(myStage.getChildren());
        //make sure that it has all the children
        //it should have 34 children
        assertEquals(34, myStage.getChildren().size());
        assertEquals(8, myStage.getObjects(Log.class).size());
        assertEquals(11, myStage.getObjects(Obstacle.class).size());
        assertEquals(2, myStage.getObjects(Turtle.class).size());
        assertEquals(4, myStage.getObjects(WetTurtle.class).size());
        assertEquals(5, myStage.getObjects(End.class).size());
    }

    @Test
    public void testAddingAllActorsToLevel3(){
        //check if it has children
        gameScreenView = new GameScreenView(3,animal, myStage);
        gameScreenView.view(stage);
        assertNotNull(myStage.getChildren());
        //make sure that it has all the children
        //it should have 37 children
        assertEquals(37, myStage.getChildren().size());
        assertEquals(8, myStage.getObjects(Log.class).size());
        assertEquals(13, myStage.getObjects(Obstacle.class).size());
        assertEquals(2, myStage.getObjects(Turtle.class).size());
        assertEquals(4, myStage.getObjects(WetTurtle.class).size());
        assertEquals(5, myStage.getObjects(End.class).size());
    }

    @Test
    public void testAddingAllActorsToLevel4(){
        //check if it has children
        gameScreenView = new GameScreenView(4,animal, myStage);
        gameScreenView.view(stage);
        assertNotNull(myStage.getChildren());
        //make sure that it has all the children
        //it should have 41 children
        assertEquals(41, myStage.getChildren().size());
        assertEquals(15, myStage.getObjects(Log.class).size());
        assertEquals(1, myStage.getObjects(Obstacle.class).size());
        assertEquals(5, myStage.getObjects(Turtle.class).size());
        assertEquals(11, myStage.getObjects(WetTurtle.class).size());
        assertEquals(5, myStage.getObjects(End.class).size());
    }

    @Test
    public void testAddingAllActorsToLevel5(){
        // in level 1: addObstacle(1,false);
        //check if it has children
        gameScreenView = new GameScreenView(5,animal, myStage);
        gameScreenView.view(stage);
        assertNotNull(myStage.getChildren());
        //make sure that it has all the children
        //it should have 41 children
        assertEquals(16, myStage.getObjects(Log.class).size());
        assertEquals(4, myStage.getObjects(Obstacle.class).size());
        assertEquals(5, myStage.getObjects(Turtle.class).size());
        assertEquals(11, myStage.getObjects(WetTurtle.class).size());
        assertEquals(5, myStage.getObjects(End.class).size());
    }

}