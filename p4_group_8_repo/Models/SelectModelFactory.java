package p4_group_8_repo.Models;

/**
 * Factory class following the Factory Design Pattern.
 * Instantiates different Actor objects depending on
 * the one chosen by the client class calling this factory class.
 */
public class SelectModelFactory {

    /**
     * Instantiates different Actor objects that do need
     * any image setting in their constructor.
     * Instantiates End, Digit, Turtle and WetTurtle objects depending
     * on the client class' selection.
     *
     * @param actor choice of actor. 1 for End, 2 for Digit, 3 for Turtle and 4 for WetTurtle.
     * @param x     x position of the object
     * @param y     y position of the object
     * @param dim   dimensions (height and width) of the object's image
     * @param s     speed of the object
     * @param n     number of the Digit object
     * @return     Actor object depending on the choice of actor
     */
    public Actor getActor(int actor, int x, int y, int dim, int s, int n){
        return switch (actor) {
            case 1 -> new End(x,y);
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
     * image setting in their constructor.
     * Instantiates Log and Obstacle objects depending
     * on the client class' selection.
     *
     * @param imageLink imageLink of the object's image to be set
     * @param x         x position of the object
     * @param y         y position of the object
     * @param s         speed of the object
     * @param dim      dimensions (width and height) of the object's image
     * @return         either a Log or an Obstacle object depending on the imageLink
     */
    public Actor getActorWithImage(String imageLink, int x, int y, double s, int dim){
       if(imageLink.contains("log")){
           return new Log(imageLink,dim,x,y,s);
       } else {
           return new Obstacle(imageLink,x,y,s,dim);
       }
    }

}
