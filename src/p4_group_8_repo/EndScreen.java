package p4_group_8_repo;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.*;
import java.nio.file.Files;
import java.util.Collection;
import java.util.stream.Collectors;


/**
 * Class for the End screen.
 * This class is responsible for displaying the end screen
 * at the end of the game.
 */
public class EndScreen {

    /**
     * This method is responsible for showing the end screen.
     * It is responsible for the details that should be shown on screen when the user reaches the end of the game,
     * such as the table of high scores and a back button.
     *
     * @param stage the stage of the game that will have the scenes in it
     * @return a scene that has the end screen
     * @throws IOException in case an error occurs when trying to read the scores file
     */
    public Scene start(Stage stage) throws IOException {
        Collection<ScoresData> list = Files.readAllLines(new File("src/p4_group_8_repo/Files/scores.txt").toPath()).stream().map(
                line -> {
                    String[] details = line.split("\n");
                    ScoresData scoresData = new ScoresData();
                    scoresData.setScores(details[0]);
                    return scoresData;
                }
        ).collect(Collectors.toList());

        ObservableList<ScoresData> details = FXCollections.observableArrayList(list);
        TableView<ScoresData> tableView = new TableView<>();
        TableColumn<ScoresData, String> col2 = new TableColumn<>("High Scores");
        col2.setPrefWidth(250);
        col2.setStyle("-fx-alignment: CENTER");
        col2.setCellValueFactory(data -> data.getValue().scoreProperty());

        tableView.getColumns().addAll(col2);


        Callback<ScoresData,Observable[]> callback = (ScoresData scoresData) -> new Observable[]{
                scoresData.scoreProperty(),
        };

        ObservableList<ScoresData> observableList = FXCollections.observableArrayList(callback);
        observableList.addAll(details);

        SortedList<ScoresData> sortedList = new SortedList<>(observableList,
                (ScoresData scores1, ScoresData scores2) ->
                        Integer.compare(Integer.parseInt(scores2.getScores()),
                                Integer.parseInt(scores1.getScores())));


        tableView.setItems(sortedList);

        StartScreen startScreen = new StartScreen();
        VBox vBox = new VBox(tableView);
        vBox.setAlignment(Pos.CENTER);
        ToggleButton backButton = new ToggleButton("Back");
        vBox.getChildren().add(backButton);
        backButton.setOnAction(event3 -> {
            if(backButton.isSelected()) {
                try {
                    startScreen.startGame(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        return new Scene(vBox, 250, 390);

    }

    /**
     * This method is responsible for updating the scores file
     * at the end of the game with the users high score.
     *
     * @param points the points earned in the game
     */
    void updateFile(int points) {
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

    /**
     * This method is responsible for what happens when the user finishes the game.
     * It displays a message with the user's high score,
     * makes a call to the UpdateFile method to update the scores file with the user's high score
     * and changes the scene to display the End Screen.
     *
     * @param stage   the stage of the application
     * @param myStage the MyStage object that will have end screen scene in it
     * @param animal  the Animal object that the user plays with in the game
     */

    void endDisplay(Stage stage, Animal animal, MyStage myStage){
        EndScreen endScreen = new EndScreen();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Congratulations!");
        alert.setHeaderText("Your High Score: " + animal.getPoints());
        endScreen.updateFile(animal.getPoints());
        alert.show();

        try {
            Scene endScene = endScreen.start(stage);
            stage.setScene(endScene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }




}

