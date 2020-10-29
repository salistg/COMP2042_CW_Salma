package p4_group_8_repo;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.util.Pair;
import sample.GameTitle;
import sample.MenuButtons;

import java.util.Arrays;
import java.util.List;

public class Menu {

    private static final int width = 600;
    private static final int height = 800;
    private Pane pane = new Pane();
    private VBox menu = new VBox(-5);

    private List<Pair<String,Runnable>> onMenu = Arrays.asList(
            new Pair<String, Runnable>("Start Game", () -> {}),
            new Pair<String, Runnable>("Help", () -> {}),
            new Pair<String,Runnable>("Exit game", Platform::exit)
    );

    public Parent createFeatures(){
        createBG();
        createTitle();
        createMenu(5,5);

        return pane;

    }

    private void createBG(){
        ImageView imageView = new ImageView(new Image(getClass().getResource("images/iKogsKW.png").toExternalForm()));
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);

        pane.getChildren().add(imageView);
    }

    private void createTitle(){
        GameTitle title = new GameTitle("FROGGER");
        title.setTranslateX(width/2 - title.titleWidth()/2);
        title.setTranslateY(height/3);

        pane.getChildren().add(title);
    }

    private void createMenu(double x, double y){
        menu.setTranslateX(x);
        menu.setTranslateY(y);

        onMenu.forEach(items -> {
            MenuButtons buttons = new MenuButtons(items.getKey());
            buttons.setAction(items.getValue());
            buttons.setTranslateX(-300);

            Rectangle rectangle = new Rectangle(300,30);
            rectangle.translateXProperty().bind(buttons.translateXProperty().negate());

            buttons.setClip(rectangle);
            menu.getChildren().addAll(buttons);

        });

        pane.getChildren().add(menu);
    }

}
