package compulsoryPackage;

public class CompulsoryMain {
    public static void main(String[] args) {
        Game sequenceGame = new Game();
        sequenceGame.setGameBoard(new Board(10));
        sequenceGame.addPlayer(new Player("Player1"));
        sequenceGame.addPlayer(new Player("Player2"));

        sequenceGame.printPlayersList();
    }
}
