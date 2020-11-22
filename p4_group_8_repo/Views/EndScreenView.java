package p4_group_8_repo.Views;

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
import org.jetbrains.annotations.NotNull;
import p4_group_8_repo.ScoresData;
import java.io.*;
import java.nio.file.Files;
import java.util.Collection;
import java.util.stream.Collectors;


/**
 * Class for the End screen.
 * This class is responsible for displaying the end screen
 * at the end of the game.
 */
public class EndScreenView implements GameViews {

    /**
     * Shows the end screen at the end of the game.
     * Displays the table of high scores.
     *
     * @param stage the stage of the application
     * @return a scene that has the end screen
     */
    public Scene view(Stage stage) {
        VBox vBox = createVBox(stage);
        return new Scene(vBox, 250, 390);

    }

    /**
     * Creates the VBox that will contain the tableview
     * and the buttons of the end screen.
     *
     * @param stage current stage of the application
     * @return a VBox containing the buttons and tableview
     */
    @NotNull
    private VBox createVBox(Stage stage) {
        TableView<ScoresData> tableView = getScoresDataTableView();

        VBox vBox = new VBox(tableView);
        vBox.setAlignment(Pos.CENTER);

        ToggleButton backButton = new ToggleButton("Back");
        vBox.getChildren().add(backButton);
        GameViews gameView = new SelectViewFactory().getView("start",0,null,null,null);
        backButton.setOnAction(event3 -> {
            if(backButton.isSelected()) {
                try {
                    stage.setScene(gameView.view(stage));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return vBox;
    }

    /**
     * Generates the TableView that will display the high scores of the players.
     * Updated as the users play the game and arranges the
     * scores in ascending order (from highest to lowest).
     *
     * @return TableView of type ScoresData (Scores of the users of the game)
     */
    private TableView<ScoresData> getScoresDataTableView() {
        Collection<ScoresData> list = null;
        try {
            list = Files.readAllLines(new File("src/p4_group_8_repo/Files/scores.txt").toPath()).stream().map(
                    line -> {
                        String[] details = line.split("\n");
                        ScoresData scoresData = new ScoresData();
                        scoresData.setScores(details[0]);
                        return scoresData;
                    }
            ).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObservableList<ScoresData> details = FXCollections.observableArrayList(list);

        TableView<ScoresData> tableView = new TableView<>();
        TableColumn<ScoresData, String> col2 = new TableColumn<>("High Scores");
        col2.setPrefWidth(250);
        col2.setStyle("-fx-alignment: CENTER");
        col2.setCellValueFactory(data -> data.getValue().scoreProperty());

        tableView.getColumns().addAll(col2);


        Callback<ScoresData, Observable[]> callback = (ScoresData scoresData) -> new Observable[]{
                scoresData.scoreProperty(),
        };

        ObservableList<ScoresData> observableList = FXCollections.observableArrayList(callback);
        observableList.addAll(details);

        SortedList<ScoresData> sortedList = new SortedList<>(observableList,
                (ScoresData scores1, ScoresData scores2) ->
                        Integer.compare(Integer.parseInt(scores2.getScores()),
                                Integer.parseInt(scores1.getScores())));

        tableView.setItems(sortedList);

        return tableView;
    }


}

