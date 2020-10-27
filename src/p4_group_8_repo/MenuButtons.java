package p4_group_8_repo;

import javafx.beans.binding.Bindings;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MenuButtons extends Pane {
    private Text text;
    private Effect shadow = new DropShadow(10, Color.BLACK);
    private Effect blur = new BoxBlur(1,1,3);

    public MenuButtons(String name){
        Rectangle rectangle = new Rectangle();
        rectangle.setStroke(Color.color(1,1,1,0.75));
        rectangle.setEffect(new GaussianBlur());

        rectangle.fillProperty().bind(Bindings.when(pressedProperty()).then(Color.color(0,0,0,0.75)).otherwise(Color.color(0,0,0,0.25)));

        text = new Text(name);
        text.setTranslateX(5);
        text.setTranslateY(20);
        text.setFont(Font.font("Verdana"));
        text.setFill(Color.WHITE);

        text.effectProperty().bind(
                Bindings.when(hoverProperty())
                        .then(shadow)
                        .otherwise(blur)
        );

        getChildren().addAll(rectangle,text);

    }

    public void setAction(Runnable action){
        setOnMouseClicked(e -> action.run());
    }
}
