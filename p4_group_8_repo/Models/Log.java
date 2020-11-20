package p4_group_8_repo.Models;

import javafx.scene.image.Image;
import p4_group_8_repo.Controllers.Controllers;

/**
 * Log class that extends from the Actor class.
 * This class is responsible for the Logs which are a type
 * of objects added to the game to facilitate the main character's movement.
 */
public class Log extends Actor {
	/**
	 * Variable for the speed of the log.
	 */
	private final double speed; //speed of the log

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<(-300) && speed<0)
			setX(700);
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
	 * Constructor that instantiates a new Log.
	 * Sets the X and Y coordinates, the speed and
	 * the image of the Log object.
	 *
	 * @param imageLink the image link of the log object
	 * @param size      the size of the image of the log object
	 * @param xpos      the X position of the log object
	 * @param ypos      the Y position of the log object
	 * @param s         the speed of the log object
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

	/**
	 * Gets if the log is moving left.
	 * If the speed is negative, that means the log is doing so.
	 *
	 * @return boolean as to whether speed <0 or not
	 */
	public boolean getLeft() {
		return speed < 0;
	}
}
