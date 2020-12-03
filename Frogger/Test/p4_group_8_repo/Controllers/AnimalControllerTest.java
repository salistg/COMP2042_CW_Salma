package p4_group_8_repo.Controllers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.Models.*;
import p4_group_8_repo.Views.MyStage;

import static org.junit.Assert.*;

/**
 * Test for the AnimalController class.
 *
 */
public class AnimalControllerTest {
    /**
     * Rule to allow for testing on JavaFx applications.
     */
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    /**
     * Creating an AnimalController object.
     */
    private AnimalController animalController;
    /**
     * Variable for the movement of the Animal object.
     */
    private final double movement = 13.3333333 * 2;

    /**
     * Setting up before every test.</br>
     * Instantiates a new AnimalController object.
     */
    @Before
    public void setUp() {
        animalController = new AnimalController(new Animal());
    }

    /**
     * Tests that the Animal object belonging to the controller
     * is correctly added to the stage.
     */
    @Test
    public void testAddingAnimalToStage(){
        MyStage myStage = new MyStage();  //creating a new MyStage object
        myStage.add(animalController.getActor());  //adding the animal object to the stage
        assertNotNull(myStage.getChildren()); //checking that the stage has a child
        assertEquals(myStage.getChildren().get(0), animalController.getActor()); //ensuring that this child is
        // the animal object just added
    }

    /**
     * Tests the GetActor() method
     * to ensure that the Actor returned by the method
     * is an Animal object.
     */
    @Test
    public void testGettingActorIsOfTypeAnimal(){
        Animal animal = new Animal(); //creating a new animal object
        assertEquals(animal.getClass(), animalController.getActor().getClass()); //ensuring
        //that the class of the actor is Animal
    }

    /**
     * Tests the correct setting of the X and Y coordinates
     * of the Animal object according to the conditions
     * in the mainControl method of the AnimalController class.
     *
     * Conditions tested:
     * <pre>
     *      if (animal.getY() < 0 || animal.getY() > 734) {
     *             animal.setX(300);
     *             animal.setY(679.8 + movementY);
     *         }
     * </pre>
     */
    @Test
    public void testAnimalSettingXAndY(){
//        movement = 13.3333333 * 2
//        if (animal.getY() < 0 || animal.getY() > 734) {
//            animal.setX(300);
//            animal.setY(679.8 + movement);
//        }
        double movement = 13.3333333 * 2; //variable for the movement

        MyStage myStage = new MyStage(); //creating a new MyStage
        myStage.getChildren().add(animalController.getActor()); //adding the actor to the stage

        //testing animal.getY() <0
        animalController.getActor().setY(-40); //setting the animal's Y coordinate to meet the condition
        animalController.mainControl(900000000L); //calling the main control method to test it
        assertEquals(300, animalController.getActor().getX(),0.0001); //tests that the X coordinates have changed
        assertEquals((679.8 + movement), animalController.getActor().getY(), 0.0001); //tests that the Y coordinates have changed

        //testing animal.getY()>734
        //same steps followed as for the first condition
        animalController.getActor().setY(800);
        animalController.mainControl(900000000L);
        assertEquals(300, animalController.getActor().getX(),0.0001);
        assertEquals((679.8 + movement), animalController.getActor().getY(), 0.0001);
    }

    /**
     * Tests that the animal moves correctly according
     * to the conditions in the mainControl() method of the
     * AnimalController class. Tests that the X and Y coordinates
     * has changed when the move method is called.
     *
     * Condition tested:
     * <pre>
     *      if (animal.getX() < 0) {
     *             animal.move(movementY * 2, 0);
     *         }
     * </pre>
     */
    @Test
    public void testAnimalMovement1(){
        // current x = 300
        //current y = 679.8 + (13.3333333 * 2);
//        if (animal.getX() < 0) {
//            animal.move(movement * 2, 0);
//        }

        MyStage myStage = new MyStage(); //creating a new MyStage object
        myStage.getChildren().add(animalController.getActor()); //adding the animal to it

        animalController.getActor().setX(-40); //setting the animal's X position to meet the condition
        animalController.mainControl(900000000L); //calling the main control method for testing
        assertEquals((-40)+(movement*2), animalController.getActor().getX(),0.0001); //ensuring the X coordinate has changed
        assertEquals((679.8 + movement), animalController.getActor().getY(), 0.0001); //ensuring the Y coordinate has changed
    }

    /**
     * Tests that the animal moves correctly according
     * to the conditions in the mainControl() method of the
     * AnimalController class. Tests that the X and Y coordinates
     * has changed when the move method is called.
     *
     * Condition tested:
     * <pre>
     *       if (animal.getX() > 600) {
     *             animal.move(-movementY * 2, 0);
     *         }
     * </pre>
     */
    @Test
    public void testAnimalMovement2(){
//        if (animal.getX() > 600) {
//            animal.move(-movement * 2, 0);
//        }

        MyStage myStage = new MyStage(); //creating a new MyStage object
        myStage.getChildren().add(animalController.getActor()); //adding the animal to it

        animalController.getActor().setX(800); //setting the animal's X coordinate to meet the condition
        animalController.mainControl(900000000L); //calling the mainControl method to test it
        assertEquals((800)+(-movement*2), animalController.getActor().getX(),0.0001); //ensuring the X position has changed
        assertEquals((679.8 + movement), animalController.getActor().getY(), 0.0001); //ensuring the Y position has changed
    }

    //start of object intersection tests

    /**
     * Test to ensure that the
     * intersection between the Animal object and
     * EndGoal objects is correctly picked up
     * and causes the corresponding actions set in the
     * atIntersection() method.
     *
     * Tests that X and Y positions of the Animal object
     * have changed.
     */
    @Test
    public void testAnimalIntersectionWithEndObject(){
//        else if (animal.getIntersectingObjects(End.class).size() >= 1) {
//            if (animal.getIntersectingObjects(End.class).get(0).isActivated()) {
//                end--;
//                points -= 50;
//            }
//            points += 50;
//            changeScore = true;
//            w = 800;
//            animal.getIntersectingObjects(End.class).get(0).setEnd();
//            end++;
//            animal.setX(300);
//            animal.setY(679.8 + movement);

        MyStage stage = new MyStage(); //creating a new MyStage object
        EndGoal endGoal = new EndGoal(30,40); //creating a new EndGoal object
        //setting the Animal's X and Y positions so it intersects the EndGoal object
        animalController.getActor().setY(40);
        animalController.getActor().setX(30);
        //adding both objects to the stage
        stage.add(endGoal);
        stage.add(animalController.getActor());
        //first check if they intersect
        assertNotNull(animalController.getActor().getIntersectingObjects(EndGoal.class));
        //then call the atIntersection() method through the mainControl method
        animalController.mainControl(6300000000L);
        //points change is detected in the testPointsGetter() test
        //check that the X and Y positions have been set
        assertEquals(300,animalController.getActor().getX(), 0.0001);
        assertEquals(679.8+movement, animalController.getActor().getY(),0.0001);
    }

    /**
     * Test to ensure that the
     * intersection between the Animal object and
     * Log objects is correctly picked up
     * and causes the corresponding actions set in the
     * atIntersection() method.
     *
     * Tests that X and Y positions of the Animal object
     * have changed.
     */
    @Test
    public void testAnimalIntersectionWithLogObjects(){
//        else if (animal.getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
//            if (animal.getIntersectingObjects(Log.class).get(0).getLeft())
//                animal.move(-2, 0);
//            else
//                animal.move(.75, 0);

        MyStage stage = new MyStage(); //creating a new MyStage object
        Log log = new Log("file:src/p4_group_8_repo/images/log3.png",80,30,40,2); //creating a new Log object
        //setting the Anima object's X and Y coordinates so the objects intersect
        animalController.getActor().setY(40);
        animalController.getActor().setX(30);
        //adding the objects to the stage
        stage.add(log);
        stage.add(animalController.getActor());
        //first check if they intersect
        assertNotNull(animalController.getActor().getIntersectingObjects(Log.class));
        //then call the atIntersection() method via the mainControl method
        animalController.mainControl(6300000000L);
        //check that the X and Y positions have been changed
        assertEquals(30+.75,animalController.getActor().getX(), 0.0001);
        assertEquals(40, animalController.getActor().getY(),0.0001);
    }

    /**
     * Test to ensure that the
     * intersection between the Animal object and
     * Log objects moving to the left is correctly picked up
     * and causes the corresponding actions set in the
     * atIntersection() method.
     *
     * Tests that X and Y positions of the Animal object
     * have changed.
     */
    @Test
    public void testAnimalIntersectionWithLeftLogObjects(){
//        else if (animal.getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
//            if (animal.getIntersectingObjects(Log.class).get(0).getLeft())
//                animal.move(-2, 0);
//            else
//                animal.move(.75, 0);

        MyStage stage = new MyStage(); //creating a new MyStage object
        Log log = new Log("file:src/p4_group_8_repo/images/log3.png",80,30,40,-2); //creating a new Log object
        //setting the animal object's X and Y position so they intersect
        animalController.getActor().setY(40);
        animalController.getActor().setX(30);
        //adding both objects to the stage
        stage.add(log);
        stage.add(animalController.getActor());
        //first check if they intersect
        assertNotNull(animalController.getActor().getIntersectingObjects(Log.class));
        //then call the atIntersection() method via the mainControl method
        animalController.mainControl(6300000000L);
        //check that the X and Y positions have been changed
        assertEquals(30+(-2),animalController.getActor().getX(), 0.0001);
        assertEquals(40, animalController.getActor().getY(),0.0001);
    }

    /**
     * Test to ensure that the
     * intersection between the Animal object and
     * Obstacle is correctly picked up
     * and causes the corresponding actions set in the
     * atIntersection() method.
     *
     * Tests that carDeath variable has been set to true.
     */
    @Test
    public void testAnimalIntersectionWithObstacleObjects(){
//        if (animal.getIntersectingObjects(Obstacle.class).size() >= 1) {
//                carDeath = true;

        MyStage stage = new MyStage(); //creating a new MyStage object
        Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/images/car1Left.png",30,40,2,90); //creating a new Obstacle object
        //setting the X and Y positions of the Anima object so they intersect
        animalController.getActor().setY(40);
        animalController.getActor().setX(30);
        //adding both objects to the stage
        stage.add(obstacle);
        stage.add(animalController.getActor());
        //first check if they intersect
        assertNotNull(animalController.getActor().getIntersectingObjects(Obstacle.class));
        //then call the atIntersection() method via the mainControl method
        animalController.mainControl(6300000000L);
        //check if carDeath has been set to true
        assertTrue(animalController.getCarDeath());

    }

    /**
     * Test to ensure that the
     * intersection between the Animal object and
     * Turtle is correctly picked up
     * and causes the corresponding actions set in the
     * atIntersection() method.
     *
     * Tests that X and Y positions of the Animal object
     * have changed.
     */
    @Test
    public void testAnimalIntersectionWithTurtleObjects(){
//         else if (animal.getIntersectingObjects(Turtle.class).size() >= 1 && !getMove()) {
//            animal.move(-1, 0);
//        }

        MyStage stage = new MyStage(); //creating a new MyStage object
        Turtle turtle = new Turtle(30,40,2,60); //creating a new Turtle object
        //setting the X and Y coordinates of the Animal object so they intersect
        animalController.getActor().setY(40);
        animalController.getActor().setX(30);
        //adding both objects to the stage
        stage.add(turtle);
        stage.add(animalController.getActor());
        //first check if they intersect
        assertNotNull(animalController.getActor().getIntersectingObjects(Turtle.class));
        //then call the atIntersection() method via the mainControl method
        animalController.mainControl(6300000000L);
        //check that the X and Y positions have been changed
        assertEquals(30+(-1),animalController.getActor().getX(), 0.0001);
        assertEquals(40, animalController.getActor().getY(),0.0001);
    }

    /**
     * Test to ensure that the
     * intersection between the Animal object and
     * WetTurtle (not sunk) is correctly picked up
     * and causes the corresponding actions set in the
     * atIntersection() method.
     *
     * Tests that X and Y positions of the Animal object
     * have changed.
     */
    @Test
    public void testAnimalIntersectionWithWetTurtleObjectsNotSunk(){
//        else if (animal.getIntersectingObjects(WetTurtle.class).size() >= 1) {
//            if (animal.getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
//                waterDeath = true;
//            } else {
//                animal.move(-1, 0);
//            }

        MyStage stage = new MyStage(); //creating a new MyStage object
        WetTurtle wetTurtle = new WetTurtle(30,40,2,60); //creating a new WetTurtle object
        //setting the X and Y coordinates of the Animal object to ensure they intersect
        animalController.getActor().setY(40);
        animalController.getActor().setX(30);
        //adding both objects to the stage
        stage.add(wetTurtle);
        stage.add(animalController.getActor());
        //first check if they intersect
        assertNotNull(animalController.getActor().getIntersectingObjects(WetTurtle.class));
        //then call the atIntersection() method via the mainControl method
        animalController.mainControl(6300000000L);
        //check that the X and Y positions have been changed
        assertEquals(30+(-1),animalController.getActor().getX(), 0.0001);
        assertEquals(40, animalController.getActor().getY(),0.0001);

    }

    /**
     * Test to ensure that the
     * intersection between the Animal object and
     * WetTurtle (sunk) is correctly picked up
     * and causes the corresponding actions set in the
     * atIntersection() method.
     *
     * Tests that X and Y positions of the Animal object
     * have changed.
     */
    @Test
    public void testAnimalIntersectionWithWetTurtleObjectsSunk(){
//      else if (animal.getIntersectingObjects(WetTurtle.class).size() >= 1) {
//            if (animal.getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
//                waterDeath = true;
//            } else {
//                animal.move(-1, 0);
//            }

        MyStage stage = new MyStage(); //creating a new MyStage object
        WetTurtle wetTurtle = new WetTurtle(30,40,2,60); //creating a new WetTurtle object
        //call act method so isSunk returns true
        wetTurtle.act(6300000000L);
        //check that it is sunk
        assertTrue(wetTurtle.isSunk());
        //set x and y positions so the objects intersect
        animalController.getActor().setY(40);
        animalController.getActor().setX(30);
        //add objects to the same stage
        stage.add(wetTurtle);
        stage.add(animalController.getActor());
        //first check if they intersect
        assertNotNull(animalController.getActor().getIntersectingObjects(WetTurtle.class));
        //then call the mainControl() method that uses the atIntersection() method
        animalController.mainControl(6300000000L);
        //check that the waterDeath has been set to true
        assertTrue(animalController.getWaterDeath());
    }

    //end of intersection tests

    /**
     * Tests that the changeScore method returns false initially
     * as the score of the Animal object has not changed at
     * the start of the game.
     */
    @Test
    public void testChangeScoreReturnsFalseInitially(){
        assertFalse(animalController.changeScore());
    }

    /**
     * Tests that the points of the Animal object are
     * initially zero at the start of the game.
     */
    @Test
    public void testPointsInitiallyZero(){
        assertEquals(0,animalController.getPoints());
    }

    /**
     * Tests that the points of the animal object has changed
     * when teh EndGoal is reached.
     */
    @Test
    public void testPointsChange(){
        MyStage stage = new MyStage();
        EndGoal endGoal = new EndGoal(30,40);

        animalController.getActor().setY(40);
        animalController.getActor().setX(30);

        stage.add(endGoal);
        stage.add(animalController.getActor());

        assertNotNull(animalController.getActor().getIntersectingObjects(EndGoal.class));

        animalController.mainControl(6300000000L);

        assertEquals(50, animalController.getPoints());
        assertTrue(animalController.changeScore());

    }

    /**
     * Tests that the points change does not go below 0.
     */
    @Test
    public void testPointsChangeIsNotNegative(){
        MyStage stage = new MyStage();
        WetTurtle wetTurtle = new WetTurtle(30,40,2,20);

        stage.add(wetTurtle);
        stage.add(animalController.getActor());

        assertNotNull(animalController.getActor().getIntersectingObjects(WetTurtle.class));
        wetTurtle.act(6300000000L);

        animalController.mainControl(6300000000L);

        assertTrue(wetTurtle.isSunk());
        assertNotEquals(-100,animalController.getPoints());
    }

}