package p4_group_8_repo;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * MyStage class which extends the World class.
 * This class is responsible for the creating of a Stage that is a part
 * of the game world.
 */
public class MyStage extends World{
	private MediaPlayer mediaPlayer;

	/**
	 * {@inheritDoc}
	 * Inherited but not used in this class.
	 */
	@Override
	public void act(long now) {
	}

	/**
	 * Plays the background music of the game.
	 */
	public void playMusic() {
		String musicFile = "src/p4_group_8_repo/music/Frogger Main Song Theme (loop).mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
	}

	/**
	 * Stops the background music.
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
