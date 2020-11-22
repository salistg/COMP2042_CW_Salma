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
 * Test for the MyStage class and its
 * superclass World.
 *
 * Since World is an abstract class,
 * it is tested via the class that inherits it
 * and that is MyStage.
 *
 * Tests that MyStage performs its functionalities
 * correctly and that it also inherits
 * the methods correctly from the World class.
 */
public class MyStageTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
    World myStage;

    @Before
    public void setUp() {
        myStage = new MyStage();
    }

   @Test
    public void testAdding1ActorToMyStage(){
       Actor animal = new Animal();
       myStage.add(animal);
       assertNotNull(myStage.getChildren());
       assertEquals(1,myStage.getChildren().size());
       assertEquals(Animal.class, myStage.getChildren().get(0).getClass());
   }

   @Test
   public void testMyStageIsEmptyAtCreation(){
       assertEquals(0, myStage.getChildren().toArray().length);
   }

   @Test
   public void testMyStageIsPartOfSceneGraph(){
        assertNotNull(myStage.sceneProperty());
   }

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

   @Test
    public void testTimerRunning(){
        myStage.start();
       assertTrue(myStage.getTimerRunning());
   }

   @Test
    public void testTimerStopping(){
        myStage.start();
        myStage.stop();
        assertFalse(myStage.getTimerRunning());
   }

   @Test
    public void addingStageToScene(){
        Scene scene = new Scene(myStage);
        assertEquals(MyStage.class, scene.getRoot().getClass());
        assertNotNull(myStage.getScene());
   }

   @Test
    public void testMusicIsPlaying(){
        myStage.playMusic();
        assertTrue(myStage.getIsMusicPlaying());
        myStage.stopMusic();
   }

   @Test
    public void testMusicIsStopping(){
        myStage.playMusic();
        myStage.stopMusic();
        assertFalse(myStage.getIsMusicPlaying());
   }
}