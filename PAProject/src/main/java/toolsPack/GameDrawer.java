package toolsPack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameDrawer extends JPanel implements ActionListener {
    public Variables gameVars = new Variables();
    public PacManData pacData = new PacManData(this);

    public GameDrawer() {
        pacData.soundPlayer.playSound("pacman_start.wav");
        pacData.loadImages();
        pacData.initVariables();
        addKeyListener(new ArrowKeysAdapter(this));
        setFocusable(true);
        pacData.initGame();
    }

    private void showIntroScreen(Graphics2D g2d) {

        String startScreenString = "Press SPACE to start";
        g2d.setColor(Color.yellow);
        g2d.drawString(startScreenString, (gameVars.currentScreenSize) / 4, 175);
    }

    private void drawScore(Graphics2D g2d) {
        g2d.setFont(gameVars.startingScreenFont);
        g2d.setColor(new Color(5, 181, 79));
        String score = "Score: " + gameVars.currentScore;
        g2d.drawString(score, gameVars.currentScreenSize / 2 + 96, gameVars.currentScreenSize + 16);

        for (int i = 0; i < gameVars.livesLeft; i++) {
            g2d.drawImage(gameVars.heart, i * 28 + 8, gameVars.currentScreenSize + 1, this);
        }
    }

    void drawGhost(Graphics2D g2d, int x, int y) {
        g2d.drawImage(gameVars.ghost, x, y, this);
    }

    void drawPacman(Graphics2D g2d) {

        if (gameVars.nextDirectionalX == -1) {
            g2d.drawImage(gameVars.pacLeft, gameVars.currentPacmanX + 1, gameVars.currentPacmanY + 1, this);
        } else if (gameVars.nextDirectionalX == 1) {
            g2d.drawImage(gameVars.pacRight, gameVars.currentPacmanX + 1, gameVars.currentPacmanY + 1, this);
        } else if (gameVars.nextDirectionalY == -1) {
            g2d.drawImage(gameVars.pacUp, gameVars.currentPacmanX + 1, gameVars.currentPacmanY + 1, this);
        } else {
            g2d.drawImage(gameVars.pacDown, gameVars.currentPacmanX + 1, gameVars.currentPacmanY + 1, this);
        }
    }

    private void drawMaze(Graphics2D g2d) {

        int currentIterator = 0;
        int matrixPosX, matrixPosY;

        for (matrixPosY = 0; matrixPosY < gameVars.currentScreenSize; matrixPosY += gameVars.gridBlocksSize) {
            for (matrixPosX = 0; matrixPosX < gameVars.currentScreenSize; matrixPosX += gameVars.gridBlocksSize) {

                g2d.setColor(new Color(0, 72, 251));
                g2d.setStroke(new BasicStroke(5));

                if ((gameVars.initialMapData[currentIterator] == 0)) {
                    g2d.fillRect(matrixPosX, matrixPosY,
                            gameVars.gridBlocksSize, gameVars.gridBlocksSize);
                }

                if ((gameVars.screenMatrixHolder[currentIterator] & 1) != 0) {
                    g2d.drawLine(matrixPosX, matrixPosY, matrixPosX,
                            matrixPosY + gameVars.gridBlocksSize - 1);
                }

                if ((gameVars.screenMatrixHolder[currentIterator] & 2) != 0) {
                    g2d.drawLine(matrixPosX, matrixPosY, matrixPosX + gameVars.gridBlocksSize - 1,
                            matrixPosY);
                }

                if ((gameVars.screenMatrixHolder[currentIterator] & 4) != 0) {
                    g2d.drawLine(matrixPosX + gameVars.gridBlocksSize - 1, matrixPosY,
                            matrixPosX + gameVars.gridBlocksSize - 1,
                            matrixPosY + gameVars.gridBlocksSize - 1);
                }

                if ((gameVars.screenMatrixHolder[currentIterator] & 8) != 0) {
                    g2d.drawLine(matrixPosX, matrixPosY + gameVars.gridBlocksSize - 1,
                            matrixPosX + gameVars.gridBlocksSize - 1,
                            matrixPosY + gameVars.gridBlocksSize - 1);
                }

                if ((gameVars.screenMatrixHolder[currentIterator] & 16) != 0) {
                    g2d.setColor(new Color(255, 255, 255));
                    g2d.fillOval(matrixPosX + 10, matrixPosY + 10, 6, 6);
                }

                currentIterator++;
            }
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, gameVars.canvasDimension.width, gameVars.canvasDimension.height);

        drawMaze(g2d);
        drawScore(g2d);

        if (gameVars.inGame) {
            pacData.playGame(g2d);
        } else {
            showIntroScreen(g2d);
        }

        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}