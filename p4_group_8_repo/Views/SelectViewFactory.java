package p4_group_8_repo.Views;

import p4_group_8_repo.Controllers.Controllers;
import p4_group_8_repo.Models.Actor;

/**
 * A view factory that allows for selection of the
 * different Views in the game.
 *
 * This reduces coupling between classes
 * as the caller is not dependent on the class they're calling directly.
 * If any changes occur to the class being called, the changes
 * will only be reflected on the factory class while
 * the caller remains in the unknown about it.
 *
 * Created following the Factory Design Pattern.
 * Allows the subclasses to decide which class to instantiate.
 */
public class SelectViewFactory {
    public GameViews getView(String view, int level, Controllers controllers, Actor actor, World world) {
        return switch (view) {
            case "game" -> new GameScreenView(level, actor, world);
            case "end" -> new EndScreenView();
            case "levels" -> new LevelsMenuView();
            case "start" -> new StartScreenView();
            case "endGame" -> new EndOfGame(controllers);
            case "help" -> new HelpScreenView();
            default -> null;
        };
    }
}
