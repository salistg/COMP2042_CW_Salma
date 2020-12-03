package p4_group_8_repo.Controllers;

import p4_group_8_repo.Models.Actor;
import p4_group_8_repo.Views.*;

/**
 * A view factory that allows for selection of the
 * different Views in the game. </br>
 *
 * This reduces coupling between classes
 * as the caller is not dependent on the class they're calling directly. </br>
 * If any changes occur to the class being called, the changes
 * will only be reflected on the factory class while
 * the caller remains in the unknown about it. </br>
 *
 * Created following the Factory Design Pattern. 
 * Allows the subclasses to decide which class to instantiate.
 */
public class SelectViewFactory {
    /**
     * Gets the view that the client class chooses. </br>
     * Instantiates the view based on the choice made. </br> </br>
     *
     * The different views can be selected passing one
     * of the following string parameters: </br>
     * - "game ->     GameScreenView </br>
     * - "end" ->     EndScreenView </br>
     * - "endGame" -> EndOfGame
     *
     * @param view to indicate which view is needed
     * @param level the level of the game chosen by the user
     * @param actorControllers a controller object required to retrieve data (such as scores)
     * @param world the world of the game in which the actors exist
     * @return an instantiation of a GameView object depending on the choice made
     */
    public GameViews getView(String view, int level, ActorControllers actorControllers, World world) {
        return switch (view) {
            case "game" -> new GameScreenView(level, world);
            case "end" -> new EndScreenView(level);
            case "endGame" -> new EndOfGame(actorControllers, level);
            default -> null;

        };
    }

    /**
     * Gets the view that require no parameters
     * based on the client class' choice. </br>
     * Instantiates the view based on the choice made. </br> </br>
     *
     * The different views can be selected passing one
     * of the following string parameters: </br>
     * - "levels -> LevelsMenuView </br>
     * - "start" -> StartMenuView </br>
     * - "scores" -> HighScoresMenuView </br>
     * - "help" -> HelpScreenView
     *
     * @param view to indicate which view is needed
     * @return an instantiation of a GameView object depending on the choice made
     */
    public GameViews getView(String view){
        return switch (view) {
            case "levels" -> new LevelsMenuView();
            case "start" -> new StartScreenView();
            case "scores" -> new HighScoresMenuView();
            case "help" -> new HelpScreenView();
            default -> null;
        };
    }
}
