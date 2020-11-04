package p4_group_8_repo;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class is responsible for displaying the Start Screen
 * which the user sees first upon clicking on the game.
 * This start screen has the main menu through which
 * the user can choose to play the game, view hgh scores, exit it or view how to play it.
 */
public class StartScreen {

    /**
     * Starts the game by displaying the main menu.
     *
     * @param primaryStage the primary stage of the game
     * @throws IOException in case an error occurs when showing the EndScreen after the "view high scores" button is pressed
     */
    public void startGame(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Frogger");

        MyStage helpScreen = new MyStage();
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
        highScoreButton.setOnAction(actionEvent -> {
            try {
                primaryStage.setScene(endScene);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        VBox vBox = new VBox();
        buttons(vBox, startButton);
        buttons(vBox, helpButton);
        buttons(vBox, exitButton);
        buttons(vBox, highScoreButton);

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

        primaryStage.setScene(startScene);
        primaryStage.show();

    }

    /**
     * Sets the preferred width, height, padding, alignment and spacing of
     * a VBox and its buttons.
     *
     * @param vBox the VBox to set the preferences for
     * @param button a button in the VBox
     */

    public static void buttons(VBox vBox, Button button) {
        vBox.setPrefWidth(340);
        vBox.setPrefHeight(50);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(0,20,10,20));
        vBox.setAlignment(Pos.CENTER);

        button.setMinWidth(vBox.getPrefWidth());
        button.setMinHeight(vBox.getPrefHeight());
    }


}


