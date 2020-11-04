package p4_group_8_repo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class facilitates the fetching of data from the Scores file.
 * It uses a String Property as the scores, stored as strings,
 * will be observed by the table view in the EndScreen class
 * and the table should be able to read those values and sort them accordingly.
 */
public class ScoresData {
    //instantiating and declaring a string property scores
   private final StringProperty scores = new SimpleStringProperty();

    /**
     * Property accessor.
     * Returns the score as a String Property object.
     *
     * @return the string property
     */
    public final StringProperty scoreProperty(){
        return this.scores;
    }

    /**
     * Gets the value of the String property.
     *
     * @return String in the String property
     */
    public final java.lang.String getScores(){
        return this.scoreProperty().get();
    }

    /**
     * Sets the value of the String Property.
     *
     * @param scores String read from the file
     */
    public final void setScores(final java.lang.String scores){
        this.scoreProperty().set(scores);
    }
}
