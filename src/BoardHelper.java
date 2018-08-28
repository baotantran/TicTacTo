public class BoardHelper {
    private int xcoor;
    private int ycoor;
    private Board game;
    boolean gameOn;

    private static final char PLAYER1 = 'X';
    private static final char PLAYER2 = 'O';

    public BoardHelper () {
        game = new Board();
        game.draw();
        gameOn = true;
    }

    // return true if game is still playable false otherwise
    public boolean process(String command) {
        if (gameOn) {
            String[] array = command.split(" ");
            xcoor = Integer.parseInt(array[0]);
            ycoor = Integer.parseInt(array[1]);
            gameOn = game.setPlayer(xcoor, ycoor);
            game.draw();
        } else {
            System.out.println("Game Over");
            return false;
        }
        gameOn = !(game.getCapcity() || game.getStatus());
        return gameOn;
    }

    public int getCurPlayer() {
        return game.getCurPlayer();
    }

    public String getWinner() {
        if(game.getWinner() == PLAYER1) return "PLAYER1";
        return "PLAYER2";
    }
}
