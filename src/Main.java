import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String command = "";
        boolean gameStatus = false;
        boolean keepPlay = false;
        System.out.println("Welcome to Tic Tac To game!");
        System.out.print("Do you want to play? (Y/N): ");
        String answer = input.next();
        if (answer.equalsIgnoreCase("Y")) {
            keepPlay = true;
        }
        while(keepPlay) {
            BoardHelper game = new BoardHelper();
            gameStatus = true;
            while (gameStatus) {
                System.out.print("Please enter player " + game.getCurPlayer() + " y coordinate: ");
                command = input.next();
                System.out.print("Please enter player " + game.getCurPlayer() + " x coordinate: ");
                command = command + " " + input.next();
                gameStatus = game.process(command);
            }
            System.out.println("Game Over");
            System.out.println("The winner is " + game.getWinner());
            System.out.print("Do you want to play again? (Y/N): ");
            answer = input.next();
            if (answer.equalsIgnoreCase("Y")) {
                keepPlay = true;
            }
        }
    }
}
