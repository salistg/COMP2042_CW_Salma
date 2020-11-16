package p4_group_8_repo.Views;

import p4_group_8_repo.Controllers.ObjectControllers;
import p4_group_8_repo.EndOfGame;
import p4_group_8_repo.Models.Actor;
import p4_group_8_repo.MyStage;
import p4_group_8_repo.World;

/**
 * A view factory that allows for selection of the
 * different Views in the game.
 *
 * Created following the Factory Design Pattern.
 * Allows the subclasses to decide which class to instantiate.
 */
public class SelectViewFactory {
    public GameViews getView(String view, int level, ObjectControllers objectControllers, Actor actor, World world) {
        return switch (view) {
            case "game" -> new GameScreenView(level, actor, world);
            case "end" -> new EndScreenView();
            case "levels" -> new LevelsMenuView();
            case "start" -> new StartScreenView();
            case "endGame" -> new EndOfGame(objectControllers);
            default -> null;
        };
    }
}
