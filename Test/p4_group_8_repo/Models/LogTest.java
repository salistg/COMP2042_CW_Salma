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

public class LogTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    private Log log;

    @Before
    public void setUp() {
        log = new Log("file:src/p4_group_8_repo/images/log3.png", 30,360,370,2);
    }

    @Test
    public void testXPosition(){
        Assert.assertEquals(360, log.getX(),0.0001);
    }

    @Test
    public void testYPosition(){
        Assert.assertEquals(370, log.getY(), 0.0001);
    }

    @Test
    public void testNegativeYPosition(){
        log.setY(-370);
        Assert.assertEquals(-370, log.getY(), 0.0001);
    }

    @Test
    public void testNegativeXPosition(){
        log.setX(-360);
        Assert.assertEquals(-360, log.getX(), 0.0001);
    }

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

    @Test
    public void testSettingOfX(){
//        if (getX()>600 && speed>0)
//            setX(-180);

        log.setX(700);
        log.act(10000);
        assertEquals(-180,log.getX(),0.0001);

    }

    @Test
    public void testSettingOfX2(){
//        if (getX()<-300 && speed<0)
//            setX(700);

        Log log2 = new Log("file:src/p4_group_8_repo/images/log3.png",30,-450,-450,-3);
        log2.act(10000);
        assertEquals(700,log2.getX(),0.0001);
    }

    @Test
    public void testGettingObjectController(){
        Assert.assertNull(log.getObjectController());
    }

    @Test
    public void testDigitParent(){
        Assert.assertNull(log.getParent());
        MyStage myStage = new MyStage();
        myStage.add(log);
        Assert.assertNotNull(log.getParent());
        Assert.assertEquals(myStage,log.getParent());
    }

    @Test
    public void testGetLeft() {
        assertFalse(log.getLeft());
        Log log2 = new Log("file:src/p4_group_8_repo/images/log3.png",30,-450,-450,-3);
        assertTrue(log2.getLeft());
    }

    //Image tests

    @Test
    public void testImageSmoothnessAndRatio(){
        Assert.assertTrue(log.getImage().isPreserveRatio());
        Assert.assertTrue(log.getImage().isSmooth());
    }

    @Test
    public void testImageWidthAndHeight(){
        Assert.assertEquals(log.getImage().getHeight(),log.getImage().getWidth(), 0.0001);
    }

    @Test
    public void testImageIsSet(){
        Assert.assertNotNull(log.getImage());
        Assert.assertFalse(log.getImage().isError());
    }

    @Test
    public void testImageChange(){
        assertEquals("file:src/p4_group_8_repo/images/log3.png", log.getImage().getUrl());
        log.setImage(new Image("file:src/p4_group_8_repo/images/logs.png"));
        assertEquals("file:src/p4_group_8_repo/images/logs.png", log.getImage().getUrl());
    }

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