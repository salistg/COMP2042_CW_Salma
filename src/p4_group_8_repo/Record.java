package p4_group_8_repo;

import javafx.beans.property.SimpleStringProperty;

public class Record {

    private SimpleStringProperty number, scores;

    public String getNumber(){
        return number.get();
    }

    public String getScores(){
        return scores.get();
    }

    Record(String number, String scores){
        this.number = new SimpleStringProperty(number);
        this.scores = new SimpleStringProperty(scores);
    }
}
