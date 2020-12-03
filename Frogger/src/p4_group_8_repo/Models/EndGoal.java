package p4_group_8_repo.Models;

import javafx.scene.CacheHint;
import javafx.scene.image.Image;
import p4_group_8_repo.Controllers.ActorControllers;

/**
 * EndGoal class that extends the actor class.
 * Responsible for EndGoal objects which are what
 * the user has to reach to win the game.
 */
public class EndGoal extends Actor{
	/**
	 * Variable to indicate whether the EndGoal object has been activated or not.
	 */
	private boolean activated = false;
	/**
	 * A string to hold the file path
	 * of the image source.
	 */
	private final String imageSource= "file:src/p4_group_8_repo/images/";

	/**
	 * Constructor that instantiates a new EndGoal object. </br>
	 * Sets the X and Y coordinates, the Cache
	 * and the image of the EndGoal object.
	 *
	 * @param x the X coordinate of the object
	 * @param y the Y coordinate of the object
	 */
	public EndGoal(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image(imageSource + "End.png", 60, 60, true, true));

		setCache(true);
		setCacheHint(CacheHint.SPEED);
	}

	/**
	 * Sets the image of the EndGoal object to what it should look like when
	 * it is activated and sets the activated variable that
	 * indicates that the end goal has been reached to true.
	 */
	public void setEnd() {
		setImage(new Image(imageSource + "FrogEnd.png", 70, 70, true, true));
		activated = true;
	}

	/**
	 * Returns the EndGoal object back to its original image and state.
	 */
	public void returnToOriginal(){
		setImage(new Image(imageSource + "End.png", 60, 60, true, true));
		activated=false;
	}

	/**
	 * Returns whether the EndGoal object has been activated or not.
	 *
	 * @return true if activated, false if not
	 */
	public boolean isActivated() {
		return activated;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void act(long now) {
	}

	/**
	 * {@inheritDoc}
	 * @return null as this class currently doesn't have a controller class
	 */
	@Override
	public ActorControllers getActorController() {
		return null;
	}


}
