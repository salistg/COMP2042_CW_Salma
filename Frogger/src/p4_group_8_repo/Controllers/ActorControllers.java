package p4_group_8_repo.Controllers;

/**
 * An interface for the different controllers.
 */
public interface ActorControllers {

    /**
     * The main control of the controller
     * is written in this method.
     *
     * @param now the current timestamp of the frame in nanoseconds
     */
    void mainControl(long now);

    /**
     * Returns whether the game has ended or not.
     *
     * @return true if it ended, false if it hasn't
     */
    boolean hasGameEnded();

    /**
     * Gets the points accumulated
     * as the game is played.
     *
     * @return points accumulated
     */
    int getPoints();

    /**
     * Returns if the score of the game
     * has changed or not.
     *
     * @return true if it has changed, false if it hasn't
     */
    boolean changeScore();
}
