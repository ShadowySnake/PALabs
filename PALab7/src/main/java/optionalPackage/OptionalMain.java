package optionalPackage;

public class OptionalMain {
    public static void main(String[] args) throws InterruptedException, CustomException {
        try {
            Board gameBoard = new Board(10);
            Game sequenceGame = new Game();
            sequenceGame.setGameBoard(gameBoard);
            sequenceGame.addPlayer(new Player("Player1", "Auto"));
            sequenceGame.addPlayer(new Player("Player2","Auto"));

            sequenceGame.printPlayersList();
            sequenceGame.start();
        }
        catch (InterruptedException | CustomException e){
            e.printStackTrace();
        }
    }
}
