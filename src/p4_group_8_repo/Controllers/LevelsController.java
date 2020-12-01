package p4_group_8_repo.Controllers;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import p4_group_8_repo.Controllers.SelectModelFactory;
import p4_group_8_repo.Models.Actor;
import p4_group_8_repo.Models.Obstacle;
import p4_group_8_repo.Views.World;

/**
 * This class is responsible for the look of the different levels of the game such as
 * what actors should be added to each level and the difficulty of the levels. </br>
 * There are 5 different levels in the game and the user can select whichever
 *  level they want to try.
 */
public class LevelsController {
    /**
     * The level chosen by the player.
     */
    private final int level;
    /**
     * The world in which the actors will exist.
     */
    private final World background;
    /**
     * A string to hold the file path
     * of the image source.
     */
    private final String imageSource= "file:src/p4_group_8_repo/images/";

    /**
     * Instantiates a new LevelsController.
     * @param level
     * @param background
     */
    public LevelsController(int level, World background){
        this.level=level;
        this.background = background;
    }

    /**
     * Sets the background of the stage,
     * and adds Actor objects to it according to the level selected.
     */
    public void levels() {
        if (level==1 || level==4) {
            BackgroundImage backgroundImage;
            if(level==1){
                backgroundImage = new BackgroundImage(new Image(imageSource + "iKogsKW.png",600,800,false,true),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
                addObstacleToStage(1,false);
            } else {
                backgroundImage = new BackgroundImage(new Image(imageSource + "background7.png", 600,800,false,true),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
                waterLevelsActors(-2, false);
            }
            background.setBackground(new Background(backgroundImage));

            addLogsToStage(329, 166, 276, false);
            addTurtlesToStage(376, 217);
            addEndGoalToStage(96);
        } else if (level==2 || level==3) {
            boolean croc;
            BackgroundImage backgroundImage;
            if(level==2){
                backgroundImage = new BackgroundImage(new Image(imageSource + "background2.png", 600, 800, false, true),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
                croc=false;
            } else {
                backgroundImage = new BackgroundImage(new Image(imageSource + "background3.png", 600, 800, false, true),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
                croc=true;
            }
            background.setBackground(new Background(backgroundImage));

            addLogsToStage(310, 135, 260, croc);
            addTurtlesToStage(360,190);
            addObstacleToStage(2,true);
            addEndGoalToStage(60);
        } else if(level==5){
            var backgroundImage = new BackgroundImage(new Image(imageSource + "background8.png", 600, 800, false, true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            background.setBackground(new Background(backgroundImage));

            waterLevelsActors(-3, true);
            addTurtlesToStage(376, 217);
            addLogsToStage(329, 166, 276, true);
            addEndGoalToStage(96);
        }
        else {
            System.out.println("No level chosen.");
        }
    }

    /**
     * Adds Obstacle objects to the game.
     *
     * @param speed    the speed of the obstacles
     * @param secondCar if a second car is needed on the level
     */
    private void addObstacleToStage(int speed, boolean secondCar) {

        for (int i = 0; i <= 600; i += 300) {
            background.add(new SelectModelFactory().getActorWithImage( imageSource + "truck1Right.png",
                    i, 649, speed, 120));
        }
        for (int i = 100; i <= 550; i += 150) {
            background.add(new SelectModelFactory().getActorWithImage(imageSource + "car1Left.png",
                    i, 597, -2, 50));
        }
        for (int i : new int[]{0, 500}) {
            background.add(new SelectModelFactory().getActorWithImage( imageSource + "truck2Right.png",
                    i, 540, speed, 200));
        }

        background.add(new SelectModelFactory().getActorWithImage( imageSource + "car1Left.png",
                500, 490, -5, 50));
        if (secondCar) {
            background.add(new SelectModelFactory().getActorWithImage( imageSource + "car1Left.png",
                    500, 440, -4, 50));
        }

        background.getChildren().remove(Obstacle.class);
    }

    /**
     * Adds EndGoal objects to the stage.
     *
     * @param endY the end goal object's Y position
     */
    private void addEndGoalToStage(int endY) {
        //these numbers represent the x coordinates of the end goal

        int a = 13;
        int b = 141;
        int y = b - a;
        int c = b + y;
        int d = c + y + 1;
        int x = c + y + y + 3;
        background.add(new SelectModelFactory().getActor(2, 360,25,30,0,0));


        for (int i : new int[]{a, b, c, d, x}) {
            background.add(new SelectModelFactory().getActor(1,
                    i,endY,0,0,0));
        }

        background.getChildren().remove(Actor.class);
    }

    /**
     * Adds objects of type Turtle or WetTurtle to the stage.
     *
     * @param turtleY Y position of Turtle objects
     * @param wetTurtleY Y position of WetTurtle objects
     */
    private void addTurtlesToStage(int turtleY, int wetTurtleY) {
        for (int j : new int[]{500, 300}) {
            background.add(new SelectModelFactory().getActor(3,
                    j, turtleY,130,-1,0));
        }
        background.add(new SelectModelFactory().getActor(4,
                700, turtleY,130,-1,0));

        for (int j = 600; j >= 200; j -= 200) {
            background.add(new SelectModelFactory().getActor(4,
                    j, wetTurtleY,130,-1,0));
        }
    }

    /**
     * Adds objects of type Log to the stage.
     *
     * @param logY Y position of Log objects.
     * @param log3Y Y position of Log objects of type Log 3.
     * @param log2Y Y position of Log objects of type Log 2.
     * @param croc if a red crocodile should be added to the stage.
     */
    private void addLogsToStage(int logY, int log3Y, int log2Y, boolean croc) {
        for (int k : new int[]{0, 220, 645}) {
            background.add(new SelectModelFactory().getActorWithImage(imageSource + "log3.png",
                    k, log3Y, 0.75,150));
        }
        if(croc) {
            background.add(new SelectModelFactory().getActorWithImage(imageSource + "log3.png",
                    440, log3Y, 0.75, 150 ));
            background.add(new SelectModelFactory().getActorWithImage(imageSource + "redCroc.png",
                    140, log3Y, 2, 120) );
        }

        for (int k : new int[]{0, 400}) {
            background.add(new SelectModelFactory().getActorWithImage(imageSource + "logs.png",
                    k, log2Y, -2,300));
        }

        if (croc) {
            background.add(new SelectModelFactory().getActorWithImage(imageSource + "redCroc.png",
                    -50, log2Y, 2, 120));
        }

        for (int i = 50; i <= 490; i += 220) {
            background.add(new SelectModelFactory().getActorWithImage(imageSource + "log3.png",
                    i, logY, 0.75, 150));
        }
    }

    /**
     * Adds Actor objects to levels that are water based i.e
     * levels that are mainly on a river as compared to other levels.
     *
     * @param logSpeed speed of Log objects
     * @param car boolean as to whether to add an Obstacle object, car, or not
     */
    private void waterLevelsActors(int logSpeed, boolean car){

        for (int i = 0; i <= 540; i += 270) {
            background.add(new SelectModelFactory().getActor(3,
                    i, 649,130,-1,0));
        }
        for (int i : new int[]{135, 405}) {
            background.add(new SelectModelFactory().getActor(4,
                    i,649,130,-1,0));
        }

        for (int i : new int[]{0, 200}) {
            background.add(new SelectModelFactory().getActorWithImage(imageSource  + "redCroc.png",
                    i, 597, 1,160));
        }

        for (int i = 0; i <= 540; i += 135) {
            background.add(new SelectModelFactory().getActor(4,
                    i, 540,130,-1,0));
        }

        for (int i : new int[]{340, 830}) {
            background.add(new SelectModelFactory().getActorWithImage(imageSource + "log3.png",
                    i, 500, logSpeed,150));
        }
        for (int i : new int[]{500, 1000}) {
            background.add(new SelectModelFactory().getActorWithImage(imageSource + "logs.png",
                    i, 500, logSpeed,300));
        }

        if(car) {
            background.add(new SelectModelFactory().getActorWithImage(imageSource + "car1Left.png", 0,
                    440, -4, 50));
            background.add(new SelectModelFactory().getActorWithImage(imageSource + "car1Right.png", 540,
                    440, 2, 50));
        } else
            background.add(new SelectModelFactory().getActorWithImage(imageSource + "redCroc.png",100 ,
                    440, 1.5,100));

        background.getChildren().remove(Actor.class);
    }

}
