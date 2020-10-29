package p4_group_8_repo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ScoresData {
    StringProperty number = new SimpleStringProperty();
    StringProperty scores = new SimpleStringProperty();

    public final StringProperty numberProperty(){
        return this.number;
    }

    public final java.lang.String getNumber(){
        return this.numberProperty().get();
    }

    public final void setNumber(final java.lang.String number){
        this.scoreProperty().set(number);
    }

    public final StringProperty scoreProperty(){
        return this.scores;
    }

    public final java.lang.String getScores(){
        return this.scoreProperty().get();
    }

    public final void setScores(final java.lang.String scores){
        this.scoreProperty().set(scores);
    }
}
