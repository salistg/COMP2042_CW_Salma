package p4_group_8_repo.Views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import p4_group_8_repo.Widgets;

/**
 * This class is responsible for displaying the Levels Menu in
 * which the user can select the level they want to play.
 */
public class LevelsMenuView implements GameViews {
    /**
     * Displays the buttons on the levels menu.
     * The user can click on those buttons to choose what level they want to play
     * or to go back to the main menu.
     *
     * @param stage the stage of the application
     * @return the scene which has the buttons in it
     */
    public Scene view(Stage stage) {
        VBox vBox = new VBox();

        BackgroundImage backgroundImage = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/levelsBG.png",500,600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(backgroundImage));


        Button level1Button = new Button("Level 1");
        level1Button.setOnAction(actionEvent -> new GameScreenView(1).setGameScreen(stage));

        Button level2Button = new Button("Level 2");
        level2Button.setOnAction(actionEvent -> new GameScreenView(2).setGameScreen(stage));

        Button level3Button = new Button("Level 3");
        level3Button.setOnAction(actionEvent -> new GameScreenView(3).setGameScreen(stage));

        Button backButton = new Button("Back to Main Menu");
        backButton.setOnAction(actionEvent -> {
            try {
                stage.setScene(new StartScreenView().view(stage));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        vBox.getChildren().addAll(level1Button,level2Button,level3Button,backButton);
        Widgets.vBoxLook(vBox, level1Button);
        Widgets.vBoxLook(vBox,level2Button);
        Widgets.vBoxLook(vBox,level3Button);
        Widgets.vBoxLook(vBox,backButton);

        return new Scene(vBox,500,600);

    }

}
