package p4_group_8_repo.Models;

import javafx.scene.CacheHint;
import javafx.scene.image.ImageView;
import p4_group_8_repo.Controllers.ActorControllers;
import p4_group_8_repo.Views.World;

import java.util.ArrayList;

/**
 * An abstract class for all the actors that can be present in the
 * game world, such as: Animal, Logs, Obstacles etc.
 */
public abstract class Actor extends ImageView{

    /**
     * Sets the movement of the actor
     * along the X and Y axis by
     * by changing its X and Y position.
     *
     * @param dx the x position of the actor
     * @param dy the y position of the actor
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);

        setCache(true);
        setCacheHint(CacheHint.SPEED);
    }

    /**
     * Gets the World that a node is currently
     * a part of.
     *
     * @return the world
     */
    private World getWorld() {
        return (World) getParent();
    }

    /**
     * Gets the objects intersecting with
     * another object. For example, objects interacting with an Animal object. </br>
     *
     * For example, to get the size of an array that has the Log objects intersecting
     * with an Animal object:
     * <pre>
     *     Animal animal = new Animal();
     *     System.out.println(animal.getIntersectionObjects(Log.class).size());
     * </pre>
     *
     * @param <A> type parameter, a class that extends the Actor class.
     * @param cls the class of the object
     * @return    an array containing the objects that intersect with another
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }

    /**
     * Abstract method to be inherited by all classes extending the Actor class. </br>
     * Dictates how the objects should act at a certain timeframe or
     * under certain conditions (like intersection with a log or at a death). </br>
     * Allows the objects to perform some action.
     *
     * @param now timestamp of the current frame in nanoseconds
     */
    public abstract void act(long now);

    /**
     * Gets the Actor object's current controller.
     * @return the controller
     */
    public abstract ActorControllers getActorController();

}
