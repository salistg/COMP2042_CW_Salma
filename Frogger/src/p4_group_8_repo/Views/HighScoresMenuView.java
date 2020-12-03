package p4_group_8_repo.Views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import p4_group_8_repo.Controllers.SelectViewFactory;

/**
 * Creates a menu that allows the user to select which level's
 * high scores they want to view.
 */
public class HighScoresMenuView implements GameViews {
    /**
     * Displays the view of the high scores menu
     * with all its buttons and its background.
     *
     * @param stage the stage of the application
     * @return the scene which has the menu as its root
     */
    public Scene view(Stage stage) {
        VBox vBox = new VBox();

        String imageSource = "file:src/p4_group_8_repo/images/";
        BackgroundImage backgroundImage = new BackgroundImage(new Image(imageSource + "levelsBG.png",500,600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(backgroundImage));

        menusButtons(stage, vBox);

        return new Scene(vBox,500,600);
    }

    /**
     * Creates the buttons to be displayed on the high scores menu.
     *
     * @param stage Stage of the application
     * @param vBox vBox that will contain the buttons
     */

    private void menusButtons(Stage stage, VBox vBox) {
        Button level1Scores = new Button("Level 1 High Scores");
        level1Scores.setOnAction(actionEvent ->
                stage.setScene(new SelectViewFactory().getView("end",1,null,null).view(stage)) );

        Button level2Scores = new Button("Level 2 High Scores");
        level2Scores.setOnAction(actionEvent ->
                stage.setScene(new SelectViewFactory().getView("end",2,null,null).view(stage)));

        Button level3Scores = new Button("Level 3 High Scores");
        level3Scores.setOnAction(actionEvent ->
                stage.setScene(new SelectViewFactory().getView("end",3,null,null).view(stage)));

        Button level4Scores = new Button("Level 4 High Scores");
        level4Scores.setOnAction(actionEvent ->
                stage.setScene(new SelectViewFactory().getView("end",4,null,null).view(stage)));

        Button level5Scores = new Button("Level 5 High Scores");
        level5Scores.setOnAction(actionEvent ->
                stage.setScene(new SelectViewFactory().getView("end",5,null,null).view(stage)));

        Button backToMenu = new Button("Back to Main Menu");
        backToMenu.setOnAction(actionEvent ->
                stage.setScene(new SelectViewFactory().getView("start").view(stage)));

        vBox.getChildren().addAll(level1Scores,level2Scores,level3Scores,level4Scores,level5Scores,backToMenu);
        vBox.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
    }


}
