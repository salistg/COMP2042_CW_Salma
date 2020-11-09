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
import p4_group_8_repo.ScoresData;
import p4_group_8_repo.Widgets;

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
     * This method is responsible for showing the end screen.
     * It is responsible for the details that should be shown on screen when the user reaches the end of the game,
     * such as the table of high scores and a back button.
     *
     * @param stage the stage of the game that will have the scenes in it
     * @return a scene that has the end screen
     */
    public Scene view(Stage stage) {
        TableView<ScoresData> tableView = Widgets.getScoresDataTableView();

        VBox vBox = new VBox(tableView);
        vBox.setAlignment(Pos.CENTER);
        ToggleButton backButton = new ToggleButton("Back");
        vBox.getChildren().add(backButton);
        backButton.setOnAction(event3 -> {
            if(backButton.isSelected()) {
                try {
                    stage.setScene(new StartScreenView().view(stage));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        return new Scene(vBox, 250, 390);

    }


}

