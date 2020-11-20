package p4_group_8_repo.Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.Models.Actor;
import p4_group_8_repo.Models.Animal;
import p4_group_8_repo.Models.SelectModelFactory;

import java.awt.*;
import java.util.Arrays;

import static org.junit.Assert.*;

public class StartScreenViewTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
    StartScreenView startScreenView;
    Stage stage;

    @Before
    public void setUp(){
        stage = new Stage();
        startScreenView = new StartScreenView();
    }

    @Test
    public void testVBoxAdded(){
        Scene scene = startScreenView.view(stage);
        assertNotNull(scene.getRoot());
        assertEquals(VBox.class, scene.getRoot().getClass());
    }

    @Test
    public void testVBoxHas4Buttons(){
        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();

        assertEquals(4, vBox.getChildren().size());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(0).getClass());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(1).getClass());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(2).getClass());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(3).getClass());
    }

    @Test
    public void testVBoxAlignment(){
//        vBox.setPrefWidth(340);
//        vBox.setPrefHeight(50);
//        vBox.setSpacing(10);
//        vBox.setPadding(new Insets(0,20,10,20));
//        vBox.setAlignment(Pos.CENTER);

        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Insets insets = new Insets(0,20,10,20);

        assertEquals(340, vBox.getPrefWidth(),0.0001);
        assertEquals(50,vBox.getPrefHeight(),0.0001);
        assertEquals(10,vBox.getSpacing(),0.0001);
        assertEquals(Pos.CENTER,vBox.getAlignment());
        assertEquals(insets,vBox.getPadding());
    }

    @Test
    public void testStartButtonAdded(){
//        javafx.scene.control.Button button = (Button) vBox.getChildren().get(0);
//        assertEquals("Back", button.getText());

        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button startButton = (Button) vBox.getChildren().get(0);
        assertEquals("Start Game", startButton.getText());
    }

//    @Test
//    public void getOnStartButtonClick(){
////        GameViews gameView = new SelectViewFactory().getView("levels",0,null,null,null);
////        startButton.setOnAction(actionEvent -> stage.setScene(gameView.view(stage)));
//
//        Scene scene = startScreenView.view(stage);
//        VBox vBox = (VBox) scene.getRoot();
//        Button startButton = (Button) vBox.getChildren().get(0);
//
//        GameViews gameView = new SelectViewFactory().getView("levels",0,null,null,null);
//        Button testButton = new Button();
//        testButton.setOnAction(actionEvent -> stage.setScene(gameView.view(stage)));
//
//        assertEquals(testButton.getOnAction(), startButton.getOnAction());
//    }

    @Test
    public void testStartButtonPosition(){
        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button startButton = (Button) vBox.getChildren().get(0);
        assertEquals(vBox.getPrefHeight(), startButton.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), startButton.getMinWidth(),0.0001);
    }


    @Test
    public void testHelpButtonAdded(){
        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button helpButton = (Button) vBox.getChildren().get(1);
        assertEquals("How to Play", helpButton.getText());
    }

    @Test
    public void testHelpButtonPosition(){
        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button helpButton = (Button) vBox.getChildren().get(1);
        assertEquals(vBox.getPrefHeight(), helpButton.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), helpButton.getMinWidth(),0.0001);
    }

    @Test
    public void testExitButtonAdded(){
        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button highScoreButton = (Button) vBox.getChildren().get(2);
        assertEquals("High-scores", highScoreButton.getText());
    }

    @Test
    public void testExitButtonPosition(){
        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button exitButton = (Button) vBox.getChildren().get(2);
        assertEquals(vBox.getPrefHeight(), exitButton.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), exitButton.getMinWidth(),0.0001);
    }


    @Test
    public void testHigScoreButtonAdded(){
        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button exitButton = (Button) vBox.getChildren().get(3);
        assertEquals("Exit", exitButton.getText());
    }

    @Test
    public void testHighButtonPosition(){
        Scene scene = startScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button highScoreButton = (Button) vBox.getChildren().get(3);
        assertEquals(vBox.getPrefHeight(), highScoreButton.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), highScoreButton.getMinWidth(),0.0001);
    }
}