package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;

public class Start {
   MyStage helpScreen;
   MyStage background;

    public void startGame(Stage primaryStage, boolean music, int level) throws Exception {
        primaryStage.setTitle("Frogger");

        background = new GameScreen(level).gameScreen(primaryStage, music);
        Scene scene  = new Scene(background,600,750);

        helpScreen = new MyStage();
        Scene helpScene = new Scene(helpScreen,500,600);

        BackgroundImage backgroundImage1 = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/helpBackground.png",500,600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        helpScreen.setBackground(new Background(backgroundImage1));


        Button startButton = new Button("Start game");
        startButton.setOnAction(actionEvent -> {
            LevelsMenu levelsMenu = new LevelsMenu();
            Scene levels = levelsMenu.levelsMenu(primaryStage);
                 primaryStage.setScene(levels);
        });

        Button helpButton = new Button("How to play the game");
        helpButton.setOnAction(actionEvent -> primaryStage.setScene(helpScene));

        Button exitButton = new Button("Exit game");
        exitButton.setOnAction(actionEvent -> System.exit(1));

        Scene endScene = new EndScreen().start(primaryStage);
        Button highScoreButton = new Button("View High-scores");
        highScoreButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    primaryStage.setScene(endScene);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        VBox vBox = new VBox();
        LevelsMenu.buttons(vBox, startButton);
        LevelsMenu.buttons(vBox, helpButton);
        LevelsMenu.buttons(vBox, exitButton);
        LevelsMenu.buttons(vBox, highScoreButton);

        vBox.getChildren().addAll(startButton,helpButton,highScoreButton,exitButton);
        Scene startScene = new Scene(vBox,500,600);

        BackgroundImage backgroundImage2 = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/FroggerBG2.png",500,600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(backgroundImage2));


        ToggleButton backButton = new ToggleButton("Back");
        helpScreen.getChildren().add(backButton);
        backButton.setOnAction(event3 -> {
            if(backButton.isSelected())
                primaryStage.setScene(startScene);
        });

        Button backButton2 = new Button("Back");
        backButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(startScene);
            }
        });

        backButton2.setLayoutX(559);
        background.getChildren().add(backButton2);

        background.start();
        primaryStage.setScene(startScene);
        primaryStage.show();

    }


}


