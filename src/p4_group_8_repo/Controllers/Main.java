package p4_group_8_repo.Controllers;

import javafx.application.Application;
import javafx.stage.Stage;
import p4_group_8_repo.Models.Actor;
import p4_group_8_repo.Models.Animal;
import p4_group_8_repo.MyStage;
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
	 * @throws Exception throws an exception as the StartScreen method throws an exception.
	 */
	@Override
	public void start(Stage primaryStage) {
		//Actor actor = new Animal();
		//MyStage myStage = new MyStage();
		//ObjectControllers objectControllers = new AnimalController(myStage);
		GameViews gameView = new SelectViewFactory().getView("start",0, null);
		primaryStage.setTitle("Frogger");
		primaryStage.setScene(gameView.view(primaryStage));
		primaryStage.show();
	}

}