package p4_group_8_repo;

import javafx.application.Application;
import javafx.stage.Stage;

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
	public void start(Stage primaryStage) throws Exception {
		StartScreen startScreen = new StartScreen();
		startScreen.startGame(primaryStage);
	}

}