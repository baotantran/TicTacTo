import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String command = "";
        BoardHelper game = new BoardHelper();
        boolean gameStatus = true;
        while(gameStatus) {
            System.out.print("Please Enter your x coordinate: ");
            command = input.next();
            System.out.print("Please Enter your y coordinate: ");
            command = command + " " + input.next();
            gameStatus = game.process(command);
        }
    }
}
