public class Main {

    public static void main(String[] args) {
        Board game = new Board();
        game.setPlayer(4,4);
        game.setPlayer(3,4);
        game.setPlayer(2,2);
        game.setPlayer(2,4);
        game.setPlayer(3,3);
        game.setPlayer(3,1);
        game.setPlayer(1,1);

        game.draw();
    }
}
