package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class TimerAndStart {
    AnimationTimer timer;



    public void setNumber(int n, MyStage myStage) {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            myStage.add(new Digit(k, 30, 360 - shift, 25));
            shift+=30;
        }
    }

    public void createTimer(Stage stage, Animal animal, MyStage myStage) {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (animal.changeScore()) {
                    setNumber(animal.getPoints(),myStage);
                }
                if (animal.getStop()) {
                    System.out.print("Game Over\n");
                    myStage.stopMusic();
                    stop();
                    myStage.stop();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Congratulations!");
                    alert.setHeaderText("Your High Score: " + animal.getPoints());
                    animal.updateFile(animal.getPoints());
                    alert.show();

                    EndScreen endScreen = new EndScreen();
                    try {
                        Scene endScene = endScreen.start(stage);
                        stage.setScene(endScene);
                        stage.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        };
    }

    public void stop() {
        timer.stop();
    }

    public void start(Stage stage, Animal animal, MyStage myStage, boolean play) {
        if(play)
            myStage.playMusic();
        createTimer(stage, animal, myStage);
        timer.start();
    }
}
