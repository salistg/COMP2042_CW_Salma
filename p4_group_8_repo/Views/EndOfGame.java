package p4_group_8_repo.Views;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import p4_group_8_repo.Controllers.Controllers;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is responsible for what happens at the end of the game.
 * Responsible for displaying the user's high score and the updating the high scores file.
 */

public class EndOfGame implements GameViews {
    /**
     * an ObjectController needed to retrieve and
     * display the score of the
     * player at the end of the game
     */
    private final Controllers controllers;

    /**
     * Instantiates a new EndOfGame object.
     * Sets the ObjectController.
     *
     * @param controllers controller of an actor in the game
     */
    public EndOfGame(Controllers controllers){
        this.controllers = controllers;
    }

    /**
     *  Displays a message with the user's high score,
     *  makes a call to the updateFile method to update the scores file with the user's high score
     *  and changes the scene to display the End Screen View.
     *
     * @param stage the stage of the application
     * @return null as there is no scene needed to display the alert with the user's score
     */

    public Scene view(Stage stage){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Congratulations!");
        alert.setHeaderText("Your High Score: " + controllers.getPoints());
        updateFile(controllers.getPoints());
        alert.show();

        GameViews gameViews = new SelectViewFactory().getView("end",0, null,null,null);
            stage.setScene(gameViews.view(stage));
            stage.show();

        return null;
    }

    /**
     * Updates the scores file
     * at the end of the game with the user's high score.
     *
     * @param points the points earned in the game
     */
    private void updateFile(int points) {
        FileWriter fileWriter = null;
        File file;
        try {
            file = new File("src/p4_group_8_repo/Files/scores.txt");
            if (file.createNewFile())
                System.out.println("File created.");
            else
                System.out.println("File already exists.");

            fileWriter = new FileWriter("src/p4_group_8_repo/Files/scores.txt", true);
            fileWriter.write(Integer.toString(points));
            fileWriter.write("\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                assert fileWriter != null;
                fileWriter.close();
                System.out.println("File closed.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
