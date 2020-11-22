package p4_group_8_repo.Models;

import javafx.scene.CacheHint;
import javafx.scene.image.Image;
import p4_group_8_repo.Controllers.Controllers;

/**
 * Digit class that extends the actor class.
 * Digit is the number that appears on the top of the game screen
 * and shows the current score of the player.
 */
public class Digit extends Actor {

	/**
	 * {@inheritDoc}
	 * Inherited but not used in this class.
	 */
	@Override
	public void act(long now) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return null as this class currently doesn't have a controller class
	 */
	@Override
	public Controllers getObjectController() {
		return null;
	}

	/**
	 * Constructor that instantiates a new Digit.
	 * Sets the X and Y coordinates of the Digit as well as the image
	 * corresponding to which number should be shown depending
	 * on the score of the user.
	 *
	 * @param n  the number to be shown
	 * @param dim  dimension of the digit
	 * @param x  X coordinate of the digit
	 * @param y  Y coordinate of the digit
	 */
	public Digit(int n, int dim, int x, int y) {
		//image variable for the image of the digit
		Image im1 = new Image("file:src/p4_group_8_repo/images/" + n + ".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);

		setCache(true);
		setCacheHint(CacheHint.SPEED);
	}

	
}
