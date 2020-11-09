package p4_group_8_repo.Views;


import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;
import p4_group_8_repo.MyStage;
import p4_group_8_repo.Widgets;

/**
 * This class is responsible for displaying the Start Screen
 * which the user sees first upon clicking on the game.
 * This start screen has the main menu through which
 * the user can choose to play the game, view hgh scores, exit it or view how to play it.
 */
public class StartScreenView implements GameViews {
    private Scene helpScene = null;
    private Scene startScene = null;

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
        startButton.setOnAction(actionEvent ->
                stage.setScene(new LevelsMenuView().view(stage)));

        Button helpButton = new Button("How to play the game");
        helpButton.setOnAction(actionEvent -> stage.setScene(helpScene));

        Button exitButton = new Button("Exit game");
        exitButton.setOnAction(actionEvent -> System.exit(1));

        Button highScoreButton = new Button("View High-scores");
        highScoreButton.setOnAction(actionEvent -> {
            try {
                stage.setScene(new EndScreenView().view(stage));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        VBox vBox = new VBox();
        Widgets.vBoxLook(vBox, startButton);
        Widgets.vBoxLook(vBox, helpButton);
        Widgets.vBoxLook(vBox, exitButton);
        Widgets.vBoxLook(vBox, highScoreButton);
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


}


