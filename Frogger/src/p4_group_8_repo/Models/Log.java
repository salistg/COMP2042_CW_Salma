package p4_group_8_repo.Models;

import javafx.scene.CacheHint;
import javafx.scene.image.Image;
import p4_group_8_repo.Controllers.ActorControllers;

/**
 * Log class that extends the Actor class.
 * This class is responsible for Logs which are a type
 * of objects that facilitate the Animal character's movement.
 */
public class Log extends Actor {
	/**
	 * Variable for the speed of the log.
	 */
	private final double speed;

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
	 * Constructor that instantiates a new Log. </br>
	 * Sets the X and Y coordinates, the speed, the Cache and
	 * the image of the Log object.
	 *
	 * @param imageLink the image link of the Log object
	 * @param dim      the dimensions (width and height) of the Log object's image
	 * @param xpos      the X position of the Log object
	 * @param ypos      the Y position of the Log object
	 * @param s         the speed of the Log object
	 */
	public Log(String imageLink, int dim, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, dim,dim, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;

		setCache(true);
		setCacheHint(CacheHint.SPEED);
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


	/**
	 * {@inheritDoc}
	 *
	 * @return null as this class currently doesn't have a controller class
	 */
	@Override
	public ActorControllers getActorController() {
		return null;
	}
}
