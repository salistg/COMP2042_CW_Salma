package p4_group_8_repo.Controllers;

import javafx.application.Application;
import javafx.stage.Stage;
import p4_group_8_repo.Views.StartScreenView;

/**
 * Main class that has the main method.
 */
public class Main extends Application {

	/**
	 * Main method. The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * {@inheritDoc}
	 * Starts the game application.
	 *
	 * @param primaryStage the primary stage of the game.
	 * @throws Exception throws an exception as the StartScreen method throws an exception.
	 */
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Frogger");
		primaryStage.setScene(new StartScreenView().view(primaryStage));
		primaryStage.show();
	}

}