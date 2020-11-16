package p4_group_8_repo.Controllers;

import p4_group_8_repo.Models.Actor;

/**
 * An interface for the different Actor controllers.
 */
public interface ObjectControllers {

    /**
     * The main control of the Actor is written in this method.
     *
     * @param now the current timestamp of the frame in nanoseconds
     */
    void mainControl(long now);

    /**
     * Gets the actor of the controller.
     * @return Actor object
     */
    Actor getActor();

    /**
     * Returns whether the game has ended or not.
     *
     * @return true if it ended, false if it hasn't
     */
    boolean gameHasEnded();

    /**
     * Gets the points accumulated by the Actor.
     * @return points accumulated
     */
    int getPoints();

    /**
     * Returns if the score has changed or not.
     *
     * @return true if it has changed, false if it hasn't
     */
    boolean changeScore();
}
