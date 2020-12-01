package p4_group_8_repo.Models;

import javafx.scene.image.Image;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.Views.MyStage;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Test for the Log class.
 */
public class LogTest {
    /**
     * JavaFX rule to allow for testing on JavaFX applications
     */
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    /**
     * Creating a Log object for testing.
     */
    private Log log;

    /**
     * Set up before every test.</br>
     * Instantiates the Log object.
     */
    @Before
    public void setUp() {
        log = new Log("file:src/p4_group_8_repo/images/log3.png", 30,360,370,2);
    }

    /**
     * Test that the Log object is at the correct X
     * position after instantiation.
     */
    @Test
    public void testXPosition(){
        Assert.assertEquals(360, log.getX(),0.0001);
    }

    /**
     * Test that the Log object is at the correct Y
     * position after instantiation.
     */
    @Test
    public void testYPosition(){
        Assert.assertEquals(370, log.getY(), 0.0001);
    }

    /**
     * Tests that the Y position can be set to negative.
     */
    @Test
    public void testNegativeYPosition(){
        log.setY(-370);
        Assert.assertEquals(-370, log.getY(), 0.0001);
    }
    /**
     * Tests that the X position can be set to negative.
     */
    @Test
    public void testNegativeXPosition(){
        log.setX(-360);
        Assert.assertEquals(-360, log.getX(), 0.0001);
    }

    /**
     * Tests the movement of the Log object. </br>
     * Tests that the X and Y coordinates change when the move method is called.
     */
    @Test
    public void testMovement() {
        //current x=360
        //current y=370

        int speed = 2;
        log.move(speed,0);
        assertEquals(360+speed,log.getX(),0.0001);
        log.move(0,speed);
        assertEquals(370+speed,log.getY(),0.0001);
        log.move(speed,speed);
        assertEquals(360+speed+speed,log.getX(),0.0001);
        assertEquals(370+speed+speed,log.getY(),0.0001);
    }

    /**
     * Tests the setting of the X coordinate of the Log object
     * when the conditions in the act method are met. </br>
     *
     * Conditions tested: </br>
     * <pre>
     *     if (getX()>600 && speed>0)
     *            setX(-180);
     * </pre>
     */
    @Test
    public void testSettingOfX(){
//        if (getX()>600 && speed>0)
//            setX(-180);

        log.setX(700);
        log.act(10000);
        assertEquals(-180,log.getX(),0.0001);

    }

    /**
     * Tests the setting of the X coordinate of the Log object
     * when the conditions in the act method are met. </br>
     *
     * Conditions tested: </br>
     * <pre>
     *    if (getX()<-300 && speed<0)
     *            setX(700);
     * </pre>
     */
    @Test
    public void testSettingOfX2(){
//        if (getX()<-300 && speed<0)
//            setX(700);

        Log log2 = new Log("file:src/p4_group_8_repo/images/log3.png",30,-450,-450,-3);
        log2.act(10000);
        assertEquals(700,log2.getX(),0.0001);
    }

    /**
     * Tests the getObjectController method
     * to ensure that the method returns null as Log does not have a controller.
     */
    @Test
    public void testGettingObjectController(){
        Assert.assertNull(log.getActorController());
    }

    /**
     * Tests that the Log object has a
     * parent when it is added to the stage.
     *
     * Tests that the parent is the MyStage world
     * that the Log is added to.
     */
    @Test
    public void testDigitParentWhenAddedToStage(){
        Assert.assertNull(log.getParent());
        MyStage myStage = new MyStage();
        myStage.add(log);
        Assert.assertNotNull(log.getParent());
        Assert.assertEquals(myStage,log.getParent());
    }

    /**
     * Tests that the getLeft method returns true when the speed
     * of the Log object is negative and that it returns false initially.
     */
    @Test
    public void testGetLeft() {
        assertFalse(log.getLeft());
        Log log2 = new Log("file:src/p4_group_8_repo/images/log3.png",30,-450,-450,-3);
        assertTrue(log2.getLeft());
    }

    //Image tests

    /**
     * Tests the Log object's image at
     * instantiation is smooth and has
     * a preserved ratio.
     */
    @Test
    public void testImageSmoothnessAndRatio(){
        Assert.assertTrue(log.getImage().isPreserveRatio());
        Assert.assertTrue(log.getImage().isSmooth());
    }

    /**
     * Tests that the main image of the Log object
     * is correctly set.
     */
    @Test
    public void testImageIsSet(){
        Assert.assertNotNull(log.getImage());
        Assert.assertFalse(log.getImage().isError());
    }

    /**
     * Tests that the Log object image changes when an image is set.
     */
    @Test
    public void testImageChange(){
        assertEquals("file:src/p4_group_8_repo/images/log3.png", log.getImage().getUrl());
        log.setImage(new Image("file:src/p4_group_8_repo/images/logs.png"));
        assertEquals("file:src/p4_group_8_repo/images/logs.png", log.getImage().getUrl());
    }

    /**
     * Tests adding the Log object to the stage.
     */
    @Test
    public void testLogAdding(){
//        for (int k : new int[]{0, 220, 645}) {
//            background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, k, log3Y, 0.75));
//        }

        ArrayList<Log> logArrayList = new ArrayList<>();
        for (int k : new int[]{0, 220, 645}) {
            logArrayList.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, k, 360, 0.75));
        }

        MyStage stage = new MyStage();
        for (int k : new int[]{0, 220, 645}) {
           stage.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, k, 360, 0.75));
        }

        assertEquals(logArrayList.size(), stage.getChildren().size());
        assertNotNull(stage.getChildren());
        assertNotNull(stage.getObjects(Log.class));
    }
}