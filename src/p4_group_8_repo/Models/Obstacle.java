package p4_group_8_repo.Models;

import javafx.scene.image.Image;
import p4_group_8_repo.Controllers.ObjectControllers;
import p4_group_8_repo.Models.Actor;

/**
 * Obstacle class that extends the Actor class.
 * Responsible for the obstacles such as cars or trucks that will be added
 * to the game screen.
 */
public class Obstacle extends Actor {
	private final int speed;

	/**
	 * Instantiates a new Obstacle.
	 * Sets the X and Y positions, the image of the obstacle
	 * and the speed.
	 *
	 * @param imageLink the image link of the obstacle
	 * @param xpos      the X position of the obstacle
	 * @param ypos      the Y position of the obstacle
	 * @param s         the speed of the obstacle
	 * @param w         the width of the obstacle
	 * @param h         the height of the obstacle
	 */
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
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

	@Override
	public ObjectControllers getObjectController() {
		return null;
	}

}
