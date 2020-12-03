package p4_group_8_repo.Views;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import p4_group_8_repo.Controllers.SelectViewFactory;

/**
 * This class is responsible for displaying the Levels Menu in
 * which the user can select a level from the 5 levels of the game
 * to play.
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

        String imageSource = "file:src/p4_group_8_repo/images/";
        BackgroundImage backgroundImage = new BackgroundImage(new Image(imageSource + "levelsBG.png",500,600, false, true),
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
            try {
                stage.setScene(new SelectViewFactory().getView("start").view(stage));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        vBox.getChildren().addAll(level1Button,level2Button,level3Button,level4Button,level5Button,backButton);
        vBox.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
    }

    /**
     * Sets the scene according to the level chosen.
     *
     * @param stage the stage of the application
     * @param level level of the game chosen by the user
     */
    private void gameScene(Stage stage, int level) {
        MyStage myStage = new MyStage();
        Scene scene = new SelectViewFactory().getView("game", level,null, myStage).view(stage);
        stage.setScene(scene);
        stage.show();
    }

}
