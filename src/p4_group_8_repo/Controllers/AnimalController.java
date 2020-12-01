package p4_group_8_repo.Controllers;

import javafx.scene.image.Image;
import p4_group_8_repo.Models.*;

/**
 * A controller class for the Animal model following the MVC pattern. </br>
 * It contains all the methods responsible for the actions of an Animal object
 * such as its intersection with other objects and
 * its death.
 */
public class AnimalController implements ActorControllers {
    /**
     * points the user earns as they play the game
     */
    private int points = 0;
    /**
     * number of end goals the user reaches with the Actor object
     */
    private int endGoal = 0;
    /**
     * to indicate if the Actor object should be moving or not
     */
    private boolean noMove = false;
    /**
     * movement of the Actor object along the Y axis
     */
    private final double movementY = 13.3333333 * 2;
    /**
     * image size
     */
    private final int imgSize = 40;
    /**
     * variable for death by a car (obstacle) object
     */
    private boolean carDeath = false;
    /**
     * variable for death by water
     */
    private boolean waterDeath = false;
    /**
     * variable for score change as the user plays
     */
    private boolean changeScore = false;
    /**
     * variable to indicate the number of deaths
     */
    private int deaths = 0;
    /**
     * Actor object that the user will control in the game
     */
    private final Actor animal;
    /**
     * AnimalMovement object to control the movement of the Actor
     */
    private final ActorMovement actorMovement;
    /**
     * A string to hold the file path
     * of the image source.
     */
    private final String imageSource= "file:src/p4_group_8_repo/images/";

    /**
     * Constructor to instantiate a new AnimalController.
     * Sets the Animal and ActorMovement objects.
     *
     * @param animal actor object for which the controller is needed
     */
    public AnimalController(Actor animal) {
        this.animal = animal;
        actorMovement = new ActorMovement(animal);
    }

    /**
     * {@inheritDoc}
     * @return Actor object
     */
    public Actor getActor() {
        return animal;
    }

    /**
     * {@inheritDoc} </br>
     * Main controls for this class are how the animal should
     * act when it intersects with other objects,
     * when it dies and when keys are pressed or released.
     *
     * @param now the current timestamp of the frame in nanoseconds
     */
    public void mainControl(long now) {

        actorMovement.movement();

        if (animal.getY() < 0 || animal.getY() > 734) {
            animal.setX(300);
            animal.setY(679.8 + movementY);
        }

        if (animal.getX() < 0) {
            animal.move(movementY * 2, 0);
        }

        death(now);

        if (animal.getX() > 600) {
            animal.move(-movementY * 2, 0);
        }

        atIntersection();
    }

    /**
     * This method includes all events that should occur
     * when the Actor object intersects with
     * other objects such as End or Obstacle objects.
     */
    private void atIntersection() {
        if (animal.getIntersectingObjects(Obstacle.class).size() >= 1) {
            carDeath=true;
        } else if (animal.getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
            if (animal.getIntersectingObjects(Log.class).get(0).getLeft())
                animal.move(-2, 0);
            else
                animal.move(.75, 0);
        } else if (animal.getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
            animal.move(-1, 0);
        } else if (animal.getIntersectingObjects(WetTurtle.class).size() >= 1) {
            if (animal.getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
                waterDeath=true;
            } else {
                animal.move(-1, 0);
            }
        } else if (animal.getIntersectingObjects(EndGoal.class).size() >= 1) {
            if (animal.getIntersectingObjects(EndGoal.class).get(0).isActivated()) {
                animal.getIntersectingObjects(EndGoal.class).get(0).returnToOriginal();
                endGoal--;
                points -= 50;
            }
            points += 50;
            changeScore = true;
            animal.getIntersectingObjects(EndGoal.class).get(0).setEnd();
            endGoal++;
            animal.setX(300);
            animal.setY(679.8 + movementY);
        } else if (animal.getY() < 413) {
          waterDeath=true;
        }
    }

    /**
     * Sets the image of the Actor object and reduces points
     * when the Actor dies after intersecting with
     * an Obstacle object or by drowning.
     *
     * @param now timestamp of the current frame in nanoseconds
     */
    private void death(long now) {
        if (carDeath) {
            noMove = true;
            if (now % 11 == 0) {
                deaths++;
            }
            switch (deaths) {
                case 1 -> animal.setImage(new Image(imageSource + "cardeath1.png", imgSize, imgSize, true, true));
                case 2 -> animal.setImage(new Image(imageSource + "cardeath2.png", imgSize, imgSize, true, true));
                case 3 -> animal.setImage(new Image(imageSource + "cardeath3.png", imgSize, imgSize, true, true));
                case 4 -> {
                    if((points + actorMovement.getPoints())>=50) {
                        points -= 50;
                        changeScore = true;
                    }
                    resetAfterDeath();
                    carDeath=false;
                }
            }

        }
        if (waterDeath) {
            noMove = true;
            if (now % 11 == 0) {
                deaths++;
            }
            switch (deaths) {
                case 1 -> animal.setImage(new Image(imageSource + "waterdeath1.png", imgSize,imgSize, true, true));
                case 2 -> animal.setImage(new Image(imageSource + "waterdeath2.png", imgSize, imgSize, true, true));
                case 3 -> animal.setImage(new Image(imageSource + "waterdeath3.png", imgSize, imgSize, true, true));
                case 4 -> animal.setImage(new Image(imageSource + "waterdeath4.png", imgSize, imgSize, true, true));
                case 5 -> {
                    if((points + actorMovement.getPoints())>=50) {
                        points -= 50;
                        changeScore = true;
                    }
                    resetAfterDeath();
                    waterDeath=false;
                }
            }


        }
    }

    /**
     * Resets the Actor object back to
     * its start position and image if it dies.
     */
    private void resetAfterDeath() {
        animal.setX(300);
        animal.setY(679.8 + movementY);
        deaths = 0;
        animal.setImage(new Image(imageSource + "froggerUp.png", imgSize, imgSize, true, true));
        noMove=false;
    }

    /**
     * Returns whether the user has finished the game or not.
     * The game stops when the number of end goals is 5.
     *
     * @return boolean value of end==5
     */
    public boolean hasGameEnded() {
        return endGoal == 5;
    }

    /**
     * Gets the points the user has accumulated in the game.
     *
     * @return points earned in the game
     */
    public int getPoints() {
        return points + actorMovement.getPoints();
    }

    /**
     * This method returns whether the score of the user has changed or not.
     *
     * @return true if score changed, false otherwise
     */
    public boolean changeScore() {
        if (changeScore || actorMovement.changeScore()) {
            changeScore = false;
            return true;
        }
        return false;
    }

    /**
     * Gets the carDeath variable.
     * Indicates whether the Actor object
     * has died a death of type carDeath.
     *
     * @return current state of the carDeath variable (true/false)
     */
    public boolean getCarDeath(){
        return carDeath;
    }

    /**
     * Gets the waterDeath variable.
     * Indicates whether the Actor object
     * has died a death of type waterDeath.
     *
     * @return current state of the waterDeath variable (true/false)
     */
    public boolean getWaterDeath(){
        return waterDeath;
    }


}
