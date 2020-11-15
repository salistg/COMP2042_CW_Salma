package p4_group_8_repo.Controllers;

import javafx.animation.AnimationTimer;
import javafx.stage.Stage;
import p4_group_8_repo.EndOfGame;
import p4_group_8_repo.Models.Digit;
import p4_group_8_repo.MyStage;

/**
 * This class is responsible for starting and stopping the animation of the objects of the game.
 * It uses an AnimationTimer and its different methods.
 */
public class AnimationController {
   private AnimationTimer timer = null;
   private final Stage stage;
  private ObjectControllers objectControllers;
   private final MyStage myStage;

   public AnimationController(Stage stage, MyStage myStage, ObjectControllers objectControllers){
       this.stage=stage;
       this.myStage=myStage;
       this.objectControllers = objectControllers;
   }

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
     * Creates the animation timer for the movement of an Animal object.
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (objectControllers.changeScore()) {
                    setNumber(objectControllers.getPoints(),myStage);
                }
                if (objectControllers.getStop()) {
                    gameEnd();
                }
            }
        };
    }

    /**
     * Stops the animation and the music at the end of the game.
     */
    void gameEnd(){
        EndOfGame endOfGame = new EndOfGame(stage, objectControllers);
        System.out.print("Game Over\n");
        myStage.stopMusic();
        stop();
        myStage.stop();
        endOfGame.endDisplay();
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
     */
    public void start() {
        myStage.playMusic();
        createTimer();
        timer.start();
    }

}
