package p4_group_8_repo.Views;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;
import p4_group_8_repo.MyStage;

/**
 * This class is responsible for displaying the Start Screen
 * which the user sees first upon clicking on the game.
 * This start screen has the main menu through which
 * the user can choose to play the game, view hgh scores, exit it or view how to play it.
 */
public class StartScreenView implements GameViews {
    private Scene helpScene = null;
    private Scene startScene = null;
//    private GameViews gameView = null;
//    private GameViews gameView2 = null;

    /**
     * Starts the game by displaying the main menu.
     *
     * @param stage the primary stage of the game
     * @return the main menu scene
     * */

    public Scene view(Stage stage){

        MyStage helpScreen = new MyStage();
        helpScene = new Scene(helpScreen,500,600);

        BackgroundImage backgroundImage1 = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/helpBackground.png",500,600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        helpScreen.setBackground(new Background(backgroundImage1));


        Button startButton = new Button("Start game");
        GameViews gameView = new SelectViewFactory().getView("levels",0, null);
        startButton.setOnAction(actionEvent -> stage.setScene(gameView.view(stage)));

        Button helpButton = new Button("How to play the game");
        helpButton.setOnAction(actionEvent -> stage.setScene(helpScene));

        Button exitButton = new Button("Exit game");
        exitButton.setOnAction(actionEvent -> System.exit(1));

        Button highScoreButton = new Button("View High-scores");
        GameViews gameView2 = new SelectViewFactory().getView("end",0, null);
        highScoreButton.setOnAction(actionEvent -> {
            try {
                stage.setScene(gameView2.view(stage));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        VBox vBox = new VBox();
        vBoxLook(vBox, startButton);
        vBoxLook(vBox, helpButton);
        vBoxLook(vBox, exitButton);
        vBoxLook(vBox, highScoreButton);
        vBox.getChildren().addAll(startButton,helpButton,highScoreButton,exitButton);

        startScene = new Scene(vBox,500,600);

        BackgroundImage backgroundImage2 = new BackgroundImage(new Image("file:src/p4_group_8_repo/images/FroggerBG2.png",500,600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(backgroundImage2));


        ToggleButton backButton = new ToggleButton("Back");
        helpScreen.getChildren().add(backButton);
        backButton.setOnAction(event3 -> {
            if(backButton.isSelected())
                stage.setScene(startScene);
        });

        return startScene;
    }

    /**
     * Sets the preferred width, height, padding, alignment and spacing of
     * a VBox and its buttons.
     *
     * @param vBox the VBox to set the preferences for
     * @param button a button in the VBox
     */

    private void vBoxLook(VBox vBox, Button button) {
        vBox.setPrefWidth(340);
        vBox.setPrefHeight(50);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(0,20,10,20));
        vBox.setAlignment(Pos.CENTER);

        button.setMinWidth(vBox.getPrefWidth());
        button.setMinHeight(vBox.getPrefHeight());
    }


}


