package p4_group_8_repo.Views;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * An interface for all the different views in the game.
 */
public interface GameViews {
    /**
     * Method to be implemented by all classes implementing the interface.
     * Dictates what the view should look like.
     *
     * @param stage stage of the application
     * @return a Scene to display the view
     */
    Scene view(Stage stage);

}
