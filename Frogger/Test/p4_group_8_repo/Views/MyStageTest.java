package p4_group_8_repo.Views;

import javafx.scene.Scene;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.Models.*;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Test for the MyStage class.
 */
public class MyStageTest {
    /**
     * JavaFX rule to allow for testing of JavaFX applications.
     */
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    /**
     * World object for testing
     */
    private World myStage;

    /**
     * Set up before every test.
     * Instantiates the World object to be a MyStage object.
     */
    @Before
    public void setUp() {
        myStage = new MyStage();
    }

    /**
     * Tests adding one Actor object to the World.
     */
   @Test
    public void testAdding1ActorToMyStage(){
       Actor animal = new Animal();
       myStage.add(animal);
       assertNotNull(myStage.getChildren());
       assertEquals(1,myStage.getChildren().size());
       assertEquals(Animal.class, myStage.getChildren().get(0).getClass());
   }

    /**
     * Tests that the World is initially empty
     * without any children at creation.
     */
   @Test
   public void testMyStageIsEmptyAtCreation(){
       assertEquals(0, myStage.getChildren().toArray().length);
   }

    /**
     * Tests that the World is
     * part of the scene graph.
     */
   @Test
   public void testMyStageIsPartOfSceneGraph(){
        assertNotNull(myStage.sceneProperty());
   }

    /**
     * Tests adding multiple Actor objects of different types
     * to the World.
     */
   @Test
    public void testAddingMultipleActorsToMyStage(){
        Actor animal = new Animal();
        Actor log = new Log("file:src/p4_group_8_repo/images/log3.png",100,20,30,1);
        Actor obstacle = new Obstacle("file:src/p4_group_8_repo/images/car1Left.png",20,30,1,100);
        Actor turtle = new Turtle(20,30,1,100);
        myStage.add(animal);
        myStage.add(log);
        myStage.add(obstacle);
        myStage.add(turtle);

        assertNotNull(myStage.getChildren());
        assertEquals(4, myStage.getChildren().size());
        assertEquals(Animal.class, myStage.getChildren().get(0).getClass());
       assertEquals(Log.class, myStage.getChildren().get(1).getClass());
       assertEquals(Obstacle.class, myStage.getChildren().get(2).getClass());
       assertEquals(Turtle.class, myStage.getChildren().get(3).getClass());
   }

    /**
     * Tests the getObject method defined in the abstract
     * class World. Tests that the correct objects
     * are returned when the method is called.
     */
   @Test
    public void testGettingObjects(){
       Actor animal = new Animal();
       Actor animal1 = new Animal();
       Actor log = new Log("file:src/p4_group_8_repo/images/log3.png",100,20,30,1);
       Actor obstacle = new Obstacle("file:src/p4_group_8_repo/images/car1Left.png",20,30,1,100);
       Actor turtle = new Turtle(20,30,1,100);

       myStage.add(animal);
       myStage.add(animal1);
       myStage.add(log);
       myStage.add(obstacle);
       myStage.add(turtle);

       assertEquals(5,myStage.getObjects(Actor.class).size());
       assertEquals(2,myStage.getObjects(Animal.class).size());
       assertEquals(1,myStage.getObjects(Log.class).size());
       assertEquals(1,myStage.getObjects(Obstacle.class).size());
       assertEquals(1,myStage.getObjects(Turtle.class).size());
   }

    /**
     * Tests that the animation timer
     * is running when the start method is called.
     */
   @Test
    public void testTimerRunning(){
        myStage.start();
       assertTrue(myStage.getTimerRunning());
   }

    /**
     * Tests that the animation timer
     * has stopped when the stop method is called.
     */
   @Test
    public void testTimerStopping(){
        myStage.start();
        myStage.stop();
        assertFalse(myStage.getTimerRunning());
   }

    /**
     * Tests that the World (MyStage)
     * can be added to a Scene.
     */
   @Test
    public void addingStageToScene(){
        Scene scene = new Scene(myStage);
        assertEquals(MyStage.class, scene.getRoot().getClass());
        assertNotNull(myStage.getScene());
   }

    /**
     * Tests that the music of the World
     * is playing when the playMusic method is called.
     */
   @Test
    public void testMusicIsPlaying(){
        myStage.playMusic();
        assertTrue(myStage.getIsMusicPlaying());
        myStage.stopMusic();
   }

    /**
     * Tests that the music has stopped playing
     * when the stopMusic method is called.
     */
   @Test
    public void testMusicHasStopped(){
        myStage.playMusic();
        myStage.stopMusic();
        assertFalse(myStage.getIsMusicPlaying());
   }
}