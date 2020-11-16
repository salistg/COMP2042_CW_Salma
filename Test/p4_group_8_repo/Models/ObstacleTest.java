package p4_group_8_repo.Models;

import javafx.scene.image.Image;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.MyStage;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ObstacleTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    private Obstacle obstacle;

    @Before
    public void setUp() {
        obstacle = new Obstacle("file:src/p4_group_8_repo/images/car1Left.png",360,360,2,30);
    }

    @Test
    public void testXPosition(){
        Assert.assertEquals(360, obstacle.getX(),0.0001);
    }

    @Test
    public void testYPosition(){
        Assert.assertEquals(360, obstacle.getY(), 0.0001);
    }

    @Test
    public void testNegativeYPosition(){
        obstacle.setY(-370);
        Assert.assertEquals(-370, obstacle.getY(), 0.0001);
    }

    @Test
    public void testNegativeXPosition(){
        obstacle.setX(-360);
        Assert.assertEquals(-360, obstacle.getX(), 0.0001);
    }

    @Test
    public void testMovement() {
        //current x=360
        //current y=360

        int speed = 2;
        obstacle.move(speed,0);
        assertEquals(360+speed,obstacle.getX(),0.0001);
        obstacle.move(0,speed);
        assertEquals(360+speed,obstacle.getY(),0.0001);
        obstacle.move(speed,speed);
        assertEquals(360+speed+speed,obstacle.getX(),0.0001);
        assertEquals(360+speed+speed,obstacle.getY(),0.0001);
    }

    @Test
    public void testSettingOfX(){
//        if (getX() > 600 && speed>0)
//            setX(-200);

        obstacle.setX(800);
        obstacle.act(10000);
        assertEquals(-200,obstacle.getX(),0.0001);

    }

    @Test
    public void testSettingOfX2(){
//        if (getX() < -50 && speed<0)
//            setX(600);

        Obstacle obstacle2 = new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", -60,360,-3,30);
        obstacle2.act(10000);
        assertEquals(600,obstacle2.getX(),0.0001);
    }

    @Test
    public void testGettingObjectController(){
        Assert.assertNull(obstacle.getObjectController());
    }

    @Test
    public void testObstacleParent(){
        Assert.assertNull(obstacle.getParent());
        MyStage myStage = new MyStage();
        myStage.add(obstacle);
        Assert.assertNotNull(obstacle.getParent());
        Assert.assertEquals(myStage,obstacle.getParent());
    }


    //Image tests

    @Test
    public void testImageSmoothnessAndRatio(){
        Assert.assertTrue(obstacle.getImage().isPreserveRatio());
        Assert.assertTrue(obstacle.getImage().isSmooth());
    }

    @Test
    public void testImageWidthAndHeight(){
        //initial w=30
        //initial h=40

        assertEquals(30,obstacle.getImage().getRequestedWidth(),0.0001);
        assertEquals(40,obstacle.getImage().getRequestedHeight(),0.0001);

        Obstacle obstacle2 = new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", -60,360,-3,20);
        assertEquals(20,obstacle2.getImage().getRequestedWidth(),0.0001);
        assertEquals(10,obstacle2.getImage().getRequestedHeight(),0.0001);


    }

    @Test
    public void testImageIsSet(){
        Assert.assertNotNull(obstacle.getImage());
        Assert.assertFalse(obstacle.getImage().isError());
    }

    @Test
    public void testImageChange(){
        assertEquals("file:src/p4_group_8_repo/images/car1Left.png", obstacle.getImage().getUrl());
        obstacle.setImage(new Image("file:src/p4_group_8_repo/images/truck2Right.png"));
        assertEquals("file:src/p4_group_8_repo/images/truck2Right.png", obstacle.getImage().getUrl());
    }

    @Test
    public void testObstacleAdding(){

        ArrayList<Obstacle> obstacleArrayList = new ArrayList<>();
        for (int i = 0; i <= 600; i += 300) {
            obstacleArrayList.add(new Obstacle("file:src/p4_group_8_repo/images/truck1Right.png", i, 649, 2, 120));
        }

        MyStage stage = new MyStage();
        for (int i = 0; i <= 600; i += 300) {
            stage.add(new Obstacle("file:src/p4_group_8_repo/images/truck1Right.png", i, 649, 2, 120));
        }

        assertEquals(obstacleArrayList.size(), stage.getChildren().size());
        assertNotNull(stage.getChildren());
        assertNotNull(stage.getObjects(Obstacle.class));
    }


}