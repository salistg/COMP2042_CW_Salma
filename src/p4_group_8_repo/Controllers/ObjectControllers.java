package p4_group_8_repo.Controllers;

import p4_group_8_repo.Models.Actor;
import p4_group_8_repo.MyStage;

public interface ObjectControllers {

    void mainControl(long now);
    Actor getActor();
    boolean getStop();
    int getPoints();
    boolean changeScore();
    void addActorToScene();
    void setMyStage(MyStage myStage);
}
