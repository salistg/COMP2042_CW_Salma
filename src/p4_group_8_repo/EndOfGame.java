package p4_group_8_repo;

import javafx.scene.control.Alert;
import javafx.stage.Stage;
import p4_group_8_repo.Controllers.ObjectControllers;
import p4_group_8_repo.Views.GameViews;
import p4_group_8_repo.Views.SelectViewFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is responsible for what happens at the end of the game.
 * Responsible for displaying the user's high score and the updating of the high scores file.
 */

public class EndOfGame {
    //private final AnimalController animal;
    private final ObjectControllers objectControllers;
    private final Stage stage;

    public EndOfGame(Stage stage, ObjectControllers objectControllers){
        this.stage=stage;
       // this.animal=animal;
        this.objectControllers = objectControllers;
    }

    /**
     * Displays a message with the user's high score,
     * makes a call to the UpdateFile method to update the scores file with the user's high score
     * and changes the scene to display the End Screen View.
     */

    public void endDisplay(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Congratulations!");
        alert.setHeaderText("Your High Score: " + objectControllers.getPoints());
        updateFile(objectControllers.getPoints());
        alert.show();

        GameViews gameViews = new SelectViewFactory().getView("end",0, null);
        try {
            stage.setScene(gameViews.view(stage));
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
