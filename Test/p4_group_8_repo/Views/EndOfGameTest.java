package p4_group_8_repo.Views;

import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import p4_group_8_repo.Controllers.AnimalController;
import p4_group_8_repo.JavaFXThreadingRule;
import p4_group_8_repo.Models.Animal;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import static org.junit.Assert.*;

public class EndOfGameTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
    EndOfGame endOfGame;
    Stage stage;

    /**
     * The set up before the tests start.
     *
     * Before the tests run,
     * the Stage and EndOfGame fields
     * are initialized by this method.
     */
    @Before
    public void setUp() {
        stage = new Stage();
        endOfGame = new EndOfGame(new AnimalController(new Animal()));
    }

    /**
     * Tests that the EndOfGameView
     * has no scene as its only functionality
     * is to display the alert box with user's score
     * and update the scores file.
     */
    @Test
    public void testNoScene(){
        assertNull(endOfGame.view(stage));
    }

    /**
     * Tests that the user's score is correctly
     * updated to the scores file.
     *
     * Since the current score is 0 as no
     * game was played. It tests that 0
     * was written to the file.
     */
    @Test
    public void testUpdatingFile(){
        endOfGame.view(stage);
        File file = new File("src/p4_group_8_repo/Files/scores.txt");
        //System.out.println(tail(file));
        assertEquals("0",tail(file));
    }

    /**
     * Method to read the last line of
     * a file.
     *
     * @param file file to read the line from
     * @return the line as a String
     */
    private String tail( File file ) {
        RandomAccessFile fileHandler = null;
        try {
            fileHandler = new RandomAccessFile( file, "r" );
            long fileLength = fileHandler.length() - 1;
            StringBuilder sb = new StringBuilder();

            for(long filePointer = fileLength; filePointer != -1; filePointer--){
                fileHandler.seek( filePointer );
                int readByte = fileHandler.readByte();

                if( readByte == 0xA ) {
                    if( filePointer == fileLength ) {
                        continue;
                    }
                    break;

                } else if( readByte == 0xD ) {
                    if( filePointer == fileLength - 1 ) {
                        continue;
                    }
                    break;
                }

                sb.append( ( char ) readByte );
            }

            return sb.reverse().toString();
        } catch( IOException e ) {
            e.printStackTrace();
            return null;
        } finally {
            if (fileHandler != null )
                try {
                    fileHandler.close();
                } catch (IOException e) {
                    /* ignore */
                }
        }
    }

}