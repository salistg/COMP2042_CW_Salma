package p4_group_8_repo;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.stream.Collectors;

public class Widgets {

    /**
     * Sets the preferred width, height, padding, alignment and spacing of
     * a VBox and its buttons.
     *
     * @param vBox the VBox to set the preferences for
     * @param button a button in the VBox
     */

    public static void vBoxLook(VBox vBox, Button button) {
        vBox.setPrefWidth(340);
        vBox.setPrefHeight(50);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(0,20,10,20));
        vBox.setAlignment(Pos.CENTER);

        button.setMinWidth(vBox.getPrefWidth());
        button.setMinHeight(vBox.getPrefHeight());
    }

    public static TableView<ScoresData> getScoresDataTableView() {
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
