package p4_group_8_repo.Models;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.Views.MyStage;

/**
 * Test for the Digit class.
 */
public class DigitTest {
    /**
     * JavaFX rule to allow for testing on JavaFX applications
     */
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    /**
     * Digit object for testing
     */
    private Digit digit;

    /**
     * Set up before every test.
     * Instantiates the Digit object.
     */
    @Before
    public void setUp() {
        digit = new Digit(5,30,360,370);
    }

    /**
     * Test that the Digit object is at the correct X
     * position after instantiation.
     */
    @Test
    public void testXPosition(){
        Assert.assertEquals(360, digit.getX(),0.0001);
    }

    /**
     * Test that the Digit object is at the correct Y
     * position after instantiation.
     */
    @Test
    public void testYPosition(){
        Assert.assertEquals(370, digit.getY(), 0.0001);
    }

    /**
     * Tests that the Y position can be set to negative.
     */
    @Test
    public void testNegativeYPosition(){
        digit.setY(-370);
        Assert.assertEquals(-370, digit.getY(), 0.0001);
    }

    /**
     * Tests that the X position can be set to negative.
     */
    @Test
    public void testNegativeXPosition(){
        digit.setX(-360);
        Assert.assertEquals(-360, digit.getX(), 0.0001);
    }

    /**
     * Test the Digit objects' image width and height
     * is set correctly at instantiation.
     */
    @Test
    public void testImageWidthAndHeight(){
        Assert.assertEquals(digit.getImage().getHeight(),digit.getImage().getWidth(), 0.0001);
    }

    /**
     * Tests that the image of the Digit object
     * is set.
     */
    @Test
    public void testImageIsSet(){
        Assert.assertNotNull(digit.getImage());
        Assert.assertFalse(digit.getImage().isError());
    }

    /**
     * Tests that the image of the Digit object
     * correctly changes as the value of the field 'n' changes. </br>
     * (The field n represents the number of the Digit and according to it, the image of the Digit object changes.)
     */
    @Test
    public void testImageChange(){
        for (int i=0;i<10;i++) {
            digit = new Digit(i,30,30,360);
            Assert.assertEquals("file:src/p4_group_8_repo/images/"+i+".png", digit.getImage().getUrl());
        }
    }

    /**
     * Tests the getObjectController method
     * to ensure that the method returns null as Digit does not have a controller.
     */
    @Test
    public void testGettingObjectController(){
        Assert.assertNull(digit.getActorController());
    }

    /**
     * Tests that the Digit object has a
     * parent when it is added to the stage.
     *
     * Tests that the parent is the MyStage world
     * that the Digit is added to.
     */
    @Test
    public void testDigitParentWhenAddedToStage(){
        Assert.assertNull(digit.getParent());
        MyStage myStage = new MyStage();
        myStage.add(digit);
        Assert.assertNotNull(digit.getParent());
        Assert.assertEquals(myStage,digit.getParent());
    }

    /**
     * Tests the Digit object's image at
     * instantiation is smooth and has
     * a preserved ratio.
     */
    @Test
    public void testImageSmoothnessAndRatio(){
        Assert.assertTrue(digit.getImage().isPreserveRatio());
        Assert.assertTrue(digit.getImage().isSmooth());
    }



}