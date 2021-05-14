package toolsPack;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundPlayer {
    private final static String melodiesPath = Variables.absoluteDirectoryPath + "\\src\\main\\resources\\music\\";
    Clip audioLoop;
    AudioInputStream loopStream;

    public void playSound(String fileName) {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream
                    (new File(melodiesPath + fileName));
            clip.open(inputStream);
            clip.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void startLoop(String fileName){
        try {
            audioLoop = AudioSystem.getClip();
            loopStream = AudioSystem.getAudioInputStream(
                    new File(melodiesPath + fileName));
            audioLoop.open(loopStream);
            audioLoop.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void stopLoop(){
        try {
            audioLoop.stop();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
