package p4_group_8_repo.Controllers;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import p4_group_8_repo.Models.Actor;

/**
 * The movement controls of Actor objects are written in this class.
 * This class dictates how the objects should act when keys are pressed or
 * released.
 */
public class AnimalMovementController implements Controllers {
    /**
     * Image object to set an image of the Actor.
     */
    private final Image imgW1;
    /**
     * Image object to set an image of the Actor.
     */
    private final Image imgA1;
    /**
     * Image object to set an image of the Actor.
     */
    private final Image imgS1;
    /**
     * Image object to set an image of the Actor.
     */
    private final Image imgD1;
    /**
     * Image object to set an image of the Actor.
     */
    private final Image imgW2;
    /**
     * Image object to set an image of the Actor.
     */
    private final Image imgA2;
    /**
     * Image object to set an image of the Actor.
     */
    private final Image imgS2;
    /**
     * Image object to set an image of the Actor.
     */
    private final Image imgD2;
    /**
     * movement of the Actor object along the Y axis
     */
    private final double movement = 13.3333333 * 2;
    /**
     * movement of the Actor object along the X axis
     */
    private final double movementX = 10.666666 * 2;
    /**
     * points the user scores as the Actor object moves
     */
    private int points = 0;
    /**
     * To indicate if the Actor object is on the second half of animation
     */
    private boolean second = false;
    /**
     * variable for score change as the user plays
     * set to false if score hasn't changed and
     * true if it has
     */
    private boolean changeScore = false;
    /**
     * width of the game screen
     */
    private double w = 800;
    /**
     * Actor object for which movement is needed.
     */
    private final Actor actor;

    /**
     * Instantiates a new AnimalMovementController object.
     *
     * @param actor Actor object for which movement is needed
     */
    public AnimalMovementController(Actor actor){
        int imgSize = 40; //image size
        imgW1 = new Image("file:src/p4_group_8_repo/images/froggerUp.png", imgSize, imgSize, true, true);
        imgA1 = new Image("file:src/p4_group_8_repo/images/froggerLeft.png", imgSize, imgSize, true, true);
        imgS1 = new Image("file:src/p4_group_8_repo/images/froggerDown.png", imgSize, imgSize, true, true);
        imgD1 = new Image("file:src/p4_group_8_repo/images/froggerRight.png", imgSize, imgSize, true, true);
        imgW2 = new Image("file:src/p4_group_8_repo/images/froggerUpJump.png", imgSize, imgSize, true, true);
        imgA2 = new Image("file:src/p4_group_8_repo/images/froggerLeftJump.png", imgSize, imgSize, true, true);
        imgS2 = new Image("file:src/p4_group_8_repo/images/froggerDownJump.png", imgSize, imgSize, true, true);
        imgD2 = new Image("file:src/p4_group_8_repo/images/froggerRightJump.png", imgSize, imgSize, true, true);
        this.actor=actor;
    }

    /**
     * {@inheritDoc}
     * The main controls in the case of this class
     * is how the animal should act
     * at a key press or key release.
     *
     * @param now the current timestamp of the frame in nanoseconds
     */
    @Override
    public void mainControl(long now) {
        animalKeyPress();
        animalKeyRelease();
    }

    /**
     * Sets the actions of the Actor object
     * when keys are pressed.
     *
     * Animal.setOnKeyPressed
     */
    private void animalKeyPress() {
        actor.setOnKeyPressed(event -> {
            if (second) {
                if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
                    actor.move(0, -movement);
                    changeScore = false;
                    actor.setImage(imgW1);
                    second = false;
                } else {
                    keyAction(event);
                }
            } else if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
                actor.move(0, -movement);
                actor.setImage(imgW2);
                second = true;
            } else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
                actor.move(-movementX, 0);
                actor.setImage(imgA2);
                second = true;
            } else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
                actor.move(0, movement);
                actor.setImage(imgS2);
                second = true;
            } else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
                actor.move(movementX, 0);
                actor.setImage(imgD2);
                second = true;
            }

        });
    }

    /**
     * Sets the actions of the Actor object
     * when keys are released.
     *
     * Animal.setOnKeyReleased
     */
    private void animalKeyRelease() {
        actor.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
                if (actor.getY() < w) {
                    changeScore = true;
                    w = actor.getY();
                    points += 10;
                }
                actor.move(0, -movement);
                actor.setImage(imgW1);
                second = false;
            } else keyAction(event);
        });
    }

    /**
     * A series of events that occur when a
     * set of keys are pressed.
     *
     * @param event key press/release event
     */
    private void keyAction(KeyEvent event) {
        if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
            actor.move(-movementX, 0);
            actor.setImage(imgA1);
            second = false;
        } else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
            actor.move(0, movement);
            actor.setImage(imgS1);
            second = false;
        } else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
            actor.move(movementX, 0);
            actor.setImage(imgD1);
            second = false;
        }
    }

    @Override
    public Actor getActor() {
        return actor;
    }

    /**
     * Gets the points accumulated by the Actor object
     * as it moves.
     *
     * @return points accumulated
     */
    public int getPoints(){
        return points;
    }

    /**
     * Gets the changeScore variable that
     * indicates whether the score has changed or not.
     *
     * @return current state of the changeScore variable (true/false)
     */
    @Override
    public boolean changeScore(){
       return changeScore;
    }

    /**
     * {@inheritDoc}
     * Inherited but not used in this class.
     * @return false
     */
    @Override
    public boolean gameHasEnded() {
        return false;
    }

}
