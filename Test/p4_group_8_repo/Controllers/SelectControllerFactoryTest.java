package p4_group_8_repo.Controllers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.Models.Animal;

import static org.junit.Assert.*;

public class SelectControllerFactoryTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
    SelectControllerFactory selectControllerFactory;

    @Before
    public void setUp() {
        selectControllerFactory = new SelectControllerFactory();
    }

    @Test
    public void testCreationOfAnimalController(){
        selectControllerFactory.getController(1, new Animal());
        assertEquals(AnimalController.class, selectControllerFactory.getController(1, new Animal()).getClass());
    }

    @Test
    public void testCreationOfAnimalMovementController(){
        assertEquals(AnimalMovementController.class, selectControllerFactory.getController(2, new Animal()).getClass());
    }

    @Test
    public void testNull(){
        assertNull(selectControllerFactory.getController(3,new Animal()));
        assertNull(selectControllerFactory.getController(0,new Animal()));
        assertNull(selectControllerFactory.getController(-1,new Animal()));
    }
}