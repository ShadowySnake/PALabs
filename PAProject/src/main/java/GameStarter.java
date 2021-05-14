import toolsPack.GameDrawer;

import javax.swing.*;
import java.io.IOException;

public class GameStarter extends JFrame {
    public GameStarter() throws IOException {
        add(new GameDrawer());
    }


    public static void main(String[] args) {
        try {
            GameStarter pac = new GameStarter();
            pac.setVisible(true);
            pac.setTitle("Pacman");
            pac.setSize(400, 420);
            pac.setDefaultCloseOperation(EXIT_ON_CLOSE);
            pac.setLocationRelativeTo(null);
        }catch (Exception e){
            System.err.println(e);
        }
    }
}
