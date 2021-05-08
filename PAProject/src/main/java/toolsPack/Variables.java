package toolsPack;

import javax.swing.*;
import java.awt.*;

/*
     MAP LEGEND
     0 = empty block ( one that will be filled with a blue square )
     1 = left edge of a block
     2 = upper edge of a block
     4 = right edge of a block
     8 = bottom edge of a block
     16 = pacman food ( a white circle )
 */

public class Variables {
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
    public short[] screenMatrixHolder;
    public Timer actionSlower; // this is a separate thread that intervenes to allow actions to be drawn correctly
    public final int gridBlocksSize = 24;
    public final int totalGridBlocks = 15;
    public final int currentScreenSize = totalGridBlocks * gridBlocksSize;
    public final short[] initialMapData = {
            19, 26, 26, 26, 18, 18, 26, 26, 26, 18, 18, 26, 26, 26, 22,
            21, 0, 0, 0, 17, 20, 0, 0, 0, 17, 20, 0, 0, 0, 21,
            21, 0, 0, 0, 17, 16, 18, 18, 18, 16, 20, 0, 0, 0, 21,
            17, 18, 18, 18, 16, 16, 16, 16, 16, 16, 16, 18, 18, 18, 20,
            17, 24, 24, 24, 24, 28, 17, 24, 20, 25, 24, 24, 24, 24, 20,
            17, 18, 18, 18, 18, 18, 28, 0, 25, 18, 18, 18, 18, 18, 20,
            17, 16, 16, 16, 16, 20, 0, 0, 0, 17, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 20, 0, 0, 0, 17, 16, 16, 16, 16, 20,
            17, 24, 24, 24, 24, 24, 22, 0, 19, 24, 24, 24, 24, 24, 20,
            17, 18, 18, 18, 18, 22, 17, 18, 20, 19, 18, 18, 18, 18, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 24, 24, 24, 16, 16, 16, 16, 16, 16, 16, 24, 24, 24, 20,
            21, 0, 0, 0, 17, 16, 24, 24, 24, 16, 20, 0, 0, 0, 21,
            21, 0, 0, 0, 17, 20, 0, 0, 0, 17, 20, 0, 0, 0, 21,
            25, 26, 26, 26, 24, 24, 26, 26, 26, 24, 24, 26, 26, 26, 28
    };

}
