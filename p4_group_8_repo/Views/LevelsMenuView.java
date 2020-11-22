package p4_group_8_repo.Views;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import p4_group_8_repo.Models.SelectModelFactory;

/**
 * This class is responsible for displaying the Levels Menu in
 * which the user can select the level they want to play.
 */
public class LevelsMenuView implements GameViews {

    /**
     * Displays the view of the levels menu
     * with all its buttons and its background.
     *
     * @param stage the stage of the application
     * @return the scene which has the view in it
     */
    public Scene view(Stage stage) {
        VBox vBox = new VBox();

        BackgroundImage backgroundImage = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/levelsBG.png",500,600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(backgroundImage));

        menuButtons(stage, vBox);

        return new Scene(vBox,500,600);
    }

    /**
     * Creates the buttons to be displayed on the levels menu.
     *
     * @param stage Stage of the application
     * @param vBox vBox that will contain the buttons
     */

    private void menuButtons(Stage stage, VBox vBox) {
        Button level1Button = new Button("Level 1");
        level1Button.setOnAction(actionEvent -> gameScene(stage,1));

        Button level2Button = new Button("Level 2");
        level2Button.setOnAction(actionEvent -> gameScene(stage,2));

        Button level3Button = new Button("Level 3");
        level3Button.setOnAction(actionEvent -> gameScene(stage,3));

        Button level4Button = new Button("Level 4");
        level4Button.setOnAction(actionEvent -> gameScene(stage,4));

        Button level5Button = new Button("Level 5");
        level5Button.setOnAction(actionEvent -> gameScene(stage,5));

        Button backButton = new Button("Back to Main Menu");
        backButton.setOnAction(actionEvent -> {
            GameViews gameView = new SelectViewFactory().getView("start",0,null,null,null);
            try {
                stage.setScene(gameView.view(stage));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        vBox.getChildren().addAll(level1Button,level2Button,level3Button,level4Button,level5Button,backButton);
        vBoxSettings(vBox, level1Button);
        vBoxSettings(vBox,level2Button);
        vBoxSettings(vBox,level3Button);
        vBoxSettings(vBox,level4Button);
        vBoxSettings(vBox,level5Button);
        vBoxSettings(vBox,backButton);
    }

    /**
     * Sets the preferred width, height, alignment and spacing of
     * a VBox and its buttons.
     *
     * @param vBox VBox object, the VBox to set the preferences for
     * @param button Button object, a button in the VBox
     */

    private void vBoxSettings(VBox vBox, Button button) {
        vBox.setPrefWidth(230);
        vBox.setPrefHeight(55);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        button.setMinWidth(vBox.getPrefWidth());
        button.setMinHeight(vBox.getPrefHeight());
    }

    /**
     * Sets the scene according to the level chosen.
     *
     * @param stage the stage of the application
     */
    private void gameScene(Stage stage, int level) {
        MyStage myStage = new MyStage();
        GameViews gameView = new SelectViewFactory().getView("game", level,null, new SelectModelFactory().getAnimal(), myStage);
        Scene scene = gameView.view(stage);
        stage.setScene(scene);
        stage.show();
    }

}
