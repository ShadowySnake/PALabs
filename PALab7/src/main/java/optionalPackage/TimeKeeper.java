package optionalPackage;

import java.util.concurrent.TimeUnit;

public class TimeKeeper extends Thread{
    private int totalTime;
    private final Board gameBoard;

    @Override
    public void run() {
        while (totalTime != 0 && !gameBoard.emptySequence()) {
            System.out.println(totalTime);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            totalTime--;
        }
        System.out.println(totalTime);
    }

    public TimeKeeper(int inputTime, Board inputBoard){
        this.totalTime = inputTime;
        this.gameBoard = inputBoard;
    }

}