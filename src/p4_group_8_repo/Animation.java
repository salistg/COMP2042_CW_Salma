package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.stage.Stage;

/**
 * This class is responsible for starting and stopping the animation of the game.
 * It uses an AnimationTimer and its different methods.
 */
public class Animation {
   private AnimationTimer timer;

    /**
     * Sets the number of the Digit which appears on top of the screen as the user plays the game.
     * The digit changes with the change in the users score.
     * This method is included in this class as the change of the digit's number is an animation.
     *
     * @param n       the number of the digit
     * @param myStage MyStage object that will have the Digit object added to it
     */
    private void setNumber(int n, MyStage myStage) {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            myStage.add(new Digit(k, 30, 360 - shift, 25));
            shift+=30;
        }
    }

    /**
     * Creates the animation timer.
     *
     * @param stage   the stage of the application
     * @param animal  the Animal object that the user plays with on the game screen
     * @param myStage MyStage object that will have the animation timer added to it
     */
    public void createTimer(Stage stage, Animal animal, MyStage myStage) {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (animal.changeScore()) {
                    setNumber(animal.getPoints(),myStage);
                }
                if (animal.getStop()) {
                    gameEnd(stage, myStage, animal);
                }
            }
        };
    }

    /**
     * Stops the animation and the music at the end of the game.
     *
     * @param stage   the stage of the application
     * @param myStage the MyStage object that will have end screen scene in it
     * @param animal  the Animal object that the user plays with in the game
     */
    void gameEnd(Stage stage, MyStage myStage, Animal animal){
        EndScreen endScreen = new EndScreen();
        System.out.print("Game Over\n");
        myStage.stopMusic();
        stop();
        myStage.stop();
        endScreen.endDisplay(stage,animal,myStage);
    }

    /**
     * Stops the timer.
     */
    void stop() {
        timer.stop();
    }

    /**
     * Starts the animation of the game by
     * creating the timer, starting it and playing the game's music.
     *
     * @param stage   the stage of the application
     * @param animal  the Animal object that the user plays with in the game
     * @param myStage the MyStage object that will have the timer added to it
     */
    public void start(Stage stage, Animal animal, MyStage myStage) {
        myStage.playMusic();
        createTimer(stage, animal, myStage);
        timer.start();
    }
}
