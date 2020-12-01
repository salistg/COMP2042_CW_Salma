package p4_group_8_repo.Controllers;

import p4_group_8_repo.Models.*;

/**
 * A factory class following the Factory Design Pattern.
 * Allows the caller to select which Actor object
 * to instantiate. </br>
 *
 * This reduces coupling between classes
 * as the caller is not dependent on the class they're calling directly. </br>
 * If any changes occur to the class being called, the changes
 * will only be reflected on the factory class while
 * the caller remains in the unknown about it.
 */
public class SelectModelFactory {

    /**
     * Instantiates different Actor objects that don't need
     * any image setting in their constructor. </br>
     * Instantiates End, Digit, Turtle and WetTurtle objects depending
     * on the client class' selection.
     *
     * @param actor choice of actor. 1 for End, 2 for Digit, 3 for Turtle and 4 for WetTurtle.
     * @param x     x position of the object
     * @param y     y position of the object
     * @param dim   dimensions (height and width) of the object's image
     * @param s     speed of the object
     * @param n     number for the Digit object
     * @return     Actor object depending on the choice of the client class
     */
    public Actor getActor(int actor, int x, int y, int dim, int s, int n){
        return switch (actor) {
            case 1 -> new EndGoal(x,y);
            case 2 -> new Digit(n,dim,x,y);
            case 3 -> new Turtle(x,y,s,dim);
            case 4 -> new WetTurtle(x,y,s,dim);
            default -> null;
        };
    }

    /**
     * Instantiates a new Animal object.
     * Animal object is instantiated in its own method
     * as it doesn't require any parameters.
     *
     * @return Animal object
     */
    public Actor getAnimal(){
        return new Animal();
    }

    /**
     * Instantiates different Actor objects that need
     * image setting in their constructor. </br>
     * Instantiates Log and Obstacle objects depending
     * on the client class' selection.
     *
     * @param imageLink imageLink of the object's image
     * @param x         x position of the object
     * @param y         y position of the object
     * @param s         speed of the object
     * @param dim      dimensions (width and height) of the object's image
     * @return         either a Log or an Obstacle object depending on choice by the client class
     */
    public Actor getActorWithImage(String imageLink, int x, int y, double s, int dim){
       if(imageLink.contains("log") || imageLink.contains("crocodile")){
           return new Log(imageLink,dim,x,y,s);
       } else {
           return new Obstacle(imageLink,x,y,s,dim);
       }
    }

}
