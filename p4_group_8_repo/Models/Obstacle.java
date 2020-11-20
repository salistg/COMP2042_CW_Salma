package p4_group_8_repo.Models;

import javafx.scene.image.Image;
import p4_group_8_repo.Controllers.Controllers;

/**
 * Obstacle class that extends the Actor class.
 * Responsible for the obstacles such as cars or trucks that will be added
 * to the game screen.
 */
public class Obstacle extends Actor {
	/**
	 * Variable for the speed of the obstacle.
	 */
	private final double speed;

	/**
	 * Instantiates a new Obstacle.
	 * Sets the X and Y positions, the image of the obstacle
	 * and the speed.
	 *
	 * @param imageLink the image link of the obstacle
	 * @param xpos      the X position of the obstacle
	 * @param ypos      the Y position of the obstacle
	 * @param s         the speed of the obstacle
	 * @param dim       the dimensions (width and height) of the image of the obstacle
	 */
	public Obstacle(String imageLink, int xpos, int ypos, double s, int dim) {
		setImage(new Image(imageLink, dim,dim, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

    /**
     * {@inheritDoc}
     */
    @Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
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

}
