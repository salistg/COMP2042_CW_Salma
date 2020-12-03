package p4_group_8_repo.Views;


import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;
import p4_group_8_repo.Controllers.SelectViewFactory;
//import org.jetbrains.annotations.NotNull;

/**
 * This class is responsible for displaying the Start Screen
 * which the user sees first upon clicking on the game. </br>
 * This start screen has the main menu through which
 * the user can choose to play the game, view high scores, exit it or view how to play it.
 */
public class StartScreenView implements GameViews {

    /**
     * Starts the game by displaying the main menu.
     *
     * @param stage the primary stage of the game
     * @return the main menu scene
     * */

    public Scene view(Stage stage){
        VBox vBox = createVBox(stage);

        return new Scene(vBox, 500, 600);
    }

    /**
     * Creates a VBox with various buttons in it
     * to be displayed to the user on the screen.
     *
     * @param stage application stage
     * @return returns the vbox with its buttons
     */
    //@NotNull
    private VBox createVBox(Stage stage) {
        final String imageSource= "file:src/p4_group_8_repo/images/";

        Button startButton = new Button("Start Game");
        startButton.setOnAction(actionEvent -> stage.setScene(new SelectViewFactory().getView("levels").view(stage)));

        Button helpButton = new Button("How to Play");
        helpButton.setOnAction(actionEvent -> stage.setScene(new SelectViewFactory().getView("help").view(stage)));

        Button highScoreButton = new Button("High-scores");
        highScoreButton.setOnAction(actionEvent -> stage.setScene(new SelectViewFactory().getView("scores").view(stage)));

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(actionEvent -> System.exit(1));


        VBox vBox = new VBox();
        vBox.setId("startScreenVBox");
        vBox.getChildren().addAll(startButton,helpButton,highScoreButton,exitButton);
        vBox.getStylesheets().add(getClass().getResource("button.css").toExternalForm());


        BackgroundImage backgroundImage2 = new BackgroundImage(new Image(imageSource + "FroggerBG2.png",500,600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(backgroundImage2));

        return vBox;
    }



}


