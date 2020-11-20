package p4_group_8_repo.Controllers;

import javafx.application.Application;
import javafx.stage.Stage;
import p4_group_8_repo.Views.GameViews;
import p4_group_8_repo.Views.SelectViewFactory;

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
	 */
	@Override
	public void start(Stage primaryStage) {
		GameViews gameView = new SelectViewFactory().getView("start",0,null, null, null);
		primaryStage.setTitle("Frogger");
		primaryStage.setScene(gameView.view(primaryStage));
		primaryStage.show();
	}

}