import toolsPack.GameDrawer;

import javax.swing.*;

public class GameStarter extends JFrame {
    public GameStarter() {
        add(new GameDrawer());
    }


    public static void main(String[] args) {
        GameStarter pac = new GameStarter();
        pac.setVisible(true);
        pac.setTitle("Pacman");
        pac.setSize(400, 420);
        pac.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pac.setLocationRelativeTo(null);

    }
}
