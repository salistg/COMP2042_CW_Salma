package p4_group_8_repo.Models;

import javafx.scene.CacheHint;
import javafx.scene.image.Image;
import p4_group_8_repo.Controllers.ActorControllers;

/**
 * Obstacle class that extends the Actor class. </br>
 * Responsible for the obstacles such as cars or trucks that
 * cause the death of the Animal character when they
 * intersect with it.
 */
public class Obstacle extends Actor {
	/**
	 * Variable for the speed of the obstacle.
	 */
	private final double speed;

	/**
	 * Instantiates a new Obstacle object. </br>
	 * Sets the X and Y positions, the cache, the image of the Obstacle
	 * and the speed.
	 *
	 * @param imageLink the image link of the Obstacle
	 * @param xpos      the X position of the Obstacle
	 * @param ypos      the Y position of the Obstacle
	 * @param s         the speed of the Obstacle
	 * @param dim       the dimensions (width and height) of the image of the obstacle
	 */
	public Obstacle(String imageLink, int xpos, int ypos, double s, int dim) {
		setImage(new Image(imageLink, dim,dim, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
		setCache(true);
		setCacheHint(CacheHint.SPEED);
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
	public ActorControllers getActorController() {
		return null;
	}

}
