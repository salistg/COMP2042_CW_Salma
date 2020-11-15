package p4_group_8_repo.Views;

import p4_group_8_repo.Controllers.ObjectControllers;
import p4_group_8_repo.MyStage;

/**
 * A view factory that allows for selection of the
 * different Views in the game.
 *
 * Created following the Factory Design Pattern.
 * Allows the subclasses to decide which class to instantiate.
 */
public class SelectViewFactory {
    public GameViews getView(String view, int level, ObjectControllers objectControllers) {
        return switch (view) {
            case "game" -> new GameScreenView(level, objectControllers);
            case "end" -> new EndScreenView();
            case "levels" -> new LevelsMenuView();
            case "start" -> new StartScreenView();
            default -> null;
        };
    }
}
