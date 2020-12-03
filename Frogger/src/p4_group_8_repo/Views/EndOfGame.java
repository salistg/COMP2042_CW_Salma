package p4_group_8_repo.Views;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
//import org.jetbrains.annotations.NotNull;
import p4_group_8_repo.Controllers.ActorControllers;
import p4_group_8_repo.Controllers.SelectViewFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is responsible for what happens at the end of the game. </br>
 * Responsible for displaying a message with the
 * user's high score at the end of the game
 * and updating the high scores file
 * with the user's high score.
 */

public class EndOfGame implements GameViews {
    /**
     * A Controller needed to retrieve and
     * display the score of the
     * player at the end of the game.
     */
    private final ActorControllers actorControllers;
    /**
     * Level of the game chosen by the user.
     */
    private final int level;

    /**
     * Instantiates a new EndOfGame object.
     * Sets the Controller.
     *
     * @param actorControllers controller of an actor in the game
     * @param level the level of the game chosen by the user
     */
    public EndOfGame(ActorControllers actorControllers, int level){
        this.actorControllers = actorControllers;
        this.level=level;
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
        alert.setHeaderText("Your High Score: " + actorControllers.getPoints());
        updateFile(actorControllers.getPoints());
        alert.show();

            stage.setScene(new SelectViewFactory().getView("end",level,null,null).view(stage));
            stage.show();

        return null;
    }

    /**
     * Updates the score files corresponding to the level played
     * at the end of the game with the user's high score
     * in that level.
     *
     * @param points the points earned in the game
     */
    private void updateFile(int points) {
        final String fileSource = setFileSource();

        FileWriter fileWriter = null;
        File file;
        try {
            file = new File(fileSource);
            if (file.createNewFile())
                System.out.println("File created.");
            else
                System.out.println("File already exists.");

            fileWriter = new FileWriter(fileSource, true);
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

    /**
     * Gets the path of the source file to which
     * the scores are written.
     *
     * @return file path
     */
    //@NotNull
    private String setFileSource() {
        final String fileSource;
        if(level==1)
            fileSource = "src/p4_group_8_repo/Files/scores.txt";
        else if(level==2)
            fileSource = "src/p4_group_8_repo/Files/scores2.txt";
        else if(level==3)
            fileSource = "src/p4_group_8_repo/Files/scores3.txt";
        else if(level==4)
            fileSource = "src/p4_group_8_repo/Files/scores4.txt";
        else if(level==5)
            fileSource = "src/p4_group_8_repo/Files/scores5.txt";
        else
            fileSource = "src/p4_group_8_repo/Files/scoresMisc.txt";
        return fileSource;
    }
}
