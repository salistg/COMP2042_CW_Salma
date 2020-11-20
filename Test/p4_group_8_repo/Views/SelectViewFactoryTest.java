package p4_group_8_repo.Views;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.Controllers.AnimalController;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.Models.Animal;

import static org.junit.Assert.*;

public class SelectViewFactoryTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    SelectViewFactory selectViewFactory;

    @Before
    public void setUp()  {
        selectViewFactory = new SelectViewFactory();
    }

    @Test
    public void testGameScreenInitialisation(){
        assertEquals(GameScreenView.class,
                selectViewFactory.getView("game",0,new AnimalController(new Animal()),new Animal(),new MyStage()).getClass() );
    }

    @Test
    public void testEndScreenInitialisation(){
        assertEquals(EndScreenView.class,
                selectViewFactory.getView("end",0,new AnimalController(new Animal()),new Animal(),new MyStage()).getClass() );
    }

    @Test
    public void testLevelsScreenInitialisation(){
        assertEquals(LevelsMenuView.class,
                selectViewFactory.getView("levels",0,new AnimalController(new Animal()),new Animal(),new MyStage()).getClass() );
    }

    @Test
    public void testStartScreenInitialisation(){
        assertEquals(StartScreenView.class,
                selectViewFactory.getView("start",0,new AnimalController(new Animal()),new Animal(),new MyStage()).getClass() );
    }

    @Test
    public void testEndOfGameScreenInitialisation(){
        assertEquals(EndOfGame.class,
                selectViewFactory.getView("endGame",0,new AnimalController(new Animal()),new Animal(),new MyStage()).getClass() );
    }

    @Test
    public void testHelpScreenInitialisation(){
        assertEquals(HelpScreenView.class,
                selectViewFactory.getView("help",0,new AnimalController(new Animal()),new Animal(),new MyStage()).getClass() );
    }

    @Test
    public void testNullScreenInitialisation(){
        assertNull(selectViewFactory.getView("",0,new AnimalController(new Animal()),new Animal(),new MyStage()) );
        assertNull(selectViewFactory.getView("1",0,new AnimalController(new Animal()),new Animal(),new MyStage()) );
        assertNull(selectViewFactory.getView("nothing",0,new AnimalController(new Animal()),new Animal(),new MyStage()) );
    }


}