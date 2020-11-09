package p4_group_8_repo.Views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import p4_group_8_repo.Controllers.AnimationController;
import p4_group_8_repo.Models.*;
import p4_group_8_repo.MyStage;

import java.util.Arrays;

/**
 * This class is responsible for displaying the game screen view on which the user can play the game.
 * It is responsible for displaying the different levels as the user chooses them.
 *
 */
public class GameScreenView implements GameViews{
   private MyStage background = null;
   private Animal animal = null;
   private final int level;

    /**
     * Constructor that instantiates a new Game screen.
     * Sets the level and the music boolean.
     *
     * @param level the level of the game
     */
    public GameScreenView(int level){
        this.level=level;
    }


    /**
     * Displays the game screen according to the levels chosen.
     *
     * @param stage the stage of the game application. Type Stage.
     * @return a MyStage object which has the scenes of the different levels of the game.
     */
    public Scene view(Stage stage){
        background = new MyStage();

        var backgroundImage = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/iKogsKW.png",600,800,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        var backgroundImage2 = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/background2.png",600,800,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        var backgroundImage3 = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/background3.png",600,800,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        VBox vBox = new VBox();
        vBox.setLayoutX(559);
        vBox.setAlignment(Pos.TOP_RIGHT);

        Button backButton = new Button("Back");
        backButton.setOnAction(event3 -> {
            try {
                background.stopMusic();
                stage.setScene(new LevelsMenuView().view(stage));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        vBox.getChildren().add(backButton);
        background.getChildren().add(vBox);
        background.add(new Digit(0, 30, 360, 25));

        if (level==1) {
            background.setBackground(new Background(backgroundImage));
            addBG(329,376,217,96,166,276,false);
            addObstacle(1,false);
        } else if (level==2) {
            background.setBackground(new Background(backgroundImage2));
            addBG(310,360,190,60,135,260,false);
            addObstacle(2,true);
        } else if (level==3){
            background.setBackground(new Background(backgroundImage3));
            addBG(310,360,190,60,135,260,true);
            addObstacle(2,true);
        } else {
            System.out.println("No level chosen.");
        }

        ToggleButton musicButton = new ToggleButton();
        musicButton.getStylesheets().add(this.getClass().getResource("button.css").toExternalForm());

        background.getChildren().add(musicButton);
        musicButton.setOnAction(event -> {
            if (musicButton.isSelected())
                background.stopMusic();
            else
                background.playMusic();
        });

        AnimationController animationController = new AnimationController();
        animationController.start(stage, animal.animalController, background);
        background.start();

        return new Scene(background, 600,800);
    }

    /**
     * Sets the Game Screen according to the level chosen.
     *
     * @param stage the stage of the application
     */
    public void setGameScreen(Stage stage) {
        Scene scene = view(stage);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method adds obstacle objects to the game.
     *
     * @param speed1    the speed of the obstacles
     * @param secondCar if we want a second car on the level or not
     */
    private void addObstacle(int speed1, boolean secondCar) {
        for (int i = 0; i <= 600; i += 300) {
            background.add(new Obstacle("file:src/p4_group_8_repo/images/truck1"+"Right.png", i, 649, speed1, 120, 120));
        }
        for (int i = 100; i <= 550; i += 150) {
            background.add(new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", i, 597, -2, 50, 50));
        }
        for (int i : new int[]{0, 500}) {
            background.add(new Obstacle("file:src/p4_group_8_repo/images/truck2Right.png", i, 540, speed1, 200, 200));
        }
        background.add(new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", 500, 490, -5, 50, 50));
        if(secondCar)
            background.add(new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", 500, 440, -4, 50, 50));
    }

    /**
     * This method adds objects such as Logs or Turtles to the stage as well
     * as the main animal object that the user plays with.
     *
     * @param logY       the log's Y position
     * @param turtleY    the turtle's Y position
     * @param wetTurtleY the wet turtle's Y position
     * @param endY       the end (burrow)'s Y position
     * @param log3Y      the log 3 Y position
     * @param log2Y      the log 2 Y position
     * @param croc       boolean: true if crocodile should be added to the stage, false if not
     */
    private void addBG(int logY, int turtleY, int wetTurtleY, int endY, int log3Y, int log2Y, boolean croc) {
        //these numbers represent the x coordinates of "end" aka the burrows the user
        //has to reach to win the game
        int a = 13;
        int b = 141;
        int y = b - a;
        int c = b + y;
        int d = c + y + 1;
        int x = c + y + y + 3;

        for (int k : new int[]{0, 220, 645}) {
            background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, k, log3Y, 0.75));
        }
        if(croc) {
            background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, 440, log3Y, 0.75));
            background.add(new Obstacle("file:src/p4_group_8_repo/images/redCroc.png", 140, log3Y, 2, 120, 120));
        }

        background.add(new Log("file:src/p4_group_8_repo/images/logs.png", 300, 0, log2Y, -2));
        background.add(new Log("file:src/p4_group_8_repo/images/logs.png", 300, 400, log2Y, -2));
        if (croc) background.add(new Obstacle("file:src/p4_group_8_repo/images/redCroc.png", -50, log2Y, 2, 120, 120));

        for (int i = 50; i <= 490; i += 220) {
            background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, i, logY, 0.75));
        }

        for (int j : new int[]{500, 300}) {
            background.add(new Turtle(j, turtleY, -1, 130, 130));
        }

        for (WetTurtle wetTurtle : Arrays.asList(new WetTurtle(700, turtleY, -1, 130, 130),
                new WetTurtle(600, wetTurtleY, -1, 130, 130),
                new WetTurtle(400, wetTurtleY, -1, 130, 130),
                new WetTurtle(200, wetTurtleY, -1, 130, 130))) {
            background.add(wetTurtle);
        }

        for (int i : new int[]{a, b, c, d, x}) {
            background.add(new End(i, endY));
        }

        animal = new Animal();
        background.add(animal);
    }

}
