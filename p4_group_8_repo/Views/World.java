package p4_group_8_repo.Views;


import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import p4_group_8_repo.Models.Actor;


/**
 * This class represents a 2D world in which the Actors of the game live.
 */
public abstract class World extends Pane {
    /**
     * An AnimationTimer for the animation of the actors
     */
   private AnimationTimer timer = null;

    /**
     * Constructor that instantiates a new World.
     */
    public World() {
    	
    	sceneProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                newValue.setOnKeyReleased(event -> {
                    if(getOnKeyReleased() != null)
                        getOnKeyReleased().handle(event);
                    List<Actor> myActors = getObjects(Actor.class);
                    for (Actor anActor: myActors) {
                        if (anActor.getOnKeyReleased() != null) {
                            anActor.getOnKeyReleased().handle(event);
                        }
                    }
                });

                newValue.setOnKeyPressed(event -> {
                    if(getOnKeyPressed() != null)
                        getOnKeyPressed().handle(event);
                    List<Actor> myActors = getObjects(Actor.class);
                    for (Actor anActor: myActors) {
                        if (anActor.getOnKeyPressed() != null) {
                            anActor.getOnKeyPressed().handle(event);
                        }
                    }
                });
            }

        });
    }

    /**
     * Creates an AnimationTimer and creates a list of objects under the Actor class.
     * Calls the act method on these objects.
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }

    /**
     * Starts the animation timer.
     */
    public void start() {
    	createTimer();
        timer.start();
    }

    /**
     * Stops the animation timer.
     */
    public void stop() {
        timer.stop();
    }

    /**
     * Adds an object of type Actor as a child of
     * a World type object.
     *
     * @param actor the actor
     */
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    /**
     * Gets the children objects of the classes that extend the Actor class.
     *
     * @param <A> the type parameter. The type is a class extending Actor class.
     * @param cls the class
     * @return the array of objects
     */
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }

    /**
     * Abstract method to be inherited by all classes extending the World class.
     * Dictates how the objects should act at a certain timeframe or
     * under certain conditions.
     * Allows objects to perform some action.
     *
     * @param now timestamp of the current frame in nanoseconds
     */
    public abstract void act(long now);

    /**
     * Abstract method to be inherited by all classes extending the World class.
     * Plays the music of the game.
     */
    public abstract void playMusic();

    /**
     * Abstract method to be inherited by all classes extending the World class.
     * Stops the music of the game.
     */
    public abstract void stopMusic();
}
