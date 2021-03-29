package compulsoryPackage;

public class Player {
    private final String playerName;
    private Game currentGame;

    public Player(String givenName) {
        this.playerName = givenName;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    public String getPlayerName() {
        return playerName;
    }
}
