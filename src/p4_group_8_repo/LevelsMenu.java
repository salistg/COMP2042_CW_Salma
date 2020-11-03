package p4_group_8_repo;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * This class is responsible for displaying the Levels Menu in
 * which the user can select the level they want to play.
 */
public class LevelsMenu {
    private GameScreen gameScreen;
    private StartScreen startScreen;

    /**
     * Displays the buttons on the levels menu.
     * The user can click on those buttons to choose what level they want to play
     * or to go back to the main menu.
     *
     * @param stage the stage of the application
     * @return the scene which has the buttons in it
     */
    public Scene levelsMenu(Stage stage) {
        VBox vBox = new VBox();

        BackgroundImage backgroundImage = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/levelsBG.png",500,600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(backgroundImage));

        gameScreen = new GameScreen(1);

        Button level1Button = new Button("Level 1");
        level1Button.setOnAction(actionEvent -> setGameScreen(stage, 1));

        Button level2Button = new Button("Level 2");
        level2Button.setOnAction(actionEvent -> setGameScreen(stage, 2));

        Button level3Button = new Button("Level 3");
        level3Button.setOnAction(actionEvent -> setGameScreen(stage, 3));

        Button backButton = new Button("Back to Main Menu");
        backButton.setOnAction(actionEvent -> {
            startScreen = new StartScreen();
            try {
                startScreen.startGame(stage);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        vBox.getChildren().addAll(level1Button,level2Button,level3Button,backButton);
        StartScreen.buttons(vBox, level1Button);
        StartScreen.buttons(vBox,level2Button);
        StartScreen.buttons(vBox,level3Button);
        StartScreen.buttons(vBox,backButton);

        return new Scene(vBox,500,600);

    }

    /**
     * Sets the Game Screen according to the level chosen.
     *
     * @param stage     the stage of the application
     * @param level     the level the user chooses to play
     */
    private void setGameScreen(Stage stage, int level) {
        gameScreen.setMusic(true);
        gameScreen.setLevel(level);
        MyStage levelStages = gameScreen.gameScreen(stage);
        Scene scene = new Scene(levelStages, 600, 800);
        levelStages.start();
        stage.setScene(scene);
        stage.show();
    }

}
