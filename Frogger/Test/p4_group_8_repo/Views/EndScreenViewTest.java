package p4_group_8_repo.Views;

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;

import static org.junit.Assert.*;

/**
 * Test for the EndScreenView class. </br>
 * Tests that the EndScreenView class is created correctly
 * with its buttons.
 */
public class EndScreenViewTest {
    /**
     * JavaFX rule to allow for testing of JavaFX applications.
     */
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    /**
     * Creating a EndScreenView object for testing.
     */
    private EndScreenView endScreenView;
    /**
     * Stage object to add the EndScreenView to
     */
    private Stage stage;

    /**
     * Set up before every test. </br>
     * Instantiates the Stage and the EndScreenView objects.
     */
    @Before
    public void setUp() {
        endScreenView = new EndScreenView(1);
        stage = new Stage();
    }

    /**
     * Tests that the VBox has been correctly
     * added to the view.
     */
    @Test
    public void testVBoxAdded(){
        Scene scene = endScreenView.view(stage);
        assertNotNull(scene.getRoot());
        assertEquals(VBox.class, scene.getRoot().getClass());
    }

    /**
     * Tests that the VBox has 2 children one of the type
     * TableView and the other of type ToggleButton.
     */
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

    /**
     * Tests that the toggle button which is the back button
     * is correctly added to the view and has the label "Back".
     */
    @Test
    public void testBackButtonAdded(){
        Scene scene = endScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        ToggleButton backButton = (ToggleButton) vBox.getChildren().get(1);
        assertEquals("Back", backButton.getText());
    }

    /**
     * Tests that the table view which will display the highscores is added to the view.
     */

    @Test
    public void testTableViewAdded(){
        Scene scene = endScreenView.view(stage);
        VBox vBox = (VBox) scene.getRoot();
        TableView tableView = (TableView) vBox.getChildren().get(0);
        assertEquals(1, tableView.getColumns().size());
    }

    /**
     * Tests that the table view's column is correctly set.</br>
     * Tests that it has the correct width, alignment, sort type and heading.
     */
    @Test
    public void testTableViewColumnSettings(){
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