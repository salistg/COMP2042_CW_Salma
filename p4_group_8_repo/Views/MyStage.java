package p4_group_8_repo.Views;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * MyStage class which extends the World class.
 * Creates a Stage that is a part
 * of the game World and will contain the different
 * actors of the game.
 */
public class MyStage extends World {
	/**
	 * MediaPlayer object to play the game's music
	 */
	private MediaPlayer mediaPlayer = null;
	private boolean isPlaying = false;

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
		isPlaying = true;
	}

	/**
	 * Stops the background music.
	 */
	public void stopMusic() {
		mediaPlayer.stop();
		isPlaying = false;
	}

	/**
	 * Returns a boolean to indicate
	 * whether music is playing or not.
	 *
	 * @return true if music is playing false if not
	 */
	public boolean getIsMusicPlaying(){
		return isPlaying;
	}

}
