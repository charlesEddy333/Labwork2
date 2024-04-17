import java.util.Random;

public class Dice {
    private static final Random randomNumbers = new Random();
    private enum Status {CONTINUE, WON, LOST};
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_ELEVEN = 11;
    private static final int BOX_CARS = 12;

    public static void main(String[] args) {
        int myPoint = 0; // point if no win or loss on first roll
        Status gameStatus; // can contain CONTINUE, WON, LOST
        int sumOfDice = rollDice(); // first roll of the dice

        // determine game status and point based on first roll
        switch (sumOfDice) {
            case SEVEN: // win with 7 on first roll
            case YO_ELEVEN: // WIN WITH 11 ON first roll
                gameStatus = Status.WON;
                break;
            case SNAKE_EYES: // LOSE WITH 2 ON FIRST ROLL
            case TREY: // LOSE WITH 3 ON FIRST ROLL
            case BOX_CARS: // LOSE WITH 12 ON FIRST ROLL
                gameStatus = Status.LOST;
                break;
            default: // did not win or lose, so remember point
                gameStatus = Status.CONTINUE; // game is not over
                myPoint = sumOfDice; // remember the point
                System.out.printf("Point is %d\n", myPoint);
                break;
        }

        // while game is not complete
        while (gameStatus == Status.CONTINUE) {
            sumOfDice = rollDice(); // roll dice again
            // determine game status
            if (sumOfDice == myPoint) // win by making point
                gameStatus = Status.WON;
            else if (sumOfDice == SEVEN) // LOSE BY ROLLING 7 BEFORE
                gameStatus = Status.LOST;
        }

        // DISPLAY WON OR LOST MESSAGE
        if (gameStatus == Status.WON)
            System.out.println("PLAYER WINS");
        else
            System.out.println("PLAYER LOSES");
    }

    // roll dice, calculate sum and display result
    public static int rollDice() {
        // pick random die values
        int die1 = 1 + randomNumbers.nextInt(6); // first die roll
        int die2 = 1 + randomNumbers.nextInt(6); // second die roll
        int sum = die1 + die2; // sum of die values

        // display results of this roll
        System.out.printf("Player rolled %d + %d = %d\n", die1, die2, sum);
        return sum;
    }
}