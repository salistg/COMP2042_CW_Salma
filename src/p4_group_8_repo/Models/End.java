package p4_group_8_repo.Models;

import javafx.scene.image.Image;

/**
 * End class that extends the actor class.
 * Responsible for the end objects which are the burrows
 * the user has to reach to win the game.
 */
public class End extends Actor{
	private boolean activated = false; //variable to indicate whether the burrow has been activated or not

	/**
	 * Constructor that instantiates a new End object.
	 * Sets the X and Y coordinates as well as the image of the End object.
	 *
	 * @param x the X coordinate of the object
	 * @param y the Y coordinate of the object
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/p4_group_8_repo/images/End.png", 60, 60, true, true));
	}

	/**
	 * {@inheritDoc}
	 * Inherited but not used in this class.
	 */
	@Override
	public void act(long now) {
	}

	/**
	 * Sets the image of End object to what the burrow should look like when
	 * it is activated and sets the activated variable that
	 * indicates that the burrow has been reached and is activated.
	 */
	public void setEnd() {
		setImage(new Image("file:src/p4_group_8_repo/images/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}

	/**
	 * This method returns whether the End object has been activated or not.
	 *
	 * @return true if activated, false if not
	 */
	public boolean isActivated() {
		return activated;
	}
	

}
