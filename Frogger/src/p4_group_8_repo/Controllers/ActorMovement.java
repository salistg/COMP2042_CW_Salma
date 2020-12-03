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
public class ActorMovement {
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
    private final double movementY = 13.3333333 * 2;
    /**
     * movement of the Actor object along the X axis
     */
    private final double movementX = 10.666666 * 2;
    /**
     * points the user scores as the
     * Actor object moves forward
     */
    private int points = 0;
    /**
     * To indicate if the Actor object is on the second half of animation
     */
    private boolean second = false;
    /**
     * Variable for score change as the user plays.
     * Set to false if score hasn't changed and
     * true if it has.
     */
    private boolean changeScore = false;
    /**
     * Actor object for which movement is needed.
     */
    private final Actor actor;

    /**
     * Instantiates a new ActorMovement object.
     *
     * @param actor Actor object for which movement is needed
     */
    public ActorMovement(Actor actor){
        int imgSize = 40; //image size
        String imageSource = "file:src/p4_group_8_repo/images/"; //string to hold the path of the image sorce
        imgW1 = new Image(imageSource + "froggerUp.png", imgSize, imgSize, true, true);
        imgA1 = new Image(imageSource + "froggerLeft.png", imgSize, imgSize, true, true);
        imgS1 = new Image(imageSource + "froggerDown.png", imgSize, imgSize, true, true);
        imgD1 = new Image(imageSource + "froggerRight.png", imgSize, imgSize, true, true);
        imgW2 = new Image(imageSource + "froggerUpJump.png", imgSize, imgSize, true, true);
        imgA2 = new Image(imageSource + "froggerLeftJump.png", imgSize, imgSize, true, true);
        imgS2 = new Image(imageSource + "froggerDownJump.png", imgSize, imgSize, true, true);
        imgD2 = new Image(imageSource + "froggerRightJump.png", imgSize, imgSize, true, true);
        this.actor=actor;
    }

    /**
     * The main controls of the Actor object.
     * Dictates how the object should act
     * at a key press or key release.
     */
    public void movement() {
        actorKeyPress();
        actorKeyRelease();
    }

    /**
     * Sets the actions of the Actor object
     * when keys are pressed. </br>
     *
     * (actor.setOnKeyPressed)
     */
    private void actorKeyPress() {
        actor.setOnKeyPressed(event -> {
            if (second) {
                if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
                    actor.move(0, -movementY);
                    changeScore = false;
                    actor.setImage(imgW1);
                    second = false;
                } else {
                    keyAction(event);
                }
            } else if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
                actor.move(0, -movementY);
                actor.setImage(imgW2);
                second = true;
            } else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
                actor.move(-movementX, 0);
                actor.setImage(imgA2);
                second = true;
            } else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
                actor.move(0, movementY);
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
     * when keys are released. </br>
     *
     * (actor.setOnKeyReleased)
     */
    private void actorKeyRelease() {
        actor.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
                points+=5;
                changeScore = true;
                actor.move(0, -movementY);
                actor.setImage(imgW1);
                second = false;
            } else keyAction(event);
        });
    }

    /**
     * A series of events that occur when a
     * set of keys are pressed or released.
     *
     * @param event key press/release event
     */
    private void keyAction(KeyEvent event) {
        if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
            actor.move(-movementX, 0);
            actor.setImage(imgA1);
            second = false;
        } else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
            actor.move(0, movementY);
            actor.setImage(imgS1);
            second = false;
        } else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
            actor.move(movementX, 0);
            actor.setImage(imgD1);
            second = false;
        }
    }

    /**
     * Gets the points accumulated by the Actor object
     * as it moves forward.
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
    public boolean changeScore(){
       return changeScore;
    }
}
