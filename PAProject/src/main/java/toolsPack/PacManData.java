package toolsPack;

import javax.swing.*;
import java.awt.*;

public class PacManData {
    public final SoundPlayer soundPlayer = new SoundPlayer();
    private final Variables gameVars;
    private final GameDrawer game;
    private final ActionMover moverMaker;

    public PacManData(GameDrawer game) {
        this.game = game;
        this.gameVars = this.game.gameVars;
        this.moverMaker = new ActionMover(game, gameVars, soundPlayer);
    }

    void loadImages() {
        String imagesPath = "D:\\Java\\PALabs\\PAProject\\src\\main\\resources\\characters\\";
        // the path is subject to change, depending on whoever is running this game
        gameVars.pacDown = new ImageIcon(imagesPath + "down.gif").getImage();
        gameVars.pacUp = new ImageIcon(imagesPath + "up.gif").getImage();
        gameVars.pacLeft = new ImageIcon(imagesPath + "left.gif").getImage();
        gameVars.pacRight = new ImageIcon(imagesPath + "right.gif").getImage();
        gameVars.ghost = new ImageIcon(imagesPath + "ghost.gif").getImage();
        gameVars.heart = new ImageIcon(imagesPath + "heart.png").getImage();

    }

    void initVariables() {

        gameVars.screenMatrixHolder = new short[gameVars.totalGridBlocks * gameVars.totalGridBlocks];
        gameVars.canvasDimension = new Dimension(1000, 1000);
        gameVars.currentGhostsX = new int[gameVars.maximumNumberOfAllowedGhosts];
        gameVars.nextGhostsX = new int[gameVars.maximumNumberOfAllowedGhosts];
        gameVars.currentGhostsY = new int[gameVars.maximumNumberOfAllowedGhosts];
        gameVars.nextGhostsY = new int[gameVars.maximumNumberOfAllowedGhosts];
        gameVars.ghostSpeed = new int[gameVars.maximumNumberOfAllowedGhosts];
        gameVars.directionalX = new int[4];
        gameVars.directionalY = new int[4];

        gameVars.actionSlower = new Timer(60, game);
        // as i said before, a thread that allows actions to run by placing a delay is needed
        // sometimes the game may bug out and the map may not render properly without this "TIMER" delayer
        gameVars.actionSlower.start();
    }

    void initGame() {

        gameVars.livesLeft = 3;
        gameVars.currentScore = 0;
        initLevel();
        gameVars.activeGhostsNumber = 4;
        gameVars.currentSpeed = 1;
    }

    void initLevel() {

        int i;
        for (i = 0; i < gameVars.totalGridBlocks * gameVars.totalGridBlocks; i++) {
            gameVars.screenMatrixHolder[i] = gameVars.initialMapData[i];
        }

        continueLevel();
    }

    void playGame(Graphics2D g2d) {

        if (gameVars.dying) {

            death();

        } else {

            moverMaker.movePacman();
            game.drawPacman(g2d);
            moverMaker.moveGhosts(g2d);
            checkMaze();
        }
    }

    private void death() {

        gameVars.livesLeft--;

        if (gameVars.livesLeft == 0) {
            gameVars.inGame = false;
            soundPlayer.stopLoop();
        }

        continueLevel();
    }

    void continueLevel() {

        int dx = 1;
        int random;

        for (int i = 0; i < gameVars.activeGhostsNumber; i++) {

            gameVars.currentGhostsY[i] = 4 * gameVars.gridBlocksSize; //start position
            gameVars.currentGhostsX[i] = 4 * gameVars.gridBlocksSize;
            gameVars.nextGhostsY[i] = 0;
            gameVars.nextGhostsX[i] = dx;
            dx = -dx;
            random = (int) (Math.random() * (gameVars.currentSpeed + 1));

            if (random > gameVars.currentSpeed) {
                random = gameVars.currentSpeed;
            }

            gameVars.ghostSpeed[i] = gameVars.allowedCharacterSpeed[random];
        }

        gameVars.currentPacmanX = 7 * gameVars.gridBlocksSize;  //start position
        gameVars.currentPacmanY = 11 * gameVars.gridBlocksSize;
        gameVars.nextPacmanX = 0;    //reset direction move
        gameVars.nextPacmanY = 0;
        gameVars.nextDirectionalX = 0;        // reset direction controls
        gameVars.nextDirectionalY = 0;
        gameVars.dying = false;
    }

    private void checkMaze() {

        int currentIterator = 0;
        boolean noPelletsLeft = true;

        while ((currentIterator < gameVars.totalGridBlocks * gameVars.totalGridBlocks)) {

            if (gameVars.screenMatrixHolder[currentIterator] >= 16) {
                //System.out.println("We are on: " + i + " with the value " + gameVars.screenData[i]);
                noPelletsLeft = false;
                break;
            }

            currentIterator++;
        }

        if (noPelletsLeft) {

            gameVars.currentScore += 50;

            if (gameVars.activeGhostsNumber < gameVars.maximumNumberOfAllowedGhosts) {
                gameVars.activeGhostsNumber++;
            }

            if (gameVars.currentSpeed < gameVars.maximumAllowedSpeed) {
                gameVars.currentSpeed++;
            }

            initLevel();
        }
    }

}
