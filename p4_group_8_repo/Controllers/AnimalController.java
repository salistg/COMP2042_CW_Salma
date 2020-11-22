package p4_group_8_repo.Controllers;

import javafx.scene.image.Image;
//import javafx.scene.input.KeyCode;
//import javafx.scene.input.KeyEvent;
import p4_group_8_repo.Models.*;

/**
 * A controller class for the Animal model following the MVC pattern.
 * It contains all the methods responsible for the actions of an Animal object
 * such as key-presses and intersection with other objects.
 */
public class AnimalController implements Controllers {
    /**
     * points the user scores as they play the game
     */
    private int points = 0;
    /**
     * number of burrows the user reaches with the Actor object
     */
    private int end = 0;
//    /**
//     * to indicate if the frog is on the second half of animation
//     */
//    private final boolean second = false;
    /**
     * to indicate if the Actor object should be moving or not
     */
    private boolean noMove = false;
    /**
     * movement of the Actor object along the Y axis
     */
    private final double movement = 13.3333333 * 2;
    //private final double movementX = 10.666666 * 2; //movement along the X axis
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
     * ActorMovement object to control the movement of the Actor
     */
    private final AnimalMovement actorMovementController;

    /**
     * Constructor to instantiate a new AnimalController.
     * Sets the Animal and ActorMovement objects.
     */
    public AnimalController(Actor animal) {
//        Image imgW1 = new Image("file:src/p4_group_8_repo/images/froggerUp.png", imgSize, imgSize, true, true);
//        Image imgA1 = new Image("file:src/p4_group_8_repo/images/froggerLeft.png", imgSize, imgSize, true, true);
//        Image imgS1 = new Image("file:src/p4_group_8_repo/images/froggerDown.png", imgSize, imgSize, true, true);
//        Image imgD1 = new Image("file:src/p4_group_8_repo/images/froggerRight.png", imgSize, imgSize, true, true);
//        Image imgW2 = new Image("file:src/p4_group_8_repo/images/froggerUpJump.png", imgSize, imgSize, true, true);
//        Image imgA2 = new Image("file:src/p4_group_8_repo/images/froggerLeftJump.png", imgSize, imgSize, true, true);
//        Image imgS2 = new Image("file:src/p4_group_8_repo/images/froggerDownJump.png", imgSize, imgSize, true, true);
//        Image imgD2 = new Image("file:src/p4_group_8_repo/images/froggerRightJump.png", imgSize, imgSize, true, true);
        this.animal = animal;
        actorMovementController = new AnimalMovement(animal);
    }

    /**
     * {@inheritDoc}
     * @return Animal object
     */
    public Actor getActor() {
        return animal;
    }

    /**
     * {@inheritDoc}
     * Main controls for this class are how the animal should
     * act when it intersects with other objects,
     * when it dies and when keys are pressed or released.
     *
     * @param now the current timestamp of the frame in nanoseconds
     */
    public void mainControl(long now) {

        actorMovementController.movement();

        if (animal.getY() < 0 || animal.getY() > 734) {
            animal.setX(300);
            animal.setY(679.8 + movement);
        }

        if (animal.getX() < 0) {
            animal.move(movement * 2, 0);
        }

        death(now);

        if (animal.getX() > 600) {
            animal.move(-movement * 2, 0);
        }

        atIntersection();
    }
//
//    /**
//     * Setting what the Animal object should do
//     * when keys are pressed.
//     *
//     * Animal.setOnKeyPressed
//     */
//    public  void animalKeyPress() {
//        animal.setOnKeyPressed(event -> {
//            if (second) {
//                if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
//                    animal.move(0, -movement);
//                    changeScore = false;
//                    animal.setImage(imgW1);
//                    second = false;
//                } else {
//                    keyAction(event);
//                }
//            } else if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
//                animal.move(0, -movement);
//                animal.setImage(imgW2);
//                second = true;
//            } else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
//                animal.move(-movementX, 0);
//                animal.setImage(imgA2);
//                second = true;
//            } else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
//                animal.move(0, movement);
//                animal.setImage(imgS2);
//                second = true;
//            } else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
//                animal.move(movementX, 0);
//                animal.setImage(imgD2);
//                second = true;
//            }
//
//        });
//    }
//
//    /**
//     * Setting what the Animal object should do
//     * when keys are released.
//     *
//     * Animal.setOnKeyReleased
//     */
//    public void animalKeyRelease() {
//        animal.setOnKeyReleased(event -> {
//            if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
//                if (animal.getY() < w) {
//                    changeScore = true;
//                    w = animal.getY();
//                    points += 10;
//                }
//                animal.move(0, -movement);
//                animal.setImage(imgW1);
//                second = false;
//            } else keyAction(event);
//
//        });
//    }
//
//    /**
//     * A series of events that occur when a
//     * set of keys are pressed.
//     *
//     * @param event key press/release
//     */
//    private void keyAction(KeyEvent event) {
//        if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
//            animal.move(-movementX, 0);
//            animal.setImage(imgA1);
//            second = false;
//        } else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
//            animal.move(0, movement);
//            animal.setImage(imgS1);
//            second = false;
//        } else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
//            animal.move(movementX, 0);
//            animal.setImage(imgD1);
//            second = false;
//        }
//    }

    /**
     * This method includes all events that occur
     * when the Actor object intersects with
     * other objects such as End or Obstacle objects.
     */
    private void atIntersection() {
        if (animal.getIntersectingObjects(Obstacle.class).size() >= 1) {
            carDeath=true;
           // setCarDeath(true);
        } else if (animal.getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
            if (animal.getIntersectingObjects(Log.class).get(0).getLeft())
                animal.move(-2, 0);
            else
                animal.move(.75, 0);
        } else if (animal.getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
            animal.move(-1, 0);
        } else if (animal.getIntersectingObjects(WetTurtle.class).size() >= 1) {
            if (animal.getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
                //setWaterDeath(true);
                waterDeath=true;
            } else {
                animal.move(-1, 0);
            }
        } else if (animal.getIntersectingObjects(End.class).size() >= 1) {
            if (animal.getIntersectingObjects(End.class).get(0).isActivated()) {
                animal.getIntersectingObjects(End.class).get(0).returnToOriginal();
                end--;
                points -= 150;
            }
            points += 150;
            changeScore = true;
           // double w = 800; //width of the game screen
            animal.getIntersectingObjects(End.class).get(0).setEnd();
            end++;
            animal.setX(300);
            animal.setY(679.8 + movement);
        } else if (animal.getY() < 413) {
          waterDeath=true;
            //setWaterDeath(true);
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
            //setNoMove(true);
            noMove = true;
            if (now % 11 == 0) {
                deaths++;
            }
            switch (deaths) {
                case 1 -> animal.setImage(new Image("file:src/p4_group_8_repo/images/cardeath1.png", imgSize, imgSize, true, true));
                case 2 -> animal.setImage(new Image("file:src/p4_group_8_repo/images/cardeath2.png", imgSize, imgSize, true, true));
                case 3 -> animal.setImage(new Image("file:src/p4_group_8_repo/images/cardeath3.png", imgSize, imgSize, true, true));
                case 4 -> {
                    if((points+actorMovementController.getPoints())>=100) {
                        points -= 100;
                        changeScore = true;
                    }
                    resetAfterDeath();
                    carDeath=false;
                   // setCarDeath(false);
                }
            }

        }
        if (waterDeath) {
           // setNoMove(true);
            noMove = true;
            if (now % 11 == 0) {
                deaths++;
            }
            switch (deaths) {
                case 1 -> animal.setImage(new Image("file:src/p4_group_8_repo/images/waterdeath1.png", imgSize,imgSize, true, true));
                case 2 -> animal.setImage(new Image("file:src/p4_group_8_repo/images/waterdeath2.png", imgSize, imgSize, true, true));
                case 3 -> animal.setImage(new Image("file:src/p4_group_8_repo/images/waterdeath3.png", imgSize, imgSize, true, true));
                case 4 -> animal.setImage(new Image("file:src/p4_group_8_repo/images/waterdeath4.png", imgSize, imgSize, true, true));
                case 5 -> {
                    if((points+actorMovementController.getPoints())>=100) {
                        points -= 100;
                        changeScore = true;
                    }
                    resetAfterDeath();
                    waterDeath=false;
                   // setWaterDeath(false);
                }
            }


        }
    }

    /**
     * Resets the animal back to its start position and image if it dies.
     */
    private void resetAfterDeath() {
        animal.setX(300);
        animal.setY(679.8 + movement);
        deaths = 0;
        animal.setImage(new Image("file:src/p4_group_8_repo/images/froggerUp.png", imgSize, imgSize, true, true));
        noMove=false;
        //setNoMove(false);
    }

    /**
     * Returns whether the user has finished the game or not.
     * The game stops when the number of ends is 5.
     *
     * @return boolean of end==5
     */
    public boolean gameHasEnded() {
        return end == 5;
    }

    /**
     * Gets the points the user has accumulated in the game.
     *
     * @return points
     */
    public int getPoints() {
        return points + actorMovementController.getPoints();
    }

    /**
     * This method returns whether the score of the user has changed or not.
     *
     * @return true if score changed, false otherwise
     */
    public boolean changeScore() {
        if (changeScore || actorMovementController.changeScore()) {
            changeScore = false;
            return true;
        }
        return false;
    }

//    /**
//     * Gets the noMove variable.
//     * Indicates whether the Actor object
//     * is currently moving.
//     *
//     * @return current state of the noMove variable (true/false)
//     */
//    public boolean getMove(){
//        return noMove;
//    }

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

//    /**
//     * Gets the deaths variable
//     * which is the number of deaths the Actor
//     * object has had so far.
//     *
//     * @return number of deaths
//     */
//    public int getDeaths(){
//        return deaths;
//    }

//    /**
//     * Sets the noMove variable.
//     *
//     * @param noMove variable for movement
//     */
//    private void setNoMove(boolean noMove){
//        this.noMove=noMove;
//    }
//
//    /**
//     * Sets the waterDeath variable.
//     *
//     * @param waterDeath variable for waterDeath
//     */
//    private void setWaterDeath(Boolean waterDeath){
//        this.waterDeath=waterDeath;
//    }

//    /**
//     * Sets the carDeath variable.
//     *
//     * @param carDeath variable for carDeath.
//     */
//    private void setCarDeath(Boolean carDeath){
//        this.carDeath = carDeath;
//    }


}
