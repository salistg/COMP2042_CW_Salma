package p4_group_8_repo.Models;

import javafx.scene.CacheHint;
import javafx.scene.image.Image;
import p4_group_8_repo.Controllers.ActorControllers;

/**
 * Digit class that extends the actor class.
 * Digit is the number that appears on the top of the game screen
 * and shows the current score of the player.
 */
public class Digit extends Actor {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void act(long now) {
	}

	/**
	 * Constructor that instantiates a new Digit. </br>
	 * Sets the X and Y coordinates of the Digit, its Cache as well as the image
	 * corresponding to which number should be shown depending
	 * on the score of the user.
	 *
	 * @param n  the number of the digit
	 * @param dim  dimensions (width and height) of the digit's image
	 * @param x  X coordinate of the digit
	 * @param y  Y coordinate of the digit
	 */
	public Digit(int n, int dim, int x, int y) {
		//image variable for the image of the digit
		String imageSource = "file:src/p4_group_8_repo/images/";
		Image im1 = new Image(imageSource + n + ".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);

		setCache(true);
		setCacheHint(CacheHint.SPEED);
	}

	/**
	 * {@inheritDoc}
	 *
	 */
	@Override
	public ActorControllers getActorController() {
		return null;
	}

	
}
