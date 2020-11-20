package p4_group_8_repo.Views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import p4_group_8_repo.Controllers.GameAnimation;
import p4_group_8_repo.Models.*;

/**
 * This class is responsible for displaying the game screen view
 * on which the user play the game.
 * It is responsible for the look of the different levels of the game
 *
 */
public class GameScreenView implements GameViews{
    /**
     * The World that currently has all the game's actors in it
     */
   private final World background;
    /**
     * the main playable actor in the game
     */
   private Actor animal;
    /**
     * the level of the game
     */
   private final int level;

    /**
     * Constructor that instantiates a new Game screen.
     * Sets the level, the main actor and the world.
     *
     * @param level the level of the game
     */
    public GameScreenView(int level, Actor animal, World background){
        this.level=level;
        this.animal=animal;
        this.background=background;
    }

    /**
     * Displays the game screen.
     *
     * @param stage the stage of the game application. Type Stage.
     * @return Scene object that will display the game screen
     */
    public Scene view(Stage stage){

        createBackButton(stage);
        levels();
        createMusicButton();

        GameAnimation gameAnimation = new GameAnimation(stage, background, animal.getObjectController());
        gameAnimation.start();
        background.start();

        return new Scene(background, 600,800);
    }

    /**
     * Sets the background of the stage, and adds objects to it according to the level selected.
     */
    private void levels() {
        if (level==1 || level==4) {
            BackgroundImage backgroundImage;
            if(level==1){
                backgroundImage = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/iKogsKW.png",600,800,false,true),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
                addObstacle(1,false);
            } else {
                 backgroundImage = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/background7.png", 600,800,false,true),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
                waterLevels(-2, false);
            }
            background.setBackground(new Background(backgroundImage));
            addActorsToStage(329,376,217,96,166,276,false);
        } else if (level==2 || level==3) {
            boolean croc;
            BackgroundImage backgroundImage;
            if(level==2){
                backgroundImage = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/background2.png", 600, 800, false, true),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
                croc=false;
            } else {
                backgroundImage = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/background3.png", 600, 800, false, true),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
                croc=true;
            }
            background.setBackground(new Background(backgroundImage));

            addActorsToStage(310,360,190,60,135,260,croc);
            addObstacle(2,true);
        } else if(level==5){
            var backgroundImage = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/background8.png", 600, 800, false, true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            background.setBackground(new Background(backgroundImage));

            waterLevels(-3, true);
            addActorsToStage(329,376,217,96,166,276,true);
        }
        else {
            System.out.println("No level chosen.");
        }
    }

    /**
     * Creates a back button that allows
     * the user to go back to the levels menu
     * from the game screen.
     *
     * @param stage stage of the application
     */
    private void createBackButton(Stage stage) {
        VBox vBox = new VBox();
        vBox.setLayoutX(559);
        vBox.setAlignment(Pos.TOP_RIGHT);

        Button backButton = new Button("Back");
        backButton.setOnAction(event3 -> {
            GameViews gameView = new SelectViewFactory().getView("levels",0,null,null,null);
            try {
                background.stopMusic();
                stage.setScene(gameView.view(stage));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        vBox.getChildren().add(backButton);
        background.getChildren().add(vBox);
    }

    /**
     * Creates a music button on the screen that
     * allows the user to turn the music on/off.
     */
    private void createMusicButton() {
        ToggleButton musicButton = new ToggleButton();
        musicButton.getStylesheets().add(this.getClass().getResource("button.css").toExternalForm());

        background.getChildren().add(musicButton);
        musicButton.setOnAction(event -> {
            if (musicButton.isSelected())
                background.stopMusic();
            else
                background.playMusic();
        });
    }

    /**
     * Adds Obstacle objects to the game.
     *
     * @param speed    the speed of the obstacles
     * @param secondCar if a second car is needed on the level
     */
    private void addObstacle(int speed, boolean secondCar) {
        for (int i = 0; i <= 600; i += 300) {
            background.add(new SelectModelFactory().getActorWithImage( "file:src/p4_group_8_repo/images/truck1Right.png", i, 649, speed, 120));
        }
        for (int i = 100; i <= 550; i += 150) {
            background.add(new SelectModelFactory().getActorWithImage("file:src/p4_group_8_repo/images/car1Left.png", i, 597, -2, 50));
        }
        for (int i : new int[]{0, 500}) {
            background.add(new SelectModelFactory().getActorWithImage( "file:src/p4_group_8_repo/images/truck2Right.png", i, 540, speed, 200));
        }

        background.add(new SelectModelFactory().getActorWithImage( "file:src/p4_group_8_repo/images/car1Left.png", 500, 490, -5, 50));
        if (secondCar) {
            background.add(new SelectModelFactory().getActorWithImage( "file:src/p4_group_8_repo/images/car1Left.png", 500, 440, -4, 50));
        }
    }

    /**
     * Adds Actor objects such as Logs or Turtles to the stage as well
     * as the main Animal object that the user plays with.
     *
     * @param logY       the log's Y position
     * @param turtleY    the turtle's Y position
     * @param wetTurtleY the wet turtle's Y position
     * @param endY       the end (burrow)'s Y position
     * @param log3Y      the log of type 3's Y position
     * @param log2Y      the log of type 2's Y position
     * @param croc       boolean: true if crocodile should be added to the stage, false if not
     */
    private void addActorsToStage(int logY, int turtleY, int wetTurtleY, int endY, int log3Y, int log2Y, boolean croc) {
        //these numbers represent the x coordinates of "end" aka the burrows the user
        //has to reach to win the game

        int a = 13;
        int b = 141;
        int y = b - a;
        int c = b + y;
        int d = c + y + 1;
        int x = c + y + y + 3;
        background.add(new SelectModelFactory().getActor(2, 360,25,30,0,0));

        for (int k : new int[]{0, 220, 645}) {
            background.add(new SelectModelFactory().getActorWithImage("file:src/p4_group_8_repo/images/log3.png", k, log3Y, 0.75,150));
        }
        if(croc) {
            background.add(new SelectModelFactory().getActorWithImage("file:src/p4_group_8_repo/images/log3.png", 440, log3Y, 0.75, 150 ));
            background.add(new SelectModelFactory().getActorWithImage("file:src/p4_group_8_repo/images/redCroc.png", 140, log3Y, 2, 120) );
        }

        for (int k : new int[]{0, 400}) {
            background.add(new SelectModelFactory().getActorWithImage("file:src/p4_group_8_repo/images/logs.png", k, log2Y, -2,300));
        }

        if (croc) {
            background.add(new SelectModelFactory().getActorWithImage("file:src/p4_group_8_repo/images/redCroc.png", -50, log2Y, 2, 120));
        }

        for (int i = 50; i <= 490; i += 220) {
            background.add(new SelectModelFactory().getActorWithImage("file:src/p4_group_8_repo/images/log3.png", i, logY, 0.75, 150));
        }

        for (int j : new int[]{500, 300}) {
            background.add(new SelectModelFactory().getActor(3, j, turtleY,130,-1,0));
        }
        background.add(new SelectModelFactory().getActor(4,700,turtleY,130,-1,0));

        for (int j = 600; j >= 200; j -= 200) {
            background.add(new SelectModelFactory().getActor(4,j,wetTurtleY,130,-1,0));

        }

        for (int i : new int[]{a, b, c, d, x}) {
            background.add(new SelectModelFactory().getActor(1,i,endY,0,0,0));
        }

        animal = new SelectModelFactory().getAnimal();
        background.add(animal);
    }

    /**
     * Adds Actor objects to levels that are water based i.e
     * levels that are mainly on a river without roads
     * as compared to other levels.
     *
     * @param logSpeed speed of Log objects
     * @param car boolean as to whether to add an Obstacle, car, or not
     */
    private void waterLevels(int logSpeed, boolean car){

        for (int i = 0; i <= 540; i += 270) {
            background.add(new SelectModelFactory().getActor(3, i, 649,130,-1,0));
        }
        for (int i : new int[]{135, 405}) {
            background.add(new SelectModelFactory().getActor(4, i,649,130,-1,0));
        }

        for (int i : new int[]{0, 600, 200}) {
            background.add(new SelectModelFactory().getActorWithImage("file:src/p4_group_8_repo/images/crocodile.png", i, 597, 1.5,160));
        }

        for (int i = 0; i <= 540; i += 135) {
            background.add(new SelectModelFactory().getActor(4, i, 540,130,-1,0));
        }

        for (int i : new int[]{340, 830}) {
            background.add(new SelectModelFactory().getActorWithImage("file:src/p4_group_8_repo/images/log3.png", i, 500, logSpeed,150));
        }
        for (int i : new int[]{500, 1000}) {
            background.add(new SelectModelFactory().getActorWithImage("file:src/p4_group_8_repo/images/logs.png", i, 500, logSpeed,300));
        }

        if(car) {
            background.add(new SelectModelFactory().getActorWithImage("file:src/p4_group_8_repo/images/car1Left.png", 0, 440, -4, 50));
            background.add(new SelectModelFactory().getActorWithImage("file:src/p4_group_8_repo/images/car1Right.png", 540, 440, 2, 50));
        } else
            background.add(new SelectModelFactory().getActorWithImage("file:src/p4_group_8_repo/images/redCroc.png",100 , 440, 1.5,100));


    }

}
