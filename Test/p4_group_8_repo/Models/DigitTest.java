package p4_group_8_repo.Models;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.MyStage;

public class DigitTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    private Digit digit;

    @Before
    public void setUp() {
        digit = new Digit(5,30,360,370);
    }

    @Test
    public void testXPosition(){
        Assert.assertEquals(360, digit.getX(),0.0001);
    }

    @Test
    public void testYPosition(){
        Assert.assertEquals(370, digit.getY(), 0.0001);
    }

    @Test
    public void testNegativeYPosition(){
        digit.setY(-370);
        Assert.assertEquals(-370, digit.getY(), 0.0001);
    }

    @Test
    public void testNegativeXPosition(){
        digit.setX(-360);
        Assert.assertEquals(-360, digit.getX(), 0.0001);
    }

    @Test
    public void testImageWidthAndHeight(){
        Assert.assertEquals(digit.getImage().getHeight(),digit.getImage().getWidth(), 0.0001);
    }

    @Test
    public void testImageIsSet(){
        Assert.assertNotNull(digit.getImage());
        Assert.assertFalse(digit.getImage().isError());
    }

    @Test
    public void testImageURLChange(){
        for (int i=0;i<10;i++) {
            digit = new Digit(i,30,30,360);
            Assert.assertEquals("file:src/p4_group_8_repo/images/"+i+".png", digit.getImage().getUrl());
        }
    }

    @Test
    public void testGettingObjectController(){
        Assert.assertNull(digit.getObjectController());
    }

    @Test
    public void testDigitParent(){
        Assert.assertNull(digit.getParent());
        MyStage myStage = new MyStage();
        myStage.add(digit);
        Assert.assertNotNull(digit.getParent());
        Assert.assertEquals(myStage,digit.getParent());
    }

    @Test
    public void testImageSmoothnessAndRatio(){
        Assert.assertTrue(digit.getImage().isPreserveRatio());
        Assert.assertTrue(digit.getImage().isSmooth());
    }



}