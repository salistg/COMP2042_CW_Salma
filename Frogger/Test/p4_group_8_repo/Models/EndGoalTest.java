package p4_group_8_repo.Models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.Views.MyStage;

/**
 * Test for the EndGoal class.
 */
public class EndGoalTest {
    /**
     * JavaFX rule to allow for testing on JavaFX applications
     */
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    /**
     * EndGoal object for testing
     */
    private EndGoal endGoal;

    /**
     * Set up before every test.
     * Instantiates the EndGoal object.
     */
    @Before
    public void setUp() {
        endGoal = new EndGoal(200,600);
    }

    /**
     * Test that the EndGoal object is at the correct X
     * position after instantiation.
     */
    @Test
    public void testXPosition(){
        Assert.assertEquals(200, endGoal.getX(),0.0001);
        endGoal.setX(100);
        Assert.assertEquals(100, endGoal.getX(), 0.0001);
    }

    /**
     * Test that the EndGoal object is at the correct Y
     * position after instantiation.
     */
    @Test
    public void testYPosition(){
        Assert.assertEquals(600, endGoal.getY(), 0.0001);
        endGoal.setY(350);
        Assert.assertEquals(350, endGoal.getY(), 0.0001);
    }

    /**
     * Tests that the Y position can be set to negative.
     */
    @Test
    public void testNegativeYPosition(){
        endGoal.setY(-370);
        Assert.assertEquals(-370, endGoal.getY(), 0.0001);
    }

    /**
     * Tests that the X position can be set to negative.
     */
    @Test
    public void testNegativeXPosition(){
        endGoal.setX(-360);
        Assert.assertEquals(-360, endGoal.getX(), 0.0001);
    }

    /**
     * Test the EndGoal objects' image width and height
     * is set correctly at instantiation.
     */
    @Test
    public void testImageWidthAndHeight(){
        Assert.assertEquals(endGoal.getImage().getHeight(), endGoal.getImage().getWidth(), 0.0001);
    }

    /**
     * Tests that the image of the EndGoal object
     * is correctly set.
     */
    @Test
    public void testImageIsSet(){
        Assert.assertNotNull(endGoal.getImage());
        Assert.assertFalse(endGoal.getImage().isError());
        Assert.assertEquals("file:src/p4_group_8_repo/images/End.png", endGoal.getImage().getUrl());
    }


    /**
     * Tests the getObjectController method
     * to ensure that the method returns null as EndGoal does not have a controller.
     */
    @Test
    public void testGettingObjectController() {
        Assert.assertNull(endGoal.getActorController());
    }

    /**
     * Tests that the EndGoal object has a
     * parent when it is added to the stage.
     *
     * Tests that the parent is the MyStage world
     * that the Animal is added to.
     */
    @Test
    public void testEndGoalParentWhenAddedToStage(){
        Assert.assertNull(endGoal.getParent());
        MyStage myStage = new MyStage();
        myStage.add(endGoal);
        Assert.assertNotNull(endGoal.getParent());
        Assert.assertEquals(myStage, endGoal.getParent());
    }

    /**
     * Tests the EndGoal object's image at
     * instantiation is smooth and has
     * a preserved ratio.
     */
    @Test
    public void testImageSmoothnessAndRatio(){
        Assert.assertTrue(endGoal.getImage().isPreserveRatio());
        Assert.assertTrue(endGoal.getImage().isSmooth());
    }

    /**
     * Tests that the isActivated field is set to true when he setEnd method is called.
     */
    @Test
    public void testIsActivated() {
        endGoal.setEnd();
        Assert.assertTrue(endGoal.isActivated());
    }

    /**
     * Tests that the EndGoal object is not initially activated at the start of the game.
     */
    @Test
    public void testIsNotActivatedInitially(){
        Assert.assertFalse(endGoal.isActivated());
    }

    /**
     * Tests that the image of the EndGoal object changes when
     * the setEnd method is called.
     */
    @Test
    public void testImageChange(){
        Assert.assertEquals("file:src/p4_group_8_repo/images/End.png", endGoal.getImage().getUrl());
        endGoal.setEnd();
        Assert.assertEquals("file:src/p4_group_8_repo/images/FrogEnd.png", endGoal.getImage().getUrl());
    }


}