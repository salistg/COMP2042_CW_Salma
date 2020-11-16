package p4_group_8_repo.Models;

import javafx.scene.image.Image;
import p4_group_8_repo.Controllers.ObjectControllers;
import p4_group_8_repo.Models.Actor;

/**
 * Turtle class that inherits the Actor class.
 * Responsible for Turtle objects that will appear on the game screen
 * and will facilitate the main characters' movement.
 */
public class Turtle extends Actor {
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
	 * Speed of the Turtle object.
	 */
	private final int speed;

	/**
	 * Instantiates a new Turtle.
	 * Sets the image of the turtle, its X and Y positions and its speed.
	 *
	 * @param xpos the X position of the turtle
	 * @param ypos the Y position of the turtle
	 * @param s    the speed of the turtle
	 * @param dim the dimensions (width and height) of the turtle's image
	 */
	public Turtle(int xpos, int ypos, int s, int dim) {
		turtle1 = new Image("file:src/p4_group_8_repo/images/TurtleAnimation1.png", dim, dim, true, true);
		turtle2 = new Image("file:src/p4_group_8_repo/images/TurtleAnimation2.png", dim, dim, true, true);
		turtle3 = new Image("file:src/p4_group_8_repo/images/TurtleAnimation3.png", dim, dim, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}


	/**
	 * {@inheritDoc}
	 * @param now timestamp of the current frame in nanoseconds
	 */
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
				}

		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}

	/**
	 * {@inheritDoc}
	 * @return null as this class currently doesn't have a controller
	 */
	@Override
	public ObjectControllers getObjectController() {
		return null;
	}
}
