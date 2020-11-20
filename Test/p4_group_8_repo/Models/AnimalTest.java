package p4_group_8_repo.Models;

import javafx.scene.image.Image;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.Controllers.AnimalController;
import p4_group_8_repo.Controllers.Controllers;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.Views.MyStage;

import static org.junit.Assert.*;

public class AnimalTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    private Animal animal;

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void testXPosition(){
        Assert.assertEquals(300, animal.getX(),0.0001);
    }

    @Test
    public void testYPosition(){
        Assert.assertEquals((679.8 + (13.3333333 * 2)), animal.getY(), 0.0001);
    }

    @Test
    public void testNegativeYPosition(){
        animal.setY(-370);
        Assert.assertEquals(-370, animal.getY(), 0.0001);
    }

    @Test
    public void testNegativeXPosition(){
        animal.setX(-360);
        Assert.assertEquals(-360, animal.getX(), 0.0001);
    }

    @Test
    public void testGettingObjectController(){
        Assert.assertNotNull(animal.getObjectController());
        Controllers controllers = new AnimalController(animal);
        assertEquals(controllers.getClass(), animal.getObjectController().getClass());
    }

    @Test
    public void testAnimalParent(){
        Assert.assertNull(animal.getParent());
        MyStage myStage = new MyStage();
        myStage.add(animal);
        Assert.assertNotNull(animal.getParent());
        Assert.assertEquals(myStage,animal.getParent());
    }

    @Test
    public void testMainImageSmoothnessAndRatio(){
        Assert.assertTrue(animal.getImage().isPreserveRatio());
        Assert.assertTrue(animal.getImage().isSmooth());
    }

    @Test
    public void testMainImageWidthAndHeight(){
        //initial w=40
        //initial h=40

        assertEquals(40,animal.getImage().getRequestedWidth(),0.0001);
        assertEquals(40,animal.getImage().getRequestedHeight(),0.0001);

        animal.setImage(new Image("file:src/p4_group_8_repo/images/froggerUp.png",20,10,true,true));
        assertEquals(20,animal.getImage().getRequestedWidth(),0.0001);
        assertEquals(10,animal.getImage().getRequestedHeight(),0.0001);


    }

    @Test
    public void testMainImageIsSet(){
        Assert.assertNotNull(animal.getImage());
        Assert.assertFalse(animal.getImage().isError());
    }
}