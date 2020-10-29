package p4_group_8_repo;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.*;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;



public class EndScreen {
    public Scene start(Stage stage) throws Exception {
        Collection<ScoresData> list = Files.readAllLines(new File("src/p4_group_8_repo/Files/scores.txt").toPath()).stream().map(
                line -> {
                    String[] details = line.split("\n");
                    ScoresData scoresData = new ScoresData();
                    scoresData.setNumber(details[0]);
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

        SortedList<ScoresData> sortedList = new SortedList<ScoresData>(observableList,
                (ScoresData scores1, ScoresData scores2) ->{
            if(Integer.valueOf(scores1.getScores()) > Integer.valueOf(scores2.getScores()))
                return -1;
            else if(Integer.valueOf(scores1.getScores()) < Integer.valueOf(scores2.getScores()))
                return 1;
            else
                return 0;
                });


        tableView.setItems(sortedList);

        Start start = new Start();
        VBox vBox = new VBox(tableView);
        vBox.setAlignment(Pos.CENTER);
        ToggleButton backButton = new ToggleButton("Back");
        vBox.getChildren().add(backButton);
        backButton.setOnAction(event3 -> {
            if(backButton.isSelected()) {
                try {
                    start.startGame(stage, false,1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        Scene endScene = new Scene(vBox, 250, 390);

        return endScene;

    }


}

