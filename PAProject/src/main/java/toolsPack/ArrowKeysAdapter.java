package toolsPack;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ArrowKeysAdapter extends KeyAdapter {
    private final GameDrawer game;

    public ArrowKeysAdapter(GameDrawer game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (game.gameVars.inGame) {
            if (key == KeyEvent.VK_LEFT) {
                game.gameVars.nextDirectionalX = -1;
                game.gameVars.nextDirectionalY = 0;
            } else if (key == KeyEvent.VK_RIGHT) {
                game.gameVars.nextDirectionalX = 1;
                game.gameVars.nextDirectionalY = 0;
            } else if (key == KeyEvent.VK_UP) {
                game.gameVars.nextDirectionalX = 0;
                game.gameVars.nextDirectionalY = -1;
            } else if (key == KeyEvent.VK_DOWN) {
                game.gameVars.nextDirectionalX = 0;
                game.gameVars.nextDirectionalY = 1;
            } else if (key == KeyEvent.VK_ESCAPE && game.gameVars.actionSlower.isRunning()) {
                game.gameVars.inGame = false;
                game.pacData.soundPlayer.stopLoop();
            }
        } else {
            if (key == KeyEvent.VK_SPACE) {
                game.gameVars.inGame = true;
                game.pacData.soundPlayer.startLoop
                        ("pacman_siren.wav");
                game.pacData.initGame();
            }
        }
    }
}
