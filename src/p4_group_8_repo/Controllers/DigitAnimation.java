package p4_group_8_repo.Controllers;

import javafx.animation.AnimationTimer;
import javafx.stage.Stage;
import p4_group_8_repo.Models.Digit;
import p4_group_8_repo.Views.GameViews;
import p4_group_8_repo.Views.World;

/**
 * This class is responsible for starting and stopping the animation of the Digit
 * objects in the game. </br>
 * It uses an AnimationTimer and its different methods.
 */
public class DigitAnimation implements ActorControllers {
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
  private final ActorControllers controller;
    /**
     * A World object that contains the actors of the game
     */
   private final World myStage;
    /**
     * Level of the game chosen by the player.
     */
   private final int level;

    /**
     * Instantiates a new DigitController.
     *
     * @param stage stage of the application
     * @param myStage the world that the Actors of the game are a part of
     * @param controller object controller for the controls of the actors
     * @param level the level of the game chosen by the user
     */
   public DigitAnimation(Stage stage, World myStage, ActorControllers controller, int level){
       this.stage=stage;
       this.myStage=myStage;
       this.controller = controller;
       this.level=level;
   }


    /**
     * Sets the number of the Digit which appears on
     * top of the screen as the user plays the game.
     * The digit changes as the score in the game changes.
     *
     * @param n       the number of the digit
     */
    private void setNumber(int n) {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            myStage.getChildren().remove(Digit.class);
            myStage.add(new SelectModelFactory().getActor(2,360-shift,25,30,0, k));
            shift+=30;
        }
    }

//    private void setDigit(int shift, int k){
//        Actor digit = new SelectModelFactory().getActor(2,360-shift,25,30,0, k);
//
//    }

    /**
     * Creates the animation timer.
     */
    private void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(controller.hasGameEnded())
                    gameEnd();
                else if (controller.changeScore())
                    setNumber(controller.getPoints());
            }
        };

    }

    /**
     * Stops the animation and the music at the end of the game.
     */
    private void gameEnd(){
        GameViews gameView = new SelectViewFactory().getView("endGame", level, controller, null);
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
    }

    /**
     * Starts the animation by
     * creating the timer, starting it and playing the game's music.
     */
    public void start() {
        createTimer();
        timer.start();
    }

    /**
     * {@inheritDoc} </br>
     * 
     * @param now the current timestamp of the frame in nanoseconds
     */
    @Override
    public void mainControl(long now) {
    }

    /**
     * {@inheritDoc} </br>
     * 
     * @return false
     */
    @Override
    public boolean hasGameEnded() {
        return false;
    }

    /**
     * {@inheritDoc} </br>
     * 
     * @return 0
     */
    @Override
    public int getPoints() {
        return 0;
    }

    /**
     * {@inheritDoc} </br>
     * 
     * @return false
     */
    @Override
    public boolean changeScore() {
        return false;
    }
}
