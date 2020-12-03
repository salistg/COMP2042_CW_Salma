package p4_group_8_repo.Controllers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.Controllers.AnimalController;
import p4_group_8_repo.Controllers.SelectViewFactory;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.Models.Animal;
import p4_group_8_repo.Views.*;

import static org.junit.Assert.*;

/**
 * Test for the SelectViewFactory class
 * to ensure the correct Views are instantiated
 * as per the choice of the caller class.
 */
public class SelectViewFactoryTest {
    /**
     * JavaFX rule to allow for testing of JavaFX applications.
     */
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    /**
     * SelectViewFactory object for testing.
     */
    private SelectViewFactory selectViewFactory;

    /**
     * Set up before every test.
     * Instantiates the SelectViewFactory object.
     */
    @Before
    public void setUp()  {
        selectViewFactory = new SelectViewFactory();
    }

    /**
     * Tests the correct instantiation of the
     * GameScreenView class.
     */
    @Test
    public void testGameScreenInstantiation(){
        assertEquals(GameScreenView.class,
                selectViewFactory.getView("game",0,
                        new AnimalController(new Animal()),new MyStage()).getClass() );
    }

    /**
     * Tests the correct instantiation of the
     * EndScreenView class.
     */
    @Test
    public void testEndScreenInstantiation(){
        assertEquals(EndScreenView.class,
                selectViewFactory.getView("end",0,
                        new AnimalController(new Animal()),new MyStage()).getClass() );
    }

    /**
     * Tests the correct instantiation of the
     * LevelsScreenView class.
     */
    @Test
    public void testLevelsScreenInstantiation(){
        assertEquals(LevelsMenuView.class,
                selectViewFactory.getView("levels").getClass());
    }

    /**
     * Tests the correct instantiation of the
     * StartScreenView class.
     */
    @Test
    public void testStartScreenInstantiation(){
        assertEquals(StartScreenView.class,
                selectViewFactory.getView("start").getClass());
    }

    /**
     * Tests the correct instantiation of the
     * EndOfGame class.
     */
    @Test
    public void testEndOfGameScreenInstantiation(){
        assertEquals(EndOfGame.class,
                selectViewFactory.getView("endGame",0,
                        new AnimalController(new Animal()),new MyStage()).getClass() );
    }

    /**
     * Tests the correct instantiation of the
     * HighScoresMenu class.
     */
    @Test
    public void testHighScoresMenuInstantiation(){
        assertEquals(HighScoresMenuView.class,
                selectViewFactory.getView("scores").getClass());
    }

    /**
     * Tests the correct instantiation of the
     * HelpScreenView class.
     */
    @Test
    public void testHelpScreenInstantiation(){
        assertEquals(HelpScreenView.class,
                selectViewFactory.getView("help").getClass());
    }

    /**
     * Tests that a null value is returned when
     * the wrong input is given for the choice field
     */
    @Test
    public void testNullScreenInstantiation(){
        assertNull(selectViewFactory.getView("",0,
                new AnimalController(new Animal()),new MyStage()) );
        assertNull(selectViewFactory.getView("1",0,
                new AnimalController(new Animal()),new MyStage()) );
        assertNull(selectViewFactory.getView("nothing",0,
                new AnimalController(new Animal()),new MyStage()) );
    }


}