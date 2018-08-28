import java.util.*;

public class Board {
    private char[][] board;
    private int size;
    private boolean win;
    private char playerWin;
    private int player;
    private boolean full;

    private static final int ROW = 3, COLLUMN = 3;
    private static final char PLAYER1 = 'X';
    private static final char PLAYER2 = 'O';
    private static final int WINCONDITION = 3;

    // Initialize a 2D array fill '_' representing empty spot
    public Board() {
        board = new char[ROW][COLLUMN];
        size = 0;
        win = false;
        player = 1;
        full = false;
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '_';
            }
        }
    }

    // Draw graphic representation of the board's current state
    public void draw(){
        for(int i = 0; i < board.length; i++) {
            System.out.print("|");
            for(int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                System.out.print("|");
            }
                System.out.println();
        }
    }

    // place mark on the board
    public int setPlayer(int x, int y) {
        if (checkFull() || win){
            //System.out.println("Game Over");
            return -1;
        } else {
            char player = switchPlayer();
            if (x >= 1 && x <= ROW) {
                if(y >= 1 && y <= COLLUMN) {
                    if (checkEmpty(x, y)) {
                        board[x - 1][y - 1] = player;
                        size++;
                    } else {
                        System.out.println("Position is taken!");
                    }
                }
            }
        }
        checkStatus();
        return 1;
    }

    // check status of the board: winner, fullness
    // True if the board is still playable false other wise
    public boolean checkStatus () {
        boolean status = true;
        if(winOverall()) {
            win = true;
            status = false;
            System.out.println("Game Over");
        } else if (checkFull()) {
            System.out.println("board is full");
            status = false;
        }
        return status;
    }


    //Switch player
    public char switchPlayer() {
        char curPlayer = PLAYER1;
        if(player == 1) {
            this.player = 2;
            curPlayer = PLAYER1;
        } else {
            this.player = 1;
            curPlayer = PLAYER2;
        }
        return curPlayer;
    }

    // Check if the current position is empty
    private boolean checkEmpty(int x, int y) {
        boolean result = true;
        if(board[x - 1][y - 1] != '_') {
            result = false;
        }
        return result;
    }

    // Check if the board is full
    private boolean checkFull() {
        boolean result = false;
        if(size == ROW * COLLUMN) {
            result = true;
            full = true;
        }
        return result;
    }

    // Check for horizontal win
    public boolean horizonWin(){
        for(char[] arr: board) {
            StringBuilder line = new StringBuilder(COLLUMN);
            for (int i = 0; i < arr.length; i++) {
                line.append(arr[i]);
            }
            if(checkString(line.toString())) {
                playerWin = line.charAt(0);
                return true;
            }
        }
        return false;
    }

    // Check for vertical win
    public boolean verticalWin() {
        for(int i = 0; i < COLLUMN; i++) {
            StringBuilder line = new StringBuilder(ROW);
            for(int j = 0; j < ROW; j++) {
                line.append(board[j][i]);
            }
            if(checkString(line.toString())) {
                playerWin = line.charAt(0);
                return true;
            }
        }
        return false;
    }

    public boolean diagnolWin() {
        int colIndex1 = 0;
        int colIndex2 = COLLUMN - 1;
        StringBuilder[] line = new StringBuilder[2];
        line[0] = new StringBuilder();
        line[1] = new StringBuilder();
        for(int i = 0; i < ROW; i++){
            line[0].append(board[i][colIndex1]);
            line[1].append(board[i][colIndex2]);
            colIndex1++;
            colIndex2--;
        }
        for (int i = 0; i < line.length; i++) {
            if(checkString((line[i].toString()))) {
                playerWin = line[i].charAt(0);
                return true;
            }
        }
    return false;
    }

    // check for overall win
    public boolean winOverall() {
        if(horizonWin() || (verticalWin() || diagnolWin())) {
            return true;
        }
        return false;
    }

    // Check if all characters in the string are duplicates
    public boolean checkString(String line) {
        char temp = line.charAt(0);
        if (temp == PLAYER1 || temp == PLAYER2) {
            for (int i = 1; i < line.length(); i++) {
                if (line.charAt(i) != temp) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public char getWinner() {
        return playerWin;
    }

    public boolean getStatus() {
        return win;
    }
}
