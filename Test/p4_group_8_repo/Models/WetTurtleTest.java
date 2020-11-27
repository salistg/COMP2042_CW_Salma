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
 * Test for the WetTurtle class.
 */
public class WetTurtleTest {
    /**
     * JavaFX rule to allow for testing on JavaFX applications
     */
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    /**
     * WetTurtle object for testing
     */
    private WetTurtle wetTurtle;

    /**
     * Set up before every test.
     * Instantiates the WetTurtle object.
     */
    @Before
    public void setUp() {
        wetTurtle = new WetTurtle(600, 700, 1, 130);
    }

    /**
     * Test that the WetTurtle object is at the correct X
     * position after instantiation.
     */
    @Test
    public void testXPosition(){
        Assert.assertEquals(600, wetTurtle.getX(),0.0001);
    }

    /**
     * Test that the WetTurtle object is at the correct Y
     * position after instantiation.
     */
    @Test
    public void testYPosition(){
        Assert.assertEquals(700, wetTurtle.getY(), 0.0001);
    }

    /**
     * Tests that the Y position can be set to negative.
     */
    @Test
    public void testNegativeYPosition(){
        wetTurtle.setY(-370);
        Assert.assertEquals(-370, wetTurtle.getY(), 0.0001);
    }

    /**
     * Tests that the X position can be set to negative.
     */
    @Test
    public void testNegativeXPosition(){
        wetTurtle.setX(-360);
        Assert.assertEquals(-360, wetTurtle.getX(), 0.0001);
    }

    /**
     * Tests the movement of the WetTurtle object. </br>
     * Tests that the X and Y coordinates change when the move method is called.
     */
    @Test
    public void testMovement() {
        //current x=600
        //current y=700

        int speed = 2;
        wetTurtle.move(speed,0);
        assertEquals(600+speed,wetTurtle.getX(),0.0001);
        wetTurtle.move(0,speed);
        assertEquals(700+speed,wetTurtle.getY(),0.0001);
        wetTurtle.move(speed,speed);
        assertEquals(600+speed+speed,wetTurtle.getX(),0.0001);
        assertEquals(700+speed+speed,wetTurtle.getY(),0.0001);
    }

    /**
     * Tests the setting of the X coordinate of the WetTurtle object
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

        wetTurtle.setX(800);
        wetTurtle.act(10000);
        assertEquals(-200,wetTurtle.getX(),0.0001);

    }

    /**
     * Tests the setting of the X coordinate of the WetTurtle object
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

        WetTurtle wetTurtle2 = new WetTurtle(-80,360,-3,30);
        wetTurtle2.act(10000);
        assertEquals(600,wetTurtle2.getX(),0.0001);
    }

    /**
     * Tests the getObjectController method
     * to ensure that the method returns null as WetTurtle does not have a controller.
     */
    @Test
    public void testGettingObjectController(){
        Assert.assertNull(wetTurtle.getActorController());
    }

    /**
     * Tests that the WetTurtle object has a
     * parent when it is added to the stage.
     *
     * Tests that the parent is the MyStage world
     * that the WetTurtle is added to.
     */
    @Test
    public void testWetTurtleParentWhenAddedToStage(){
        Assert.assertNull(wetTurtle.getParent());
        MyStage myStage = new MyStage();
        myStage.add(wetTurtle);
        Assert.assertNotNull(wetTurtle.getParent());
        Assert.assertEquals(myStage,wetTurtle.getParent());
    }

    //Image tests

    /**
     * Tests the WetTurtle object's main image at
     * instantiation is smooth and has
     * a preserved ratio.
     */
    @Test
    public void testMainImageSmoothnessAndRatio(){
        Assert.assertTrue(wetTurtle.getImage().isPreserveRatio());
        Assert.assertTrue(wetTurtle.getImage().isSmooth());
    }

    /**
     * Tests that the width and height of the main
     * image of the WetTurtle object are correctly set.
     */
    @Test
    public void testMainImageWidthAndHeight(){
        //initial w=130
        //initial h=130

        assertEquals(130,wetTurtle.getImage().getRequestedWidth(),0.0001);
        assertEquals(130,wetTurtle.getImage().getRequestedHeight(),0.0001);

        WetTurtle wetTurtle2 = new WetTurtle(-60,360,-3,20);
        assertEquals(20,wetTurtle2.getImage().getRequestedWidth(),0.0001);
        assertEquals(20,wetTurtle2.getImage().getRequestedHeight(),0.0001);


    }

    /**
     * Tests that the main image of the WetTurtle object
     * is correctly set.
     */
    @Test
    public void testMainImageIsSet(){
        Assert.assertNotNull(wetTurtle.getImage());
        Assert.assertFalse(wetTurtle.getImage().isError());
    }

    /**
     * Tests that the image changes at certain timeframes.
     */
    @Test
    public void testImageChange(){
//        if (now/900000000  % 4 ==0) {
//            setImage(turtle2);
//            sunk = false;
//        }
//        else if (now/900000000 % 4 == 1) {
//            setImage(turtle1);
//            sunk = false;
//        }
//        else if (now/900000000 %4 == 2) {
//            setImage(turtle3);
//            sunk = false;
//        } else if (now/900000000 %4 == 3) {
//            setImage(turtle4);
//            sunk = true;
//        }

        wetTurtle.act(3600000000L);
        assertEquals("file:src/p4_group_8_repo/images/TurtleAnimation2Wet.png", wetTurtle.getImage().getUrl());
        wetTurtle.act(4500000000L);
        assertEquals("file:src/p4_group_8_repo/images/TurtleAnimation1.png", wetTurtle.getImage().getUrl());
        wetTurtle.act(5400000000L);
        assertEquals("file:src/p4_group_8_repo/images/TurtleAnimation3Wet.png", wetTurtle.getImage().getUrl());
        wetTurtle.act(6300000000L);
        assertEquals("file:src/p4_group_8_repo/images/TurtleAnimation4Wet.png", wetTurtle.getImage().getUrl());


    }

    /**
     * Tests that the WetTurtle object is initially not sunk.</br>
     * Then tests that it has sunk at a certain timeframe.
     */
    @Test
    public void testIfIsSunk(){
        assertFalse(wetTurtle.isSunk());
        WetTurtle wetTurtle1 = new WetTurtle(360,670,3,30);
        wetTurtle1.act(6300000000L);
        assertTrue(wetTurtle1.isSunk());
    }

    /**
     * Tests the adding of WetTurtle objects to the stage.
     */
    @Test
    public void testWetTurtleAdding(){
//        for (int j : new int[]{500, 300}) {
//            background.add(new Turtle(j, turtleY, -1, 130, 130));
//        }

        ArrayList<WetTurtle> wetTurtleArrayList = new ArrayList<>();
        for (int j : new int[]{500, 300}) {
            wetTurtleArrayList.add(new WetTurtle(j, 300, -1, 130));
        }

        MyStage stage = new MyStage();
        for (int j : new int[]{500, 300}) {
            stage.add(new WetTurtle(j, 300, -1, 130));
        }

        assertEquals(wetTurtleArrayList.size(), stage.getChildren().size());
        assertNotNull(stage.getChildren());
        assertNotNull(stage.getObjects(WetTurtle.class));
    }

}