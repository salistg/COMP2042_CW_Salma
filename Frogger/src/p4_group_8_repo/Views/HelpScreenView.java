package p4_group_8_repo.Views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import p4_group_8_repo.Controllers.SelectViewFactory;

/**
 * Creates the help screen through which the user
 * can get an idea of how to play the game.
 */
public class HelpScreenView implements GameViews {
    /**
     * A string to hold the file path
     * of the image source.
     */
    private final String imageSource= "file:src/p4_group_8_repo/images/";

    /**
     * Creates the helpScreen that allows
     * the user to see how to play the game.
     *
     * @param stage stage of the application
     * @return scene with help screen as its root
     */
    @Override
    public Scene view(Stage stage) {
        VBox vBox = new VBox();

        BackgroundImage backgroundImage1 = new BackgroundImage(new Image(imageSource + "helpBackground.png",500,600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(backgroundImage1));

        ToggleButton backButton = new ToggleButton("Back");
        vBox.getChildren().add(backButton);
        backButton.setOnAction(event3 -> {
            if(backButton.isSelected()) {
                stage.setScene(new SelectViewFactory().getView("start").view(stage));
            }
        });

        Button pointsSystem = new Button("Next");
        pointsSystem.setOnAction(event -> stage.setScene(pointsSystem(stage)));
        vBox.getChildren().add(pointsSystem);

        return new Scene(vBox, 500, 600);
    }

    /**
     * Creates the scene for the second page of the
     * Help Screen view which contains
     * information about the points system.
     *
     * @param stage stage of the application
     * @return scene with the second page as its root
     */
    private Scene pointsSystem(Stage stage){
        VBox vBox = new VBox();
        BackgroundImage backgroundImage1 = new BackgroundImage(new Image(imageSource + "pointsSystem.png",500,600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(backgroundImage1));

        ToggleButton backButton = new ToggleButton("Back");
        vBox.getChildren().add(backButton);
        backButton.setOnAction(event3 -> {
            if(backButton.isSelected()) {
                stage.setScene(view(stage));
            }
        });

        return new Scene(vBox, 500,600);
    }
}
