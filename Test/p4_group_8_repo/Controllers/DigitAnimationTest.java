package p4_group_8_repo.Controllers;

import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.Models.Actor;
import p4_group_8_repo.Models.Animal;
import p4_group_8_repo.Models.Digit;
import p4_group_8_repo.Models.End;
import p4_group_8_repo.Views.MyStage;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DigitAnimationTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    DigitAnimation digitAnimation;
    Stage stage;
    MyStage myStage;
    Controllers controllers;
    Actor animal;

    @Before
    public void setUp(){
        stage = new Stage();
        myStage = new MyStage();
        animal = new Animal();
        controllers = new AnimalController(animal);
        digitAnimation = new DigitAnimation(stage,myStage,controllers);
    }

    @Test
    public void testTimerIsRunning(){
        digitAnimation.start();
        assertTrue(digitAnimation.getIsRunning());
    }

    @Test
    public void testTimerIsNotRunning(){
        digitAnimation.start();
        digitAnimation.stop();
        assertFalse(digitAnimation.getIsRunning());
    }

    @Test
    public void testDigitNumberIsSet(){
        Stage stage = new Stage();
        AnimalController animalController = new AnimalController(animal);
        End end = new End(30,40);
        animalController.getActor().setY(40);
        animalController.getActor().setX(30);
        myStage.add(end);
        myStage.add(animalController.getActor());
       // assertNotNull(animalController.getActor().getIntersectingObjects(End.class));
        animalController.mainControl(6300000000L);
//        assertEquals(50, animalController.getPoints());
//        assertTrue(animalController.changeScore());
        myStage.start();
        DigitAnimation digitAnimation1 = new DigitAnimation(stage, myStage, animalController);
        digitAnimation1.start();
        System.out.println(animalController.changeScore());
        System.out.println(Arrays.toString(this.myStage.getChildren().toArray()));
    }


}