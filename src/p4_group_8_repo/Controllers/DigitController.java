package p4_group_8_repo.Controllers;

import p4_group_8_repo.Models.Actor;
import p4_group_8_repo.Models.Digit;
import p4_group_8_repo.MyStage;

public class DigitController implements ObjectControllers {
    private Actor digit;
    private MyStage myStage;

    public DigitController(int n, int dim, int x, int y, MyStage myStage){
        digit = new Digit(n, dim, x, y);
        this.myStage=myStage;
        addActorToScene();
    }

    @Override
    public void addActorToScene() {
        myStage.add(digit);

    }

    @Override
    public void setMyStage(MyStage myStage) {
        this.myStage=myStage;
    }

    @Override
    public Actor getActor() {
        return digit;
    }

    @Override
    public void mainControl(long now) {

    }

    @Override
    public boolean getStop() {
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
