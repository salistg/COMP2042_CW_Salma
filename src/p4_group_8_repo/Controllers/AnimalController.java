package p4_group_8_repo.Controllers;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import p4_group_8_repo.Models.*;
import p4_group_8_repo.MyStage;

/**
 * A controller class for the Animal model following th MVC pattern.
 * It contains all the methods
 */
public class AnimalController implements ObjectControllers {
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
    private boolean second = false; //to indicate if the frog is on the second half of animation
    private boolean noMove = false; //to indicate if the frog is moving or no
    private final double movement = 13.3333333 * 2; //movement of the animal character along the Y axis
    private final double movementX = 10.666666 * 2; //movement along the X axis
    private final int imgSize = 40; //image size
    private boolean carDeath = false; //variable for death by a car (obstacle) object
    private boolean waterDeath = false; //variable for death by water
    private boolean changeScore = false; //variable for score change as the user plays
    private int carD = 0; //car death variable to indicate the type of car deaths
    private double w = 800; //width of the game screen
    public final Actor animal;
    private MyStage myStage;

    /**
     * Constructor to instantiate a new AnimalController.
     * Instantiates the Image objects and sets the different images of the Animal.
     */

    public AnimalController(Actor animal){
        imgW1 = new Image("file:src/p4_group_8_repo/images/froggerUp.png", imgSize, imgSize, true, true);
        imgA1 = new Image("file:src/p4_group_8_repo/images/froggerLeft.png", imgSize, imgSize, true, true);
        imgS1 = new Image("file:src/p4_group_8_repo/images/froggerDown.png", imgSize, imgSize, true, true);
        imgD1 = new Image("file:src/p4_group_8_repo/images/froggerRight.png", imgSize, imgSize, true, true);
        imgW2 = new Image("file:src/p4_group_8_repo/images/froggerUpJump.png", imgSize, imgSize, true, true);
        imgA2 = new Image("file:src/p4_group_8_repo/images/froggerLeftJump.png", imgSize, imgSize, true, true);
        imgS2 = new Image("file:src/p4_group_8_repo/images/froggerDownJump.png", imgSize, imgSize, true, true);
        imgD2 = new Image("file:src/p4_group_8_repo/images/froggerRightJump.png", imgSize, imgSize, true, true);
        this.animal=animal;
//        animal = new Animal();
//        this.myStage=myStage;
//        addActorToScene();
//        long now = 0;
//        mainControl(now);
    }

    public void setMyStage(MyStage myStage){
        this.myStage=myStage;
    }
    public void addActorToScene(){
        myStage.add(animal);
    }

    public Actor getActor() {
        return animal;
    }

    public void mainControl(long now) {
        animalKeyRelease();
        animalKeyPress();

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


    public  void animalKeyPress() {
        animal.setOnKeyPressed(event -> {
            if (second) {
                if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
                    animal.move(0, -movement);
                    changeScore = false;
                    animal.setImage(imgW1);
                    second = false;
                } else {
                    keyAction( event);
                }
            } else if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
                animal.move(0, -movement);
                animal.setImage(imgW2);
                second = true;
            } else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
                animal.move(-movementX, 0);
                animal.setImage(imgA2);
                second = true;
            } else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
                animal.move(0, movement);
                animal.setImage(imgS2);
                second = true;
            } else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
                animal.move(movementX, 0);
                animal.setImage(imgD2);
                second = true;
            }

        });
    }

    public void animalKeyRelease() {
        animal.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
                if (animal.getY() < w) {
                    changeScore = true;
                    w = animal.getY();
                    points += 10;
                }
                animal.move(0, -movement);
                animal.setImage(imgW1);
                second = false;
            } else keyAction(event);

        });
    }

    private void keyAction(KeyEvent event) {
        if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
            animal.move(-movementX, 0);
            animal.setImage(imgA1);
            second = false;
        } else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
            animal.move(0, movement);
            animal.setImage(imgS1);
            second = false;
        } else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
            animal.move(movementX, 0);
            animal.setImage(imgD1);
            second = false;
        }
    }

    public void atIntersection() {
        if (animal.getIntersectingObjects(Obstacle.class).size() >= 1) {
            carDeath = true;
        } else if (animal.getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
            if (animal.getIntersectingObjects(Log.class).get(0).getLeft())
                animal.move(-2, 0);
            else
                animal.move(.75, 0);
        } else if (animal.getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
            animal.move(-1, 0);
        } else if (animal.getIntersectingObjects(WetTurtle.class).size() >= 1) {
            if (animal.getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
                waterDeath = true;
            } else {
                animal.move(-1, 0);
            }
        } else if (animal.getIntersectingObjects(End.class).size() >= 1) {
            if (animal.getIntersectingObjects(End.class).get(0).isActivated()) {
                end--;
                points -= 50;
            }
            points += 50;
            changeScore = true;
            w = 800;
            animal.getIntersectingObjects(End.class).get(0).setEnd();
            end++;
            animal.setX(300);
            animal.setY(679.8 + movement);
        } else if (animal.getY() < 413) {
            waterDeath = true;
        }
    }

    private void death(long now) {
        if (carDeath) {
            noMove = true;
            if (now % 11 == 0) {
                carD++;
            }
            switch (carD) {
                case 1 -> animal.setImage(new Image("file:src/p4_group_8_repo/images/cardeath1.png", imgSize, imgSize, true, true));
                case 2 -> animal.setImage(new Image("file:src/p4_group_8_repo/images/cardeath2.png", imgSize, imgSize, true, true));
                case 3 -> animal.setImage(new Image("file:src/p4_group_8_repo/images/cardeath3.png", imgSize, imgSize, true, true));
                case 4 -> {
                    resetAfterDeath();
                    if(points>50) {
                        points -= 50;
                        changeScore = true;
                    }
                    carDeath = false;
                }
            }

        }
        if (waterDeath) {
            noMove = true;
            if (now % 11 == 0) {
                carD++;
            }
            switch (carD) {
                case 1 -> animal.setImage(new Image("file:src/p4_group_8_repo/images/waterdeath1.png", imgSize,imgSize, true, true));
                case 2 -> animal.setImage(new Image("file:src/p4_group_8_repo/images/waterdeath2.png", imgSize, imgSize, true, true));
                case 3 -> animal.setImage(new Image("file:src/p4_group_8_repo/images/waterdeath3.png", imgSize, imgSize, true, true));
                case 4 -> animal.setImage(new Image("file:src/p4_group_8_repo/images/waterdeath4.png", imgSize, imgSize, true, true));
                case 5 -> {
                    resetAfterDeath();
                    if(points>50) {
                        points -= 50;
                        changeScore = true;
                    }
                    waterDeath = false;
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
        carD = 0;
        animal.setImage(new Image("file:src/p4_group_8_repo/images/froggerUp.png", imgSize, imgSize, true, true));
        noMove = false;
    }

    /**
     * Returns whether the user has finished the game or not.
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


}
