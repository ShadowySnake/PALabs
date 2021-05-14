package toolsPack;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Variables {
    public static String absoluteDirectoryPath = System.getProperty("user.dir");
    public final Font startingScreenFont = new Font("Comic Sans MS", Font.BOLD, 20);
    public final int maximumNumberOfAllowedGhosts = 12;
    public final int[] allowedCharacterSpeed = {1, 2, 3, 8, 9, 10};
    public final int maximumAllowedSpeed = 8;
    public Dimension canvasDimension;
    public boolean inGame = false;
    public boolean dying = false;
    public int activeGhostsNumber;
    public int livesLeft, currentScore;
    public int[] directionalX, directionalY;
    public int[] currentGhostsX, currentGhostsY, nextGhostsX, nextGhostsY, ghostSpeed;
    public Image heart, ghost, pacUp, pacDown, pacLeft, pacRight;
    public int currentPacmanX, currentPacmanY, nextPacmanX, nextPacmanY;
    public int nextDirectionalX, nextDirectionalY;
    public int currentSpeed;
    public int[] screenMatrixHolder;
    public Timer actionSlower; // this is a separate thread that intervenes to allow actions to be drawn correctly
    public final int gridBlocksSize = 24;
    public final int totalGridBlocks = 15;
    public final int currentScreenSize = totalGridBlocks * gridBlocksSize;
    public final int[] initialMapData = MapReader.initialPacMap(totalGridBlocks);

    public Variables() throws IOException {
    }
}
