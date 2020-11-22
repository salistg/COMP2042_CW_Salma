package p4_group_8_repo.Models;

import javafx.scene.CacheHint;
import javafx.scene.image.Image;
import p4_group_8_repo.Controllers.AnimalController;
import p4_group_8_repo.Controllers.Controllers;


/**
 * Animal class that extends the Actor class.
 * This class is responsible for everything related to the Animal object (the frog)
 * which is the main character to play with in the game.
 *
 */
public class Animal extends Actor {
	/**
	 * AnimalController object instantiated to allow
	 * for the different controls of the Animal object.
	 */
	private final Controllers animalController = new AnimalController(this);

	/**
	 * Constructor to instantiate a new Animal.
	 * It sets the main image of the animal, the starting X and Y coordinates,
	 * and calls the animal controller to enable movement.
	 */

	public Animal(){
		setX(300);
		setY(679.8 + (13.3333333 * 2));
		setImage(new Image("file:src/p4_group_8_repo/images/froggerUp.png", 40, 40, true, true));

		setCache(true);
		setCacheHint(CacheHint.SPEED);
	}

	/**
	 * {@inheritDoc}
	 * @return AnimalController object
	 */
	public Controllers getObjectController(){
		return animalController;
	}


	/**
	 * {@inheritDoc}
	 * Calls the act method in the animal controller class.
	 * @param now timestamp of the current frame in nanoseconds
	 */
	@Override
	public void act(long now) {
		animalController.mainControl(now);
	}

}
