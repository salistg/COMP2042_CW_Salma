package p4_group_8_repo;

import javafx.scene.control.Alert;
import javafx.stage.Stage;
import p4_group_8_repo.Controllers.AnimalController;
import p4_group_8_repo.Views.EndScreenView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EndOfGame {

    /**
     * This method is responsible for what happens when the user finishes the game.
     * It displays a message with the user's high score,
     * makes a call to the UpdateFile method to update the scores file with the user's high score
     * and changes the scene to display the End Screen.
     *  @param stage   the stage of the application
     * @param animal  the Animal object that the user plays with in the game
     */

    public void endDisplay(Stage stage, AnimalController animal){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Congratulations!");
        alert.setHeaderText("Your High Score: " + animal.getPoints());
        updateFile(animal.getPoints());
        alert.show();

        try {
            stage.setScene(new EndScreenView().view(stage));
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is responsible for updating the scores file
     * at the end of the game with the users high score.
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
