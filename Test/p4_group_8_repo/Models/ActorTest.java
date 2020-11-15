package p4_group_8_repo.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import p4_group_8_repo.Controllers.ObjectControllers;
import p4_group_8_repo.World;

import static org.junit.jupiter.api.Assertions.*;

class ActorTest {
    World world;
    private Actor actor;

    @BeforeEach
    void setUp() {
        world = new World() {
            @Override
            public void act(long now) {

            }
        };
        actor = new Actor() {
            @Override
            public void act(long now) {

            }

            @Override
            public ObjectControllers getObjectController() {
                return null;
            }
        };
        world.add(actor);
    }

    @Test
    void moveTest() {
        actor.move(80,50);
        assertEquals(80,actor.getX());
        assertEquals(50,actor.getY());
    }

    @Test
    void moveNegativeTest(){
        actor.move(-50,-70);
        assertEquals(-50,actor.getX());
        assertEquals(-70,actor.getY());
    }

    @Test
    void moveZeroTest(){
        actor.move(0,0);
        assertEquals(0,actor.getX());
        assertEquals(0,actor.getY());
    }

    @Test
    void getIntersectingObjectsTest() {
        assertEquals(0,actor.getIntersectingObjects(Log.class).size());

    }

    @Test
    void actTest() {
        actor.move(50,60);
        if(actor.getX()>10 && actor.getY()>10)
            actor.setX(40);
        assertEquals(40,actor.getX());
    }

    @Test
    void actIntersectionTest(){
        if(actor.getIntersectingObjects(Obstacle.class).size()==0)
            actor.move(-2,0);
        assertEquals(-2,actor.getX());
        assertEquals(0,actor.getY());
    }
}