package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;


public class GameScreen {
    AnimationTimer timer;
    MyStage background;
    Animal animal;
    int level;

    public GameScreen(int level){
        this.level=level;
    }

    public MyStage gameScreen (Stage stage, boolean music){
        background = new MyStage();

        BackgroundImage backgroundImage = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/iKogsKW.png",600,800,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        BackgroundImage backgroundImage2 = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/background2.png",600,800,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        BackgroundImage backgroundImage3 = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/background3.png",600,800,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        int x = 141 + 141 - 13 + 141 - 13 + 141 - 13 + 3;

        if (level==1) {

            background.setBackground(new Background(backgroundImage));

            background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, 0, 166, 0.75));
            background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, 220, 166, 0.75));
            background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, 440, 166, 0.75));
            //background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
            background.add(new Log("file:src/p4_group_8_repo/images/logs.png", 300, 0, 276, -2));
            background.add(new Log("file:src/p4_group_8_repo/images/logs.png", 300, 400, 276, -2));
            //background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 800, 276, -2));
            background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, 50, 329, 0.75));
            background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, 270, 329, 0.75));
            background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, 490, 329, 0.75));
            //background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 570, 329, 0.75));

            background.add(new Turtle(500, 376, -1, 130, 130));
            background.add(new Turtle(300, 376, -1, 130, 130));
            background.add(new WetTurtle(700, 376, -1, 130, 130));
            background.add(new WetTurtle(600, 217, -1, 130, 130));
            background.add(new WetTurtle(400, 217, -1, 130, 130));
            background.add(new WetTurtle(200, 217, -1, 130, 130));

            background.add(new End(13, 96));
            background.add(new End(141, 96));
            background.add(new End(141 + 141 - 13, 96));
            background.add(new End(141 + 141 - 13 + 141 - 13 + 1, 96));
            background.add(new End(x, 96));
            animal = new Animal("file:src/p4_group_8_repo/images/froggerUp.png");
            background.add(animal);
            background.add(new Obstacle("file:src/p4_group_8_repo/images/truck1" + "Right.png", 0, 649, 1, 120, 120));
            background.add(new Obstacle("file:src/p4_group_8_repo/images/truck1" + "Right.png", 300, 649, 1, 120, 120));
            background.add(new Obstacle("file:src/p4_group_8_repo/images/truck1" + "Right.png", 600, 649, 1, 120, 120));
            //background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
            background.add(new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", 100, 597, -1, 50, 50));
            background.add(new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", 250, 597, -1, 50, 50));
            background.add(new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", 400, 597, -1, 50, 50));
            background.add(new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", 550, 597, -1, 50, 50));
            background.add(new Obstacle("file:src/p4_group_8_repo/images/truck2Right.png", 0, 540, 1, 200, 200));
            background.add(new Obstacle("file:src/p4_group_8_repo/images/truck2Right.png", 500, 540, 1, 200, 200));
            background.add(new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", 500, 490, -5, 50, 50));
            background.add(new Digit(0, 30, 360, 25));
        } else if (level==2) {
            background.setBackground(new Background(backgroundImage2));

            background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, 0, 135, 0.75));
            background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, 220, 135, 0.75));
            background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, 440, 135, 0.75));
            //background2.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
            background.add(new Log("file:src/p4_group_8_repo/images/logs.png", 300, 0, 260, -2));
            background.add(new Log("file:src/p4_group_8_repo/images/logs.png", 300, 400, 260, -2));

            addBG(x);


            background.add(new Obstacle("file:src/p4_group_8_repo/images/truck1"+"Right.png", 0, 649, 2, 120, 120));
            background.add(new Obstacle("file:src/p4_group_8_repo/images/truck1"+"Right.png", 300, 649, 2, 120, 120));
            background.add(new Obstacle("file:src/p4_group_8_repo/images/truck1"+"Right.png", 600, 649, 2, 120, 120));
//        background2.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, -2, 120, 120));
            addObstacle();
//        background2.add(new Digit(0, 30, 360, 15));
        } else if (level==3){

            background.setBackground(new Background(backgroundImage3));


            background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, 0, 135, 0.75));
            background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, 220, 135, 0.75));
            background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, 645, 135, 0.75));
            background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, 440, 135, 0.75));
            background.add(new Obstacle("file:src/p4_group_8_repo/images/redCroc.png", 140, 135, 2, 120, 120));
            //background2.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
            background.add(new Log("file:src/p4_group_8_repo/images/logs.png", 300, 0, 260, -2));
            background.add(new Log("file:src/p4_group_8_repo/images/logs.png", 300, 400, 260, -2));
            //background3.add(new Log("file:src/p4_group_8_repo/images/crocodile.png", 220, 730 , 255, -2));
            background.add(new Obstacle("file:src/p4_group_8_repo/images/redCroc.png", -50, 255, 2, 120, 120));


            addBG(x);


            background.add(new Obstacle("file:src/p4_group_8_repo/images/truck1"+"Right.png", 0, 649, 3, 120, 120));
            background.add(new Obstacle("file:src/p4_group_8_repo/images/truck1"+"Right.png", 300, 649, 3, 120, 120));
            background.add(new Obstacle("file:src/p4_group_8_repo/images/truck1"+"Right.png", 600, 649, 3, 120, 120));
//        background2.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, -2, 120, 120));
            addObstacle();


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

        TimerAndStart timerAndStart = new TimerAndStart();
        timerAndStart.start(stage, animal, background, music);

        return background;
    }

    private void addObstacle() {
        background.add(new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", 100, 597, -2, 50, 50));
        background.add(new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", 250, 597, -2, 50, 50));
        background.add(new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", 400, 597, -2, 50, 50));
        background.add(new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", 550, 597, -2, 50, 50));
        background.add(new Obstacle("file:src/p4_group_8_repo/images/truck2Right.png", 0, 540, 2, 200, 200));
        background.add(new Obstacle("file:src/p4_group_8_repo/images/truck2Right.png", 500, 540, 2, 200, 200));
        background.add(new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", 500, 490, -5, 50, 50));
        background.add(new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", 500, 440, -4, 50, 50));
    }

    private void addBG(int x) {
        background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, 50, 310, 0.75));
        background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, 270, 310, 0.75));
        background.add(new Log("file:src/p4_group_8_repo/images/log3.png", 150, 490, 310, 0.75));


        background.add(new Turtle(500, 360, -1, 130, 130));
        background.add(new Turtle(300, 360, -1, 130, 130));
        background.add(new WetTurtle(700, 360, -1, 130, 130));
        background.add(new WetTurtle(600, 190, -1, 130, 130));
        background.add(new WetTurtle(400, 190, -1, 130, 130));
        background.add(new WetTurtle(200, 190, -1, 130, 130));

        background.add(new End(13,60));
        background.add(new End(141,60));
        background.add(new End(141 + 141-13,60));
        background.add(new End(141 + 141-13+141-13+1,60));
        background.add(new End(x,60));

        animal = new Animal("file:src/p4_group_8_repo/images/froggerUp.png");
        background.add(animal);
    }

}
