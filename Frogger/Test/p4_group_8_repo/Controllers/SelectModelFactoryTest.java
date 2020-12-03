package p4_group_8_repo.Controllers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.Models.*;

import static org.junit.Assert.*;

/**
 * Test for the SelectModelFactory class
 * to ensure the correct Models are instantiated
 * as per the choice of the caller class.
 */
public class SelectModelFactoryTest {
    /**
     * JavaFX rule to allow for testing of JavaFX applications.
     */
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
    /**
     * SelectModelFactory object for testing.
     */
    private SelectModelFactory selectModelFactory;

    /**
     * Set up before every test.
     * Instantiates the SelectModelFactory object.
     */
    @Before
    public void setUp() {
        selectModelFactory = new SelectModelFactory();
    }

    /**
     * Tests correct Animal object instantiation.
     * Tests that the Animal object has been instantiated correctly
     * with the correct X and Y coordinates, image, image height and width,
     * image smoothness and ratio.
     */
    @Test
    public void testCorrectAnimalInstantiation(){
        assertEquals(Animal.class,selectModelFactory.getAnimal().getClass());
//        setX(300);
//        setY(679.8 + (13.3333333 * 2));
//        setImage(new Image("file:src/p4_group_8_repo/images/froggerUp.png", 40, 40, true, true));
        Actor animal = selectModelFactory.getAnimal();
        assertEquals(300, animal.getX(),0.0001);
        assertEquals(679.8 + (13.3333333 * 2),animal.getY(),0.0001);
        assertEquals("file:src/p4_group_8_repo/images/froggerUp.png", animal.getImage().getUrl());
        assertTrue(animal.getImage().isPreserveRatio());
        assertTrue(animal.getImage().isSmooth());
    }

    /**
     * Tests correct EndGoal object instantiation.
     * Tests that the EndGoal object has been instantiated correctly
     * with the correct X and Y coordinates, image, image height and width,
     * image smoothness and ratio.
     */
    @Test
    public void testCorrectEndGoalInstantiation(){
        assertEquals(EndGoal.class, selectModelFactory.getActor(1,0,0,0,0,0).getClass());
        Actor end = selectModelFactory.getActor(1,10,20,0,0,0);
        assertEquals(20,end.getY(),0.0001);
        assertEquals(10,end.getX(),0.0001);
        assertEquals("file:src/p4_group_8_repo/images/End.png", end.getImage().getUrl());
        assertTrue(end.getImage().isPreserveRatio());
        assertTrue(end.getImage().isSmooth());
    }

    /**
     * Tests correct Digit object instantiation.
     * Tests that the Digit object has been instantiated correctly
     * with the correct X and Y coordinates, number,
     * image, image height and width,
     * image smoothness and ratio.
     */
    @Test
    public void testCorrectDigitInstantiation(){
        assertEquals(Digit.class, selectModelFactory.getActor(2,20,30,0,0,6).getClass());
        Actor digit = selectModelFactory.getActor(2,20,30,50,0,6);
        assertEquals(30,digit.getY(),0.0001);
        assertEquals(20,digit.getX(),0.0001);
        assertEquals("file:src/p4_group_8_repo/images/6.png", digit.getImage().getUrl());
        assertTrue(digit.getImage().isPreserveRatio());
        assertTrue(digit.getImage().isSmooth());
    }

    /**
     * Tests correct Turtle object instantiation.
     * Tests that the Turtle object has been instantiated correctly
     * with the correct X and Y coordinates,
     * image, image height and width,
     * image smoothness and ratio.
     */
    @Test
    public void testCorrectTurtleInitialisation(){
        assertEquals(Turtle.class, selectModelFactory.getActor(3,20,30,0,0,6).getClass());
        Actor turtle = selectModelFactory.getActor(3,20,30,50,0,6);
        assertEquals(30,turtle.getY(),0.0001);
        assertEquals(20,turtle.getX(),0.0001);
        assertEquals("file:src/p4_group_8_repo/images/TurtleAnimation2.png", turtle.getImage().getUrl());
        assertTrue(turtle.getImage().isPreserveRatio());
        assertTrue(turtle.getImage().isSmooth());
    }

    /**
     * Tests correct WetTurtle object instantiation.
     * Tests that the WetTurtle object has been instantiated correctly
     * with the correct X and Y coordinates,
     * image, image height and width,
     * image smoothness and ratio.
     */
    @Test
    public void testCorrectWetTurtleInitialisation(){
        assertEquals(WetTurtle.class, selectModelFactory.getActor(4,20,30,0,0,6).getClass());
        Actor wetTurtle = selectModelFactory.getActor(4,20,30,50,0,6);
        assertEquals(30,wetTurtle.getY(),0.0001);
        assertEquals(20,wetTurtle.getX(),0.0001);
        assertEquals("file:src/p4_group_8_repo/images/TurtleAnimation2Wet.png", wetTurtle.getImage().getUrl());
        assertTrue(wetTurtle.getImage().isPreserveRatio());
        assertTrue(wetTurtle.getImage().isSmooth());
    }

    /**
     * Tests correct Log object instantiation.
     * Tests that the Log object has been instantiated correctly
     * with the correct X and Y coordinates,
     * image, image height and width,
     * image smoothness and ratio.
     */
    @Test
    public void testCorrectLogInitialisation(){
        assertEquals(Log.class, selectModelFactory.getActorWithImage("file:src/p4_group_8_repo/images/log3.png",20,30,0,20).getClass());
        Actor log = selectModelFactory.getActorWithImage("file:src/p4_group_8_repo/images/log3.png",20,30,0,20);
        assertEquals(30,log.getY(),0.0001);
        assertEquals(20,log.getX(),0.0001);
        assertEquals("file:src/p4_group_8_repo/images/log3.png", log.getImage().getUrl());
        assertTrue(log.getImage().isPreserveRatio());
        assertTrue(log.getImage().isSmooth());
    }

    /**
     * Tests correct Obstacle object instantiation.
     * Tests that the Obstacle object has been instantiated correctly
     * with the correct X and Y coordinates,
     * image, image height and width,
     * image smoothness and ratio.
     */
    @Test
    public void testCorrectObstacleInitialisation(){
        assertEquals(Obstacle.class, selectModelFactory.getActorWithImage("file:src/p4_group_8_repo/images/car1Left.png",20,30,0,20).getClass());
        Actor obstacle = selectModelFactory.getActorWithImage("file:src/p4_group_8_repo/images/car1Left.png",20,30,0,20);
        assertEquals(30,obstacle.getY(),0.0001);
        assertEquals(20,obstacle.getX(),0.0001);
        assertEquals("file:src/p4_group_8_repo/images/car1Left.png", obstacle.getImage().getUrl());
        assertTrue(obstacle.getImage().isPreserveRatio());
        assertTrue(obstacle.getImage().isSmooth());
    }




}