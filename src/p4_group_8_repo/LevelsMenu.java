package p4_group_8_repo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LevelsMenu {
    MyStage levelStages;
    GameScreen gameScreen;
    Scene scene;
    StartScreen startScreen;

    public Scene levelsMenu(Stage stage) {
        VBox vBox = new VBox();

        BackgroundImage backgroundImage = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/levelsBG.png",500,600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(backgroundImage));

        gameScreen = new GameScreen(1,false);
       // gameScreen.setMusic(false);

        Button level1Button = new Button("Level 1");
        level1Button.setOnAction(actionEvent -> {
                //gameScreen = new GameScreen(1,true);
            gameScreen.setMusic(true);
            gameScreen.setLevel(1);
                levelStages = gameScreen.gameScreen(stage);
                scene = new Scene(levelStages,600,800);
                levelStages.start();
                stage.setScene(scene);
                stage.show();
        });

        Button level2Button = new Button("Level 2");
        level2Button.setOnAction(actionEvent -> {
            //gameScreen = new GameScreen(2,true);
            gameScreen.setMusic(true);
            gameScreen.setLevel(2);
            levelStages = gameScreen.gameScreen(stage);
            scene = new Scene(levelStages,600,800);
            levelStages.start();
            stage.setScene(scene);
            stage.show();

        });

        Button level3Button = new Button("Level 3");
        level3Button.setOnAction(actionEvent -> {
            //gameScreen = new GameScreen(3,true);
            gameScreen.setMusic(true);
            gameScreen.setLevel(3);
            levelStages = gameScreen.gameScreen(stage);
            scene = new Scene(levelStages,600,800);
            levelStages.start();
            stage.setScene(scene);
            stage.show();
        });

        Button backButton = new Button("Back to Main Menu");
        backButton.setOnAction(actionEvent -> {
            startScreen = new StartScreen(false,1);
            try {
                startScreen.startGame(stage);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        vBox.getChildren().addAll(level1Button,level2Button,level3Button,backButton);
        buttons(vBox, level1Button);
        buttons(vBox,level2Button);
        buttons(vBox,level3Button);
        buttons(vBox,backButton);

        Scene scene1 = new Scene(vBox,500,600);

        return scene1;

    }

    static void buttons(VBox vBox, Button button) {
        vBox.setPrefWidth(340);
        vBox.setPrefHeight(50);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(0,20,10,20));
        vBox.setAlignment(Pos.CENTER);

        button.setMinWidth(vBox.getPrefWidth());
        button.setMinHeight(vBox.getPrefHeight());
    }

}
