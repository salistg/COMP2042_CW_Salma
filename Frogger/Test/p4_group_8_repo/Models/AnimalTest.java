package p4_group_8_repo.Models;

import javafx.scene.image.Image;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.Controllers.AnimalController;
import p4_group_8_repo.Controllers.ActorControllers;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.Views.MyStage;

import static org.junit.Assert.*;

/**
 * Test for the Animal class.
 */
public class AnimalTest {
    /**
     * JavaFX rule to allow for testing on JavaFX applications
     */
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    /**
     * Animal object for testing
     */
    private Animal animal;

    /**
     * Set up before every test.
     * Instantiates the Animal object.
     */
    @Before
    public void setUp() {
        animal = new Animal();
    }

    /**
     * Test that the Animal object is at the correct X
     * position after instantiation.
     */
    @Test
    public void testXPosition(){
        Assert.assertEquals(300, animal.getX(),0.0001);
    }

    /**
     * Test that the Animal object is at the correct Y
     * position after instantiation.
     */
    @Test
    public void testYPosition(){
        Assert.assertEquals((679.8 + (13.3333333 * 2)), animal.getY(), 0.0001);
    }

    /**
     * Tests that the Y position can be set to negative.
     */
    @Test
    public void testNegativeYPosition(){
        animal.setY(-370);
        Assert.assertEquals(-370, animal.getY(), 0.0001);
    }

    /**
     * Tests that the X position can be set to negative.
     */
    @Test
    public void testNegativeXPosition(){
        animal.setX(-360);
        Assert.assertEquals(-360, animal.getX(), 0.0001);
    }

    /**
     * Tests the getObjectController method
     * to ensure tha the correct controller is returned.
     */
    @Test
    public void testGettingActorController(){
        Assert.assertNotNull(animal.getActorController());
        ActorControllers actorControllers = new AnimalController(animal);
        assertEquals(actorControllers.getClass(), animal.getActorController().getClass());
    }

    /**
     * Tests that the Animal object has a
     * parent when it is added to the stage.
     *
     * Tests that the parent is the MyStage world
     * that the Animal is added to.
     */
    @Test
    public void testAnimalParentWhenAddedToStage(){
        Assert.assertNull(animal.getParent());
        MyStage myStage = new MyStage();
        myStage.add(animal);
        Assert.assertNotNull(animal.getParent());
        Assert.assertEquals(myStage,animal.getParent());
    }

    /**
     * Tests the Animals' main image at
     * instantiation is smooth and has
     * a preserved ratio.
     */
    @Test
    public void testMainImageSmoothnessAndRatio(){
        Assert.assertTrue(animal.getImage().isPreserveRatio());
        Assert.assertTrue(animal.getImage().isSmooth());
    }

    /**
     * Test the Animal objects' main image width and height
     * is set correctly at instantiation.
     */
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

    /**
     * Tests that the main image of the Animal object
     * is set.
     */
    @Test
    public void testMainImageIsSet(){
        Assert.assertNotNull(animal.getImage());
        Assert.assertFalse(animal.getImage().isError());
    }
}