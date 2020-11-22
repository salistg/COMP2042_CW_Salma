package p4_group_8_repo.Views;

import javafx.css.Style;
import javafx.css.StyleClass;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.ScoresData;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.Assert.*;

public class EndScreenViewTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
    EndScreenView endScreenView;
    Stage stage;

    @Before
    public void setUp() {
        endScreenView = new EndScreenView();
        stage = new Stage();
    }

    @Test
    public void testVBoxAdded(){
        Scene scene = endScreenView.view(stage);
        assertNotNull(scene.getRoot());
        assertEquals(VBox.class, scene.getRoot().getClass());
    }

    @Test
    public void testVBoxHas2Nodes(){
        Scene scene = endScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();

        assertEquals(2, vBox.getChildren().size());
        assertEquals(javafx.scene.control.TableView.class,
                vBox.getChildren().get(0).getClass());
        assertEquals(javafx.scene.control.ToggleButton.class,
                vBox.getChildren().get(1).getClass());
    }

    @Test
    public void testBackButtonAdded(){
        Scene scene = endScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        ToggleButton backButton = (ToggleButton) vBox.getChildren().get(1);
        assertEquals("Back", backButton.getText());
    }

    @Test
    public void testTableViewAdded(){
        Scene scene = endScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        TableView tableView = (TableView) vBox.getChildren().get(0);
        assertEquals(1, tableView.getColumns().size());
    }

    @Test
    public void testTableViewColumn(){
        Scene scene = endScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        TableView tableView = (TableView) vBox.getChildren().get(0);
        TableColumn tableColumn = (TableColumn) tableView.getColumns().get(0);

        assertEquals("-fx-alignment: CENTER", tableColumn.getStyle());
        assertEquals(250, tableColumn.getPrefWidth(),0.0001);
        assertEquals("High Scores", tableColumn.getText());

        assertEquals(TableColumn.SortType.ASCENDING, tableColumn.getSortType());

    }

}