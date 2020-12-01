package p4_group_8_repo.Views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import p4_group_8_repo.Controllers.DigitAnimation;
import p4_group_8_repo.Controllers.LevelsController;
import p4_group_8_repo.Controllers.SelectModelFactory;
import p4_group_8_repo.Controllers.SelectViewFactory;
import p4_group_8_repo.Models.*;

/**
 * This class is responsible for displaying the game screen view
 * on which the user play the game. </br>
 */
public class GameScreenView implements GameViews{
    /**
     * The World that currently has all the game's actors in it
     */
   private final World background;
    /**
     * the main playable actor in the game
     */
   private final Actor animal;
    /**
     * the level of the game
     */
   private final int level;

    /**
     * Constructor that instantiates a new Game screen.
     * Sets the level, the main actor and the world.
     *
     * @param level the level of the game
     * @param background the world of the game in which the actors exist
     */
    public GameScreenView(int level, World background){
        this.level=level;
        this.background=background;
        animal = new SelectModelFactory().getAnimal();
    }

    /**
     * Displays the game screen and calls the start method of the stage
     * so the animation can start.
     *
     * @param stage the stage of the game application.
     * @return Scene object that will display the game screen
     */
    public Scene view(Stage stage){
        LevelsController levelsController = new LevelsController(level,background);

        createBackButton(stage);
        levelsController.levels();
        background.add(animal);
        musicButton();

        DigitAnimation digitAnimation = new DigitAnimation(stage, background, animal.getActorController(), level);
        digitAnimation.start();
        background.start();

        return new Scene(background, 600,750);
    }

    /**
     * Creates a back button that allows
     * the user to go back to the levels menu
     * from the game screen.
     *
     * @param stage stage of the application
     */
    private void createBackButton(Stage stage) {
        VBox vBox = new VBox();
        vBox.setLayoutX(559);
        vBox.setAlignment(Pos.TOP_RIGHT);

        Button backButton = new Button("Back");
        backButton.setOnAction(event3 -> {
            try {
                background.stopMusic();
                stage.setScene(new SelectViewFactory().getView("levels").view(stage));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        vBox.getChildren().add(backButton);
        background.getChildren().add(vBox);
    }

    /**
     * Creates a music button on the screen that
     * allows the user to turn the music on/off.
     */
    private void musicButton() {
        ToggleButton musicButton = new ToggleButton();
        musicButton.getStylesheets().add(this.getClass().getResource("button.css").toExternalForm());

        background.getChildren().add(musicButton);
        musicButton.setOnAction(event -> {
            if (musicButton.isSelected())
                background.stopMusic();
            else
                background.playMusic();
        });
    }

}
