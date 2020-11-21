package p4_group_8_repo.Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;

import static org.junit.Assert.*;

public class LevelsMenuViewTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
    LevelsMenuView levelsMenuView;
    Stage stage;

    @Before
    public void setUp() throws Exception {
        stage = new Stage();
        levelsMenuView = new LevelsMenuView();
    }

    @Test
    public void testVBoxAdded(){
        Scene scene = levelsMenuView.view(stage);
        assertNotNull(scene.getRoot());
        assertEquals(VBox.class, scene.getRoot().getClass());
    }

    @Test
    public void testVBoxHas6Buttons(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();

        assertEquals(6, vBox.getChildren().size());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(0).getClass());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(1).getClass());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(2).getClass());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(3).getClass());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(4).getClass());
        assertEquals(javafx.scene.control.Button.class,vBox.getChildren().get(5).getClass());
    }

    @Test
    public void testVBoxAlignment(){
//        vBox.setPrefWidth(230);
//        vBox.setPrefHeight(55);
//        vBox.setSpacing(10);
//        vBox.setAlignment(Pos.CENTER);

        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();

        assertEquals(230, vBox.getPrefWidth(),0.0001);
        assertEquals(55,vBox.getPrefHeight(),0.0001);
        assertEquals(10,vBox.getSpacing(),0.0001);
        assertEquals(Pos.CENTER,vBox.getAlignment());
    }

    @Test
    public void testVBoxBackgroundIsSet(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();

        assertNotNull(vBox.getBackground());
        assertFalse(vBox.getBackground().isEmpty());
        assertEquals(1, vBox.getBackground().getImages().toArray().length);
    }

    @Test
    public void testLevel1ButtonAddedWithAction(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level1Button = (Button) vBox.getChildren().get(0);
        assertEquals("Level 1", level1Button.getText());
        assertNotNull(level1Button.getOnAction());
    }

    @Test
    public void testLevel1ButtonPosition(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level2Button = (Button) vBox.getChildren().get(0);
        assertEquals(vBox.getPrefHeight(), level2Button.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), level2Button.getMinWidth(),0.0001);
    }

    @Test
    public void testLevel2ButtonAddedWithAction(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level2Button = (Button) vBox.getChildren().get(1);
        assertEquals("Level 2", level2Button.getText());
        assertNotNull(level2Button.getOnAction());
    }

    @Test
    public void testLevel2ButtonPosition(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level3Button = (Button) vBox.getChildren().get(1);
        assertEquals(vBox.getPrefHeight(), level3Button.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), level3Button.getMinWidth(),0.0001);
    }

    @Test
    public void testLevel3ButtonAddedWithAction(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level3Button = (Button) vBox.getChildren().get(2);
        assertEquals("Level 3", level3Button.getText());
        assertNotNull(level3Button.getOnAction());
    }

    @Test
    public void testLevel3ButtonPosition(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level3Button = (Button) vBox.getChildren().get(2);
        assertEquals(vBox.getPrefHeight(), level3Button.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), level3Button.getMinWidth(),0.0001);
    }

    @Test
    public void testLevel4ButtonAddedWithAction(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level4Button = (Button) vBox.getChildren().get(3);
        assertEquals("Level 4", level4Button.getText());
        assertNotNull(level4Button.getOnAction());
    }

    @Test
    public void testLevel4ButtonPosition(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level4Button = (Button) vBox.getChildren().get(3);
        assertEquals(vBox.getPrefHeight(), level4Button.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), level4Button.getMinWidth(),0.0001);
    }

    @Test
    public void testLevel5ButtonAddedWithAction(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level5Button = (Button) vBox.getChildren().get(4);
        assertEquals("Level 5", level5Button.getText());
        assertNotNull(level5Button.getOnAction());
    }

    @Test
    public void testLevel5ButtonPosition(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button level5Button = (Button) vBox.getChildren().get(4);
        assertEquals(vBox.getPrefHeight(), level5Button.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), level5Button.getMinWidth(),0.0001);
    }

    @Test
    public void testBackButtonAddedWithAction(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button backButton = (Button) vBox.getChildren().get(5);
        assertEquals("Back to Main Menu", backButton.getText());
        assertNotNull(backButton.getOnAction());
    }

    @Test
    public void testBackButtonPosition(){
        Scene scene = levelsMenuView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        Button backButton = (Button) vBox.getChildren().get(5);
        assertEquals(vBox.getPrefHeight(), backButton.getMinHeight(), 0.0001);
        assertEquals(vBox.getPrefWidth(), backButton.getMinWidth(),0.0001);
    }
}