package p4_group_8_repo;

import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameTitle extends Pane{
    private Text text;

    public GameTitle(String title){
        String space ="";
        for(char a: title.toCharArray()){
            space += a + "";
        }

        text = new Text(space);
        text.setFont(Font.font("Verdana",50));
        text.setFill(Color.WHITE);
        text.setEffect(new DropShadow(30,Color.ALICEBLUE));

        getChildren().addAll(text);
    }

    public double titleWidth(){
        return text.getLayoutBounds().getWidth();
    }

    public double titleHeight(){
        return text.getLayoutBounds().getHeight();
    }



}
