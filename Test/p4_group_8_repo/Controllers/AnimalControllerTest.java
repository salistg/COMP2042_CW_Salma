package p4_group_8_repo.Controllers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.Models.*;
import p4_group_8_repo.Views.MyStage;

import static org.junit.Assert.*;

public class AnimalControllerTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    private AnimalController animalController;
    private final double movement = 13.3333333 * 2;

    @Before
    public void setUp() {
        animalController = new AnimalController(new Animal());
    }

    @Test
    public void testAddingAnimalToStage(){
        MyStage myStage = new MyStage();
        myStage.add(animalController.getActor());
        assertNotNull(myStage.getChildren());
        assertEquals(myStage.getChildren().get(0), animalController.getActor());
    }


    @Test
    public void testGettingActor(){
        Animal animal = new Animal();
        assertEquals(animal.getClass(), animalController.getActor().getClass());
    }

    @Test
    public void testAnimalSettingXAndY(){
//        movement = 13.3333333 * 2
//        if (animal.getY() < 0 || animal.getY() > 734) {
//            animal.setX(300);
//            animal.setY(679.8 + movement);
//        }
        double movement = 13.3333333 * 2;

        MyStage myStage = new MyStage();
        myStage.getChildren().add(animalController.getActor());

        animalController.getActor().setY(-40);
        animalController.mainControl(900000000L);
        assertEquals(300, animalController.getActor().getX(),0.0001);
        assertEquals((679.8 + movement), animalController.getActor().getY(), 0.0001);

        animalController.getActor().setY(800);
        animalController.mainControl(900000000L);
        assertEquals(300, animalController.getActor().getX(),0.0001);
        assertEquals((679.8 + movement), animalController.getActor().getY(), 0.0001);

    }

    @Test
    public void testAnimalMovement1(){
        // current x = 300
        //current y = 679.8 + (13.3333333 * 2);
//        if (animal.getX() < 0) {
//            animal.move(movement * 2, 0);
//        }

        MyStage myStage = new MyStage();
        myStage.getChildren().add(animalController.getActor());

        animalController.getActor().setX(-40);
        animalController.mainControl(900000000L);
        assertEquals((-40)+(movement*2), animalController.getActor().getX(),0.0001);
        assertEquals((679.8 + movement), animalController.getActor().getY(), 0.0001);
    }

    @Test
    public void testAnimalMovement2(){
//        if (animal.getX() > 600) {
//            animal.move(-movement * 2, 0);
//        }



        MyStage myStage = new MyStage();
        myStage.getChildren().add(animalController.getActor());

        animalController.getActor().setX(800);
        animalController.mainControl(900000000L);
        assertEquals((800)+(-movement*2), animalController.getActor().getX(),0.0001);
        assertEquals((679.8 + movement), animalController.getActor().getY(), 0.0001);
    }

    //start of object intersection tests

    /**
     * Test to ensure that the
     * intersection between the Animal object and
     * End objects is correctly picked up
     * and causes the corresponding actions set in the
     * atIntersection() method.
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

        MyStage stage = new MyStage();
        End end = new End(30,40);
        animalController.getActor().setY(40);
        animalController.getActor().setX(30);
        stage.add(end);
        stage.add(animalController.getActor());
        //first check if they intersect
        assertNotNull(animalController.getActor().getIntersectingObjects(End.class));
        //then call the atIntersection() method
        animalController.mainControl(6300000000L);
        //points change is detected in the testPointsGetter() test
        //check that the X and Y positions have been set
        assertEquals(300,animalController.getActor().getX(), 0.0001);
        assertEquals(679.8+movement, animalController.getActor().getY(),0.0001);
    }

    @Test
    public void testAnimalIntersectionWithLogObjects(){
//        else if (animal.getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
//            if (animal.getIntersectingObjects(Log.class).get(0).getLeft())
//                animal.move(-2, 0);
//            else
//                animal.move(.75, 0);

        MyStage stage = new MyStage();
        Log log = new Log("file:src/p4_group_8_repo/images/log3.png",80,30,40,2);
        animalController.getActor().setY(40);
        animalController.getActor().setX(30);
        stage.add(log);
        stage.add(animalController.getActor());
        //first check if they intersect
        assertNotNull(animalController.getActor().getIntersectingObjects(Log.class));
        //then call the atIntersection() method
        animalController.mainControl(6300000000L);
        //check that the X and Y positions have been changed
        assertEquals(30+.75,animalController.getActor().getX(), 0.0001);
        assertEquals(40, animalController.getActor().getY(),0.0001);
    }

    @Test
    public void testAnimalIntersectionWithLeftLogObjects(){
//        else if (animal.getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
//            if (animal.getIntersectingObjects(Log.class).get(0).getLeft())
//                animal.move(-2, 0);
//            else
//                animal.move(.75, 0);

        MyStage stage = new MyStage();
        Log log = new Log("file:src/p4_group_8_repo/images/log3.png",80,30,40,-2);
        animalController.getActor().setY(40);
        animalController.getActor().setX(30);
        stage.add(log);
        stage.add(animalController.getActor());
        //first check if they intersect
        assertNotNull(animalController.getActor().getIntersectingObjects(Log.class));
        //then call the atIntersection() method
        animalController.mainControl(6300000000L);
        //check that the X and Y positions have been changed
        assertEquals(30+(-2),animalController.getActor().getX(), 0.0001);
        assertEquals(40, animalController.getActor().getY(),0.0001);
    }

    @Test
    public void testAnimalIntersectionWithObstacleObjects(){
//        if (animal.getIntersectingObjects(Obstacle.class).size() >= 1) {
//                carDeath = true;

        MyStage stage = new MyStage();
        Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/images/car1Left.png",30,40,2,90);
        animalController.getActor().setY(40);
        animalController.getActor().setX(30);
        stage.add(obstacle);
        stage.add(animalController.getActor());
        //first check if they intersect
        assertNotNull(animalController.getActor().getIntersectingObjects(Obstacle.class));
        //then call the atIntersection() method
        animalController.mainControl(6300000000L);
        //check if carDeath has been set to true
        assertTrue(animalController.getCarDeath());

    }

    @Test
    public void testAnimalIntersectionWithTurtleObjects(){
//         else if (animal.getIntersectingObjects(Turtle.class).size() >= 1 && !getMove()) {
//            animal.move(-1, 0);
//        }

        MyStage stage = new MyStage();
        Turtle turtle = new Turtle(30,40,2,60);
        animalController.getActor().setY(40);
        animalController.getActor().setX(30);
        stage.add(turtle);
        stage.add(animalController.getActor());
        //first check if they intersect
        assertNotNull(animalController.getActor().getIntersectingObjects(Turtle.class));
        //then call the atIntersection() method
        animalController.mainControl(6300000000L);
        //check that the X and Y positions have been changed
        assertEquals(30+(-1),animalController.getActor().getX(), 0.0001);
        assertEquals(40, animalController.getActor().getY(),0.0001);

    }

    @Test
    public void testAnimalIntersectionWithWetTurtleObjectsNotSunk(){
//        else if (animal.getIntersectingObjects(WetTurtle.class).size() >= 1) {
//            if (animal.getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
//                waterDeath = true;
//            } else {
//                animal.move(-1, 0);
//            }

        MyStage stage = new MyStage();
        WetTurtle wetTurtle = new WetTurtle(30,40,2,60);
        animalController.getActor().setY(40);
        animalController.getActor().setX(30);
        stage.add(wetTurtle);
        stage.add(animalController.getActor());
        //first check if they intersect
        assertNotNull(animalController.getActor().getIntersectingObjects(WetTurtle.class));
        //then call the atIntersection() method
        animalController.mainControl(6300000000L);
        //check that the X and Y positions have been changed
        assertEquals(30+(-1),animalController.getActor().getX(), 0.0001);
        assertEquals(40, animalController.getActor().getY(),0.0001);

    }

    @Test
    public void testAnimalIntersectionWithWetTurtleObjectsSunk(){
//      else if (animal.getIntersectingObjects(WetTurtle.class).size() >= 1) {
//            if (animal.getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
//                waterDeath = true;
//            } else {
//                animal.move(-1, 0);
//            }

        MyStage stage = new MyStage();
        WetTurtle wetTurtle = new WetTurtle(30,40,2,60);
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

//    @Test
//    public void testCarDeath(){
//
//        MyStage stage = new MyStage();
//        Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/images/car1Left.png",30,40,2,90,90);
//        animalController.getActor().setY(40);
//        animalController.getActor().setX(30);
//        stage.add(obstacle);
//        stage.add(animalController.getActor());
//        //first check if they intersect
//        assertNotNull(animalController.getActor().getIntersectingObjects(Obstacle.class));
//        //then call the mainControl method
//        animalController.mainControl(1100000000L);
//        //death++
//        //check if carDeath has been set to true
//        assertTrue(animalController.getCarDeath());
//        assertEquals(1,animalController.getDeaths());
//
//
//    }


    @Test
    public void testChangeScoreReturnsFalse(){
        assertFalse(animalController.changeScore());
    }

    @Test
    public void testPointsInitiallyZero(){
        assertEquals(0,animalController.getPoints());
    }

//    @Test
//    public void testMoveGetterReturnsFalse(){
//        assertFalse(animalController.getMove());
//    }
//
//    @Test
//    public void testWaterDeathGetterReturnsFalse(){
//        assertFalse(animalController.getWaterDeath());
//    }
//
//    @Test
//    public void testCarDeathGetterReturnsFalse(){
//        assertFalse(animalController.getCarDeath());
//    }

    @Test
    public void testPointsGetterAndChangeScoreReturnsTrue(){
        MyStage stage = new MyStage();
        End end = new End(30,40);
        animalController.getActor().setY(40);
        animalController.getActor().setX(30);
        stage.add(end);
        stage.add(animalController.getActor());
        assertNotNull(animalController.getActor().getIntersectingObjects(End.class));
        animalController.mainControl(6300000000L);
        assertEquals(50, animalController.getPoints());
        assertTrue(animalController.changeScore());
    }
}