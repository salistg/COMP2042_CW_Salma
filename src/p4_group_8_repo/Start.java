package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Start {
    AnimationTimer timer;
    MyStage background;
    MyStage startScreen;
    MyStage helpScreen;
    MyStage exitScreen;
    Animal animal;
    //Stage primaryStage;


    public void startGame(Stage primaryStage) throws FileNotFoundException {
        background = new MyStage();
        Scene scene  = new Scene(background,600,800);
        primaryStage.setTitle("Frogger");

//		Menu menu = new Menu();
//		background.getChildren().add(menu.createFeatures());

        javafx.scene.layout.BackgroundImage backgroundImage = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/iKogsKW.png",600,800,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        background.setBackground(new Background(backgroundImage));

//		Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 25, 25, 3);
//		Obstacle obstacle1 = new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 100, 100,2 );
//		Obstacle obstacle2 = new Obstacle("file:src/p4_group_8_repo/truck1Right.png",0,  150, 1);

//		BackgroundImage froggerback = new BackgroundImage("file:src/p4_group_8_repo/images/Screen Shot 2017-05-29 at 10.02.14 PM.png");
//
//		background.add(froggerback);

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
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 100, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 0, 100, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 120, -1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 120, -1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 140, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 140, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 160, -1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 300, 160, -1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 180, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 180, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 200, -1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 200, -1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 220, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 220, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 400, 220, 1));
        //End end2 = new End();
        //End end3 = new End();
        //End end4 = new End();
        //End end5 = new End();
        background.add(new End(13,96));
        background.add(new End(141,96));
        background.add(new End(141 + 141-13,96));
        background.add(new End(141 + 141-13+141-13+1,96));
        background.add(new End(141 + 141-13+141-13+141-13+3,96));
        animal = new Animal("file:src/p4_group_8_repo/images/froggerUp.png");
        background.add(animal);
        background.add(new Obstacle("file:src/p4_group_8_repo/images/truck1"+"Right.png", 0, 649, 1, 120, 120));
        background.add(new Obstacle("file:src/p4_group_8_repo/images/truck1"+"Right.png", 300, 649, 1, 120, 120));
        background.add(new Obstacle("file:src/p4_group_8_repo/images/truck1"+"Right.png", 600, 649, 1, 120, 120));
        //background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
        background.add(new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", 100, 597, -1, 50, 50));
        background.add(new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", 250, 597, -1, 50, 50));
        background.add(new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", 400, 597, -1, 50, 50));
        background.add(new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", 550, 597, -1, 50, 50));
        background.add(new Obstacle("file:src/p4_group_8_repo/images/truck2Right.png", 0, 540, 1, 200, 200));
        background.add(new Obstacle("file:src/p4_group_8_repo/images/truck2Right.png", 500, 540, 1, 200, 200));
        background.add(new Obstacle("file:src/p4_group_8_repo/images/car1Left.png", 500, 490, -5, 50, 50));
        background.add(new Digit(0, 30, 360, 25));
        //background.add(obstacle);
        //background.add(obstacle1);
        //background.add(obstacle2);

        ToggleButton musicButton = new ToggleButton();
        musicButton.getStylesheets().add(this.getClass().getResource("button.css").toExternalForm());

        background.getChildren().add(musicButton);
        musicButton.setOnAction(event -> {
            if (musicButton.isSelected())
                background.stopMusic();
            else
                background.playMusic();
        });


        helpScreen = new MyStage();
        Scene helpScene = new Scene(helpScreen,500,600);

        BackgroundImage backgroundImage1 = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/helpBackground.png",500,600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        helpScreen.setBackground(new Background(backgroundImage1));


        Button startButton = new Button("Start game");
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(scene);
            }
        });
        Button helpButton = new Button("How to play the game");
        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(helpScene);
            }
        });
        Button exitButton = new Button("Exit game");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(1);
            }
        });

        VBox vBox = new VBox();
        vBox.setPrefWidth(340);
        vBox.setPrefHeight(50);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(0,20,10,20));
        vBox.setAlignment(Pos.CENTER);

        startButton.setMinWidth(vBox.getPrefWidth());
        startButton.setMinHeight(vBox.getPrefHeight());
        helpButton.setMinWidth(vBox.getPrefWidth());
        helpButton.setMinHeight(vBox.getPrefHeight());
        exitButton.setMinWidth(vBox.getPrefWidth());
        exitButton.setMinHeight(vBox.getPrefHeight());

        vBox.getChildren().addAll(startButton,helpButton,exitButton);
        Scene startScene = new Scene(vBox,500,600);

        BackgroundImage backgroundImage2 = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/FroggerBG2.png",500,600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(backgroundImage2));


        ToggleButton backButton = new ToggleButton("Back");
        helpScreen.getChildren().add(backButton);
        backButton.setOnAction(event3 -> {
            if(backButton.isSelected())
                primaryStage.setScene(startScene);
            else
                primaryStage.setScene(helpScene);

        });


        background.start();
        primaryStage.setScene(startScene);
        primaryStage.show();
        start();

    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (animal.changeScore()) {
                    setNumber(animal.getPoints());
                }
                if (animal.getStop()) {
                    System.out.print("STOPP:");
                    background.stopMusic();
                    stop();
                    background.stop();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("You Have Won The Game!");
                    alert.setHeaderText("Your High Score: " + animal.getPoints() + "!");
                    alert.setContentText("Highest Possible Score: 800");
                    alert.show();
                }
            }
        };
    }

    public void stop() {
        timer.stop();
    }

    public void start() {
        background.playMusic();
        createTimer();
        timer.start();
    }

        public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }

}


