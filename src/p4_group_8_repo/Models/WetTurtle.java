package p4_group_8_repo.Models;

import javafx.scene.CacheHint;
import javafx.scene.image.Image;
import p4_group_8_repo.Controllers.ActorControllers;

/**
 * Wet turtle class that extends the Actor class.
 * Responsible for Wet Turtle objects that
 * facilitate the Animal character's movement
 * or lead to its death when sunk.
 */
public class WetTurtle extends Actor {
	/**
	 * Image object to set an image of the turtle.
	 */
	private final Image turtle1;
	/**
	 * Image object to set an image of the turtle.
	 */
	private final Image turtle2;
	/**
	 * Image object to set an image of the turtle.
	 */
	private final Image turtle3;
	/**
	 * Image object to set an image of the turtle.
	 */
	private final Image turtle4;
	/**
	 * Variable for the speed of the WetTurtle object.
	 */
	private final int speed;
	/**
	 * Variable to indicate if the WetTurtle has sunk or not.
	 */
	private boolean sunk = false;

	/**
	 * Instantiates a new WetTurtle object. </br>
	 * Sets the image of the wet turtle, the cache
	 * the X and Y position and the speed.
	 *
	 * @param xpos the X position of the turtle.
	 * @param ypos the Y position of the turtle.
	 * @param s    the speed of the turtle.
	 * @param dim the dimensions (width and height) of the turtle
	 */
	public WetTurtle(int xpos, int ypos, int s, int dim) {
		String imageSource = "file:src/p4_group_8_repo/images/";
		turtle1 = new Image(imageSource + "TurtleAnimation1.png", dim, dim, true, true);
		turtle2 = new Image(imageSource + "TurtleAnimation2Wet.png", dim, dim, true, true);
		turtle3 = new Image(imageSource +"TurtleAnimation3Wet.png", dim, dim, true, true);
		turtle4 = new Image(imageSource + "TurtleAnimation4Wet.png", dim, dim, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);

		setCache(true);
		setCacheHint(CacheHint.SPEED);
	}

	/**
	 * {@inheritDoc}
	 * @param now timestamp of the current frame in nanoseconds
	 */
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}

		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}

	/**
	 * Returns whether the wet turtle is sunk or not.
	 *
	 * @return boolean: true if turtle is sunk, false if not
	 */
	public boolean isSunk() {
		return sunk;
	}

	/**
	 * {@inheritDoc}
	 * @return null as this class currently doesn't have a controller
	 */
	@Override
	public ActorControllers getActorController() {
		return null;
	}
}
