package toolsPack;

import java.awt.*;

public class ActionMover {
    private final GameDrawer game;
    private final Variables gameVars;
    private final SoundPlayer pacPlayer;


    public ActionMover(GameDrawer game, Variables variables, SoundPlayer player) {
        this.game = game;
        this.gameVars = variables;
        this.pacPlayer = player;
    }

    void moveGhosts(Graphics2D g2d) {

        int ghostPosition;
        int directionalPos;

        for (int i = 0; i < gameVars.activeGhostsNumber; i++) {
            if (gameVars.currentGhostsX[i] % gameVars.gridBlocksSize == 0 && gameVars.currentGhostsY[i] % gameVars.gridBlocksSize == 0) {
                ghostPosition = gameVars.currentGhostsX[i] / gameVars.gridBlocksSize
                        + gameVars.totalGridBlocks * (gameVars.currentGhostsY[i] / gameVars.gridBlocksSize);

                directionalPos = 0;

                if ((gameVars.screenMatrixHolder[ghostPosition] & 1) == 0 && gameVars.nextGhostsX[i] != 1) {
                    gameVars.directionalX[directionalPos] = -1;
                    gameVars.directionalY[directionalPos] = 0;
                    directionalPos++;
                }

                if ((gameVars.screenMatrixHolder[ghostPosition] & 2) == 0 && gameVars.nextGhostsY[i] != 1) {
                    gameVars.directionalX[directionalPos] = 0;
                    gameVars.directionalY[directionalPos] = -1;
                    directionalPos++;
                }

                if ((gameVars.screenMatrixHolder[ghostPosition] & 4) == 0 && gameVars.nextGhostsX[i] != -1) {
                    gameVars.directionalX[directionalPos] = 1;
                    gameVars.directionalY[directionalPos] = 0;
                    directionalPos++;
                }

                if ((gameVars.screenMatrixHolder[ghostPosition] & 8) == 0 && gameVars.nextGhostsY[i] != -1) {
                    gameVars.directionalX[directionalPos] = 0;
                    gameVars.directionalY[directionalPos] = 1;
                    directionalPos++;
                }

                if (directionalPos == 0) {

                    if ((gameVars.screenMatrixHolder[ghostPosition] & 15) == 15) {
                        gameVars.nextGhostsX[i] = 0;
                        gameVars.nextGhostsY[i] = 0;
                    } else {
                        gameVars.nextGhostsX[i] = -gameVars.nextGhostsX[i];
                        gameVars.nextGhostsY[i] = -gameVars.nextGhostsY[i];
                    }

                } else {

                    directionalPos = (int) (Math.random() * directionalPos);

                    if (directionalPos > 3) {
                        directionalPos = 3;
                    }

                    gameVars.nextGhostsX[i] = gameVars.directionalX[directionalPos];
                    gameVars.nextGhostsY[i] = gameVars.directionalY[directionalPos];
                }

            }

            gameVars.currentGhostsX[i] = gameVars.currentGhostsX[i] + (gameVars.nextGhostsX[i] * gameVars.ghostSpeed[i]);
            gameVars.currentGhostsY[i] = gameVars.currentGhostsY[i] + (gameVars.nextGhostsY[i] * gameVars.ghostSpeed[i]);
            game.drawGhost(g2d, gameVars.currentGhostsX[i] + 1, gameVars.currentGhostsY[i] + 1);

            if (gameVars.currentPacmanX > (gameVars.currentGhostsX[i] - 12)
                    && gameVars.currentPacmanX < (gameVars.currentGhostsX[i] + 12)
                    && gameVars.currentPacmanY > (gameVars.currentGhostsY[i] - 12)
                    && gameVars.currentPacmanY < (gameVars.currentGhostsY[i] + 12)
                    && gameVars.inGame) {

                gameVars.dying = true;
                pacPlayer.playSound(
                        "pacman_die.wav");
            }
        }
    }

    void movePacman() {

        int nextMatrixPos;
        short matrixValue;

        if (gameVars.currentPacmanX % gameVars.gridBlocksSize == 0 && gameVars.currentPacmanY % gameVars.gridBlocksSize == 0) {
            nextMatrixPos = gameVars.currentPacmanX / gameVars.gridBlocksSize +
                    gameVars.totalGridBlocks * (gameVars.currentPacmanY / gameVars.gridBlocksSize);
            matrixValue = gameVars.screenMatrixHolder[nextMatrixPos];

            if ((matrixValue & 16) != 0) {
                gameVars.screenMatrixHolder[nextMatrixPos] = (short) (matrixValue & 15);
                pacPlayer.playSound(
                        "pacman_eat.wav");
                gameVars.currentScore++;
            }

            if (gameVars.nextDirectionalX != 0 || gameVars.nextDirectionalY != 0) {
                if (!((gameVars.nextDirectionalX == -1 && gameVars.nextDirectionalY == 0 && (matrixValue & 1) != 0)
                        || (gameVars.nextDirectionalX == 1 && gameVars.nextDirectionalY == 0 && (matrixValue & 4) != 0)
                        || (gameVars.nextDirectionalX == 0 && gameVars.nextDirectionalY == -1 && (matrixValue & 2) != 0)
                        || (gameVars.nextDirectionalX == 0 && gameVars.nextDirectionalY == 1 && (matrixValue & 8) != 0))) {
                    gameVars.nextPacmanX = gameVars.nextDirectionalX;
                    gameVars.nextPacmanY = gameVars.nextDirectionalY;
                }
            }

            // This will check if Pacman is not moving ( Stuck in a wall or something )
            if ((gameVars.nextPacmanX == -1 && gameVars.nextPacmanY == 0 && (matrixValue & 1) != 0)
                    || (gameVars.nextPacmanX == 1 && gameVars.nextPacmanY == 0 && (matrixValue & 4) != 0)
                    || (gameVars.nextPacmanX == 0 && gameVars.nextPacmanY == -1 && (matrixValue & 2) != 0)
                    || (gameVars.nextPacmanX == 0 && gameVars.nextPacmanY == 1 && (matrixValue & 8) != 0)) {
                gameVars.nextPacmanX = 0;
                gameVars.nextPacmanY = 0;
            }
        }
        int pacmanSpeed = 4;
        gameVars.currentPacmanX = gameVars.currentPacmanX + pacmanSpeed * gameVars.nextPacmanX;
        gameVars.currentPacmanY = gameVars.currentPacmanY + pacmanSpeed * gameVars.nextPacmanY;
    }
}
