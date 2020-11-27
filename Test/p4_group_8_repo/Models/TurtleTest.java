package p4_group_8_repo.Models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.Views.MyStage;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Test for the Turtle class.
 */
public class TurtleTest {
    /**
     * JavaFX rule to allow for testing on JavaFX applications
     */
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    /**
     * Turtle object for testing
     */
    private Turtle turtle;

    /**
     * Set up before every test.
     * Instantiates the Turtle object.
     */
    @Before
    public void setUp() {
        turtle = new Turtle(360,360,3,40);
    }

    /**
     * Test that the Turtle object is at the correct X
     * position after instantiation.
     */
    @Test
    public void testXPosition(){
        Assert.assertEquals(360, turtle.getX(),0.0001);
    }

    /**
     * Test that the Turtle object is at the correct Y
     * position after instantiation.
     */
    @Test
    public void testYPosition(){
        Assert.assertEquals(360, turtle.getY(), 0.0001);
    }

    /**
     * Tests that the Y position can be set to negative.
     */
    @Test
    public void testNegativeYPosition(){
        turtle.setY(-370);
        Assert.assertEquals(-370, turtle.getY(), 0.0001);
    }

    /**
     * Tests that the X position can be set to negative.
     */
    @Test
    public void testNegativeXPosition(){
        turtle.setX(-360);
        Assert.assertEquals(-360, turtle.getX(), 0.0001);
    }

    /**
     * Tests the movement of the Turtle object. </br>
     * Tests that the X and Y coordinates change when the move method is called.
     */
    @Test
    public void testMovement() {
        //current x=360
        //current y=360

        int speed = 2;
        turtle.move(speed,0);
        assertEquals(360+speed,turtle.getX(),0.0001);
        turtle.move(0,speed);
        assertEquals(360+speed,turtle.getY(),0.0001);
        turtle.move(speed,speed);
        assertEquals(360+speed+speed,turtle.getX(),0.0001);
        assertEquals(360+speed+speed,turtle.getY(),0.0001);
    }

    /**
     * Tests the setting of the X coordinate of the Turtle object
     * when the conditions in the act method are met. </br>
     *
     * Conditions tested: </br>
     * <pre>
     *     if (getX() > 600 && speed>0)
     *     setX(-200);
     * </pre>
     */
    @Test
    public void testSettingOfX(){
//        if (getX() > 600 && speed>0)
//            setX(-200);

        turtle.setX(800);
        turtle.act(10000);
        assertEquals(-200,turtle.getX(),0.0001);

    }

    /**
     * Tests the setting of the X coordinate of the Turtle object
     * when the conditions in the act method are met. </br>
     *
     * Conditions tested: </br>
     * <pre>
     *     if (getX() < -75 && speed<0)
     *     setX(600);
     * </pre>
     */
    @Test
    public void testSettingOfX2(){
//        if (getX()<-75 && speed<0)
//            setX(600);

        Turtle turtle2 = new Turtle(-80,360,-3,30);
        turtle2.act(10000);
        assertEquals(600,turtle2.getX(),0.0001);
    }

    /**
     * Tests the getObjectController method
     * to ensure that the method returns null as Turtle does not have a controller.
     */
    @Test
    public void testGettingObjectController(){
        Assert.assertNull(turtle.getActorController());
    }

    /**
     * Tests that the Turtle object has a
     * parent when it is added to the stage.
     *
     * Tests that the parent is the MyStage world
     * that the Turtle is added to.
     */
    @Test
    public void testTurtleParent(){
        Assert.assertNull(turtle.getParent());
        MyStage myStage = new MyStage();
        myStage.add(turtle);
        Assert.assertNotNull(turtle.getParent());
        Assert.assertEquals(myStage,turtle.getParent());
    }

    //Image tests

    /**
     * Tests the Turtle object's main image at
     * instantiation is smooth and has
     * a preserved ratio.
     */
    @Test
    public void testMainImageSmoothnessAndRatio(){
        Assert.assertTrue(turtle.getImage().isPreserveRatio());
        Assert.assertTrue(turtle.getImage().isSmooth());
    }

    /**
     * Tests that the width and height of the main
     * image of the Turtle object are correctly set.
     */
    @Test
    public void testMainImageWidthAndHeight(){
        //initial w=40
        //initial h=60

        assertEquals(40,turtle.getImage().getRequestedWidth(),0.0001);
        assertEquals(40,turtle.getImage().getRequestedHeight(),0.0001);

        Turtle turtle2 = new Turtle(-60,360,-3,20);
        assertEquals(20,turtle2.getImage().getRequestedWidth(),0.0001);
        assertEquals(20,turtle2.getImage().getRequestedHeight(),0.0001);


    }

    /**
     * Tests that the main image of the Turtle object
     * is correctly set.
     */
    @Test
    public void testMainImageIsSet(){
        Assert.assertNotNull(turtle.getImage());
        Assert.assertFalse(turtle.getImage().isError());
    }

    /**
     * Tests that the image changes at certain timeframes.
     */
    @Test
    public void testImageChange(){
//        if (now/900000000  % 3 ==0) {
//            setImage(turtle2);
//        }
//        else if (now/900000000 % 3 == 1) {
//            setImage(turtle1);
//        }
//        else if (now/900000000 %3 == 2) {
//            setImage(turtle3);
//        }

        turtle.act(2700000000L);
        assertEquals("file:src/p4_group_8_repo/images/TurtleAnimation2.png", turtle.getImage().getUrl());
        turtle.act(3600000000L);
        assertEquals("file:src/p4_group_8_repo/images/TurtleAnimation1.png", turtle.getImage().getUrl());
        turtle.act(4500000000L);
        assertEquals("file:src/p4_group_8_repo/images/TurtleAnimation3.png", turtle.getImage().getUrl());


    }

    /**
     * Tests the adding of Turtle objects to the stage.
     */
    @Test
    public void testTurtleAdding(){
//        for (int j : new int[]{500, 300}) {
//            background.add(new Turtle(j, turtleY, -1, 130, 130));
//        }

        ArrayList<Turtle> turtleArrayList = new ArrayList<>();
        for (int j : new int[]{500, 300}) {
            turtleArrayList.add(new Turtle(j, 300, -1, 130));
        }

        MyStage stage = new MyStage();
        for (int j : new int[]{500, 300}) {
            stage.add(new Turtle(j, 300, -1, 130));
        }

        assertEquals(turtleArrayList.size(), stage.getChildren().size());
        assertNotNull(stage.getChildren());
        assertNotNull(stage.getObjects(Turtle.class));
    }


}