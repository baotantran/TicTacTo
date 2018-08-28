public class BoardHelper {
    private int xcoor;
    private int ycoor;
    private Board game;

    public BoardHelper () {
        game = new Board();
    }

    public boolean process(String command) {
        String[] array = command.split(" ");
        xcoor = Integer.parseInt(array[0]);
        ycoor = Integer.parseInt(array[1]);
        int gameFull = game.setPlayer(xcoor, ycoor);
        game.getStatus();
        if (game.getStatus() || gameFull == -1) {
            System.out.println("Game Over");
            return false;
        } else {
            game.draw();
        }
        return true;

    }
}
