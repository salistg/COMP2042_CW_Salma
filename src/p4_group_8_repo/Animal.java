package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;


/**
 * Animal class that extends the Actor class.
 * This class is responsible for everything related to the Animal object (the frog)
 * which is the main character to play with in the game.
 *
 */
public class Animal extends Actor {

	//Image variables for the look of the animal
	private final Image imgW1;
	private final Image imgA1;
	private final Image imgS1;
	private final Image imgD1;
	private final Image imgW2;
	private final Image imgA2;
	private final Image imgS2;
	private final Image imgD2;
	private int points = 0; //points the user scores as the animal moves
	private int end = 0; //number of burrows the user reaches with the animal
	private boolean second = false; //to indicate if the frog is jumping or moving
	private boolean noMove = false; //to indicate if the frog is moving or no
	private final double movement = 13.3333333 * 2; //movement of the animal character along the Y axis
	private final double movementX = 10.666666 * 2; //movement along the X axis
	private final int imgSize = 40; //image size
	private boolean carDeath = false; //variable for death by a car (obstacle) object
	private boolean waterDeath = false; //variable for death by water
	private boolean changeScore = false; //variable for score change as the user plays
    private int carD = 0; //car death variable to indicate the type of car deaths
	private double w = 800; //width of the gae screen

	/**
	 * Constructor to instantiate a new Animal.
	 * It sets the main image of the animal, the starting X and Y coordinates,
	 * its movements when the keys are pressed and released as well as
	 * the image of the animal when it moves at a certain key press.
	 *
	 * @param imageLink image link for the main image of the animal at the beginning of the game
	 */
	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(300);
		setY(679.8 + movement);
		imgW1 = new Image("file:src/p4_group_8_repo/images/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/p4_group_8_repo/images/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/p4_group_8_repo/images/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/p4_group_8_repo/images/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/p4_group_8_repo/images/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/p4_group_8_repo/images/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/p4_group_8_repo/images/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/p4_group_8_repo/images/froggerRightJump.png", imgSize, imgSize, true, true);
		setOnKeyPressed(event -> {

				if (second) {
					if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
						move(0, -movement);
						changeScore = false;
						setImage(imgW1);
						second = false;
					} else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
						move(-movementX, 0);
						setImage(imgA1);
						second = false;
					} else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
						move(0, movement);
						setImage(imgS1);
						second = false;
					} else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
						move(movementX, 0);
						setImage(imgD1);
						second = false;
					}
				} else if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
					move(0, -movement);
					setImage(imgW2);
					second = true;
				} else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
					move(-movementX, 0);
					setImage(imgA2);
					second = true;
				} else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
					move(0, movement);
					setImage(imgS2);
					second = true;
				} else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
					move(movementX, 0);
					setImage(imgD2);
					second = true;
				}

		});
		setOnKeyReleased(event -> {
		if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
					if (getY() < w) {
						changeScore = true;
						w = getY();
						points += 10;
					}
					move(0, -movement);
					setImage(imgW1);
					second = false;
				} else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
					move(-movementX, 0);
					setImage(imgA1);
					second = false;
				} else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
					move(0, movement);
					setImage(imgS1);
					second = false;
				} else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
					move(movementX, 0);
					setImage(imgD1);
					second = false;
				}

		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void act(long now) {
		if (getY() < 0 || getY() > 734) {
			setX(300);
			setY(679.8 + movement);
		}
		if (getX() < 0) {
			move(movement * 2, 0);
		}
		if (carDeath) {
			noMove = true;
			if ((now) % 11 == 0) {
				carD++;
			}
			if (carD == 1) {
				setImage(new Image("file:src/p4_group_8_repo/images/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD == 2) {
				setImage(new Image("file:src/p4_group_8_repo/images/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD == 3) {
				setImage(new Image("file:src/p4_group_8_repo/images/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				carDeath = false;
				setDeath();
			}
		}
		if (waterDeath) {
			noMove = true;
			if ((now) % 11 == 0) {
				carD++;
			}
			if (carD == 1) {
				setImage(new Image("file:src/p4_group_8_repo/images/waterdeath1.png", imgSize, imgSize, true, true));
			}
			if (carD == 2) {
				setImage(new Image("file:src/p4_group_8_repo/images/waterdeath2.png", imgSize, imgSize, true, true));
			}
			if (carD == 3) {
				setImage(new Image("file:src/p4_group_8_repo/images/waterdeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setImage(new Image("file:src/p4_group_8_repo/images/waterdeath4.png", imgSize, imgSize, true, true));
			}
			if (carD == 5) {
				waterDeath = false;
				setDeath();
			}

		}
		if (getX() > 600) {
			move(-movement * 2, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			boolean stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if (getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2, 0);
			else
				move(.75, 0);
		} else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1, 0);
		} else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1, 0);
			}
		} else if (getIntersectingObjects(End.class).size() >= 1) {
			//ArrayList<End> inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points -= 50;
			}
			points += 50;
			changeScore = true;
			w = 800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300);
			setY(679.8 + movement);
		} else if (getY() < 413) {
			waterDeath = true;

		}
	}

	/**
	 * This method returns whether the user has finished the game or not.
	 * The game stops when the number of ends is 5.
	 *
	 * @return boolean of end==5
	 */
	public boolean getStop() {
		return end == 5;
	}

	/**
	 * Gets the points the user has accumulated in the game.
	 *
	 * @return points
	 */
	public int getPoints() {
		return points;
	}


	/**
	 * This method returns whether the score of the user has changed or not.
	 *
	 * @return true if score changed, false otherwise
	 */
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
	}

	/**
	 * This method is used when the animal dies due to water or a car.
	 * This method resets the animal back to its start position and image if it dies and
	 * cuts off 50 points from the user if their score is greater than 50.
	 */
	private void setDeath() {
		setX(300);
		setY(679.8 + movement);
		carD = 0;
		setImage(new Image("file:src/p4_group_8_repo/images/froggerUp.png", imgSize, imgSize, true, true));
		noMove = false;
		if (points > 50) {
			points -= 50;
			changeScore = true;
		}
	}

}
