package p4_group_8_repo.Controllers;

import javafx.animation.AnimationTimer;
import javafx.stage.Stage;
import p4_group_8_repo.Models.SelectModelFactory;
import p4_group_8_repo.Views.GameViews;
import p4_group_8_repo.Views.SelectViewFactory;
import p4_group_8_repo.Views.World;

/**
 * This class is responsible for starting and stopping the animation of the objects of the game.
 * It uses an AnimationTimer and its different methods.
 */
public class DigitAnimation implements Controllers {
    /**
     * AnimationTimer variable for the animation
     */
   private AnimationTimer timer = null;
    /**
     * Stage of the application
     */
   private final Stage stage;
    /**
     * A Controller object that controls the actors in the game
     */
  private final Controllers controller;
    /**
     * A World object that contains the actors of the game
     */
   private final World myStage;
   private boolean isRunning;

    /**
     * Instantiates a new AnimationController.
     *
     * @param stage stage of the application
     * @param myStage the world that the Actors of the game are a part of
     * @param controller object controller for the controls of the actors
     */
   public DigitAnimation(Stage stage, World myStage, Controllers controller){
       this.stage=stage;
       this.myStage=myStage;
       this.controller = controller;
   }

    /**
     * Sets the number of the Digit which appears on top of the screen as the user plays the game.
     * The digit changes with the change in the users score.
     * This method is included in this class as the change of the digit's number is an animation.
     *
     * @param n       the number of the digit
     */
    private void setNumber(int n) {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            myStage.add(new SelectModelFactory().getActor(2,360-shift,25,30,0,k));
            shift+=30;
        }
    }

    /**
     * Creates the animation timer.
     */
    private void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (controller.changeScore()) {
                    setNumber(controller.getPoints());
                }
                if (controller.gameHasEnded()) {
                    gameEnd();
                }
            }
        };
    }

    /**
     * Stops the animation and the music at the end of the game.
     */
    private void gameEnd(){
        GameViews gameView = new SelectViewFactory().getView("endGame", 0, controller, null,null);
        System.out.print("Game Over\n");
        myStage.stopMusic();
        stop();
        myStage.stop();
        gameView.view(stage);
    }

    /**
     * Stops the timer.
     */
    void stop() {
        timer.stop();
        isRunning = false;
    }

    /**
     * Starts the animation of the game by
     * creating the timer, starting it and playing the game's music.
     */
    public void start() {
        myStage.playMusic();
        createTimer();
        timer.start();
        isRunning = true;
    }

    public boolean getIsRunning(){
        return isRunning;
    }

    @Override
    public void mainControl(long now) {
    }
    @Override
    public boolean gameHasEnded() {
        return false;
    }
    @Override
    public int getPoints() {
        return 0;
    }
    @Override
    public boolean changeScore() {
        return false;
    }
}
