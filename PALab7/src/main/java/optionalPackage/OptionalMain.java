package optionalPackage;

public class OptionalMain {
    public static void main(String[] args) throws InterruptedException, CustomException {
        try {
            Game sequenceGame = new Game();
            sequenceGame.setGameBoard(new Board(10));
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
