package p4_group_8_repo.Controllers;

import javafx.application.Application;
import javafx.stage.Stage;
import p4_group_8_repo.Views.GameViews;

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
	 * Starts the game application by setting the scene
	 * to the StartScreenView that displays the
	 * main menu of the game for the user and enables them
	 * to access the different functionalities of the game.
	 *
	 * @param primaryStage the primary stage of the game.
	 */
	@Override
	public void start(Stage primaryStage) {
		//GameViews gameView = new SelectViewFactory().getView("start");
		primaryStage.setTitle("Frogger");
		primaryStage.setScene(new SelectViewFactory().getView("start").view(primaryStage));
		primaryStage.show();
	}

}