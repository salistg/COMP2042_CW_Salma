package p4_group_8_repo.Models;

import javafx.scene.CacheHint;
import javafx.scene.image.Image;
import p4_group_8_repo.Controllers.AnimalController;
import p4_group_8_repo.Controllers.ActorControllers;


/**
 * Animal class that extends the Actor class.
 * Animal is the main character added to the game world
 * for the users to control and play with.
 *
 */
public class Animal extends Actor {
	/**
	 * AnimalController object instantiated to allow
	 * for the different controls of the Animal object.
	 */
	private final ActorControllers animalController = new AnimalController(this);

	/**
	 * Constructor to instantiate a new Animal object.
	 * It sets the main image of the animal, the Cache and
	 * the starting X and Y coordinates.
	 */
	public Animal(){
		setX(300);
		setY(679.8 + (13.3333333 * 2));
		String imageSource = "file:src/p4_group_8_repo/images/";
		setImage(new Image(imageSource + "froggerUp.png", 40, 40, true, true));

		setCache(true);
		setCacheHint(CacheHint.SPEED);
	}

	/**
	 * {@inheritDoc}
	 * @return AnimalController object
	 */
	public ActorControllers getActorController(){
		return animalController;
	}


	/**
	 * {@inheritDoc} </br> </br>
	 * Calls the mainControl method in the AnimalController class
	 * to allow for the different controls of the animal such
	 * as movement.
	 *
	 * @param now timestamp of the current frame in nanoseconds
	 */
	@Override
	public void act(long now) {
		animalController.mainControl(now);
	}

}
