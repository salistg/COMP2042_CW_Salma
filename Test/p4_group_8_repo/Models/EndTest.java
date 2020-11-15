package p4_group_8_repo.Models;

import javafx.scene.image.Image;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.MyStage;


public class EndTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    private End end;

    @Before
    public void setUp() {
        end = new End(200,600);
    }

    @Test
    public void testXPosition(){
        Assert.assertEquals(200, end.getX(),0.0001);
        end.setX(100);
        Assert.assertEquals(100,end.getX(), 0.0001);
    }

    @Test
    public void testYPosition(){
        Assert.assertEquals(600, end.getY(), 0.0001);
        end.setY(350);
        Assert.assertEquals(350, end.getY(), 0.0001);
    }

    @Test
    public void testNegativeYPosition(){
        end.setY(-370);
        Assert.assertEquals(-370, end.getY(), 0.0001);
    }

    @Test
    public void testNegativeXPosition(){
        end.setX(-360);
        Assert.assertEquals(-360, end.getX(), 0.0001);
    }

    @Test
    public void testImageWidthAndHeight(){
        Assert.assertEquals(end.getImage().getHeight(),end.getImage().getWidth(), 0.0001);
    }

    @Test
    public void testImageIsSet(){
        Assert.assertNotNull(end.getImage());
        Assert.assertFalse(end.getImage().isError());
    }


    @Test
    public void testGettingObjectController() {
        Assert.assertNull(end.getObjectController());
    }

    @Test
    public void testDigitParent(){
        Assert.assertNull(end.getParent());
        MyStage myStage = new MyStage();
        myStage.add(end);
        Assert.assertNotNull(end.getParent());
        Assert.assertEquals(myStage,end.getParent());
    }

    @Test
    public void testSetEndImage() {
        end.setImage(new Image("file:src/p4_group_8_repo/images/FrogEnd.png", 70, 70, true, true));
        Assert.assertNotNull(end.getImage());
        Assert.assertFalse(end.getImage().isError());
        // Assert.assertEquals(end.getImage().getHeight(),end.getImage().getWidth(),0.0001);
        Assert.assertTrue(end.getImage().isSmooth());
        Assert.assertTrue(end.getImage().isPreserveRatio());
        Assert.assertEquals("file:src/p4_group_8_repo/images/FrogEnd.png", end.getImage().getUrl());
    }

    @Test
    public void testIsActivated() {
        end.setEnd();
        Assert.assertTrue(end.isActivated());
    }

    @Test
    public void testIsNotActivated(){
        Assert.assertFalse(end.isActivated());
    }

    @Test
    public void testImageChange(){
        Assert.assertEquals("file:src/p4_group_8_repo/images/End.png", end.getImage().getUrl());
        end.setEnd();
        Assert.assertEquals("file:src/p4_group_8_repo/images/FrogEnd.png",end.getImage().getUrl());
    }


}