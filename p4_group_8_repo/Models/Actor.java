package p4_group_8_repo.Models;

import javafx.scene.image.ImageView;
import p4_group_8_repo.Controllers.Controllers;
import p4_group_8_repo.Views.World;

import java.util.ArrayList;

/**
 * Class for all the actors that will be present on the
 * game screen, such as: the frog, the logs, the obstacles etc.
 */
public abstract class Actor extends ImageView{

    /**
     * Sets the movement of the actor
     * by changing its X and Y position.
     *
     * @param dx the x position of the actor
     * @param dy the y position of the actor
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * Gets the World that a node is currently in.
     *
     * @return world object
     */
    private World getWorld() {
        return (World) getParent();
    }

    /**
     * Gets the objects intersecting with
     * another certain object. For example, objects interacting with a Log object.
     *
     * @param <A> type parameter. Type is a class that extends the Actor class.
     * @param cls the class of the object
     * @return    an array containing the objects
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
     * Abstract method to be inherited by all classes extending the World class.
     * Dictates how the objects should act at a certain timeframe or
     * under certain conditions (like intersection with a log or at a death).
     * Allows the objects to perform some action.
     *
     * @param now timestamp of the current frame in nanoseconds
     */
    public abstract void act(long now);

    /**
     * Gets the Actor object's current controller.
     * @return the controller
     */
    public abstract Controllers getObjectController();

}
