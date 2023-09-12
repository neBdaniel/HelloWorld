import java.util.Scanner;

public class TicTacToe {
    protected static final int X = 1, O = -1; // Players
    protected static final int EMPTY = 0; // Empty cell
    protected int board[][] = new int[3][3]; // Game board
    protected int player; // Current player
    protected String playerXName;
    protected String playerOName;

    /** Constructor */
    public TicTacToe() {
        clearBoard();
    }

    /** Clears the board */
    public void clearBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = EMPTY; // Every cell should be empty
        player = X; // The first player is 'X'
    }

    /** Puts an X or O mark at position i, j */
    public void putMark(int i, int j) throws IllegalArgumentException {
        if ((i < 0) || (i > 2) || (j < 0) || (j > 2))
            throw new IllegalArgumentException("Invalid board position");
        if (board[i][j] != EMPTY)
            throw new IllegalArgumentException("Board position occupied");
        board[i][j] = player; // Place the mark for the current player
        player = -player; // Switch players (uses the fact that O = -X)
    }

    /** Checks whether the board configuration is a win for the given player */
    public boolean isWin(int mark) {
        return ((board[0][0] + board[0][1] + board[0][2] == mark * 3) // Row 0
                || (board[1][0] + board[1][1] + board[1][2] == mark * 3) // Row 1
                || (board[2][0] + board[2][1] + board[2][2] == mark * 3) // Row 2
                || (board[0][0] + board[1][0] + board[2][0] == mark * 3) // Column 0
                || (board[0][1] + board[1][1] + board[2][1] == mark * 3) // Column 1
                || (board[0][2] + board[1][2] + board[2][2] == mark * 3) // Column 2
                || (board[0][0] + board[1][1] + board[2][2] == mark * 3) // Diagonal
                || (board[2][0] + board[1][1] + board[0][2] == mark * 3)); // Diagonal
    }

    /** Returns the winning player or 0 to indicate a tie */
    public int winner() {
        if (isWin(X))
            return X;
        else if (isWin(O))
            return O;
        else
            return 0;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (board[i][j]) {
                    case X:
                        s += "X";
                        break;
                    case O:
                        s += "O";
                        break;
                    case EMPTY:
                        s += " ";
                        break;
                }
                if (j < 2)
                    s += "|"; // Column boundary
            }
            if (i < 2)
                s += "\n-----\n"; // Row boundary
        }
        return s;
    }

    /** Play the game with user input */
    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Player X's name: ");
        playerXName = scanner.nextLine();

        System.out.print("Enter Player O's name: ");
        playerOName = scanner.nextLine();

        while (true) {
            System.out.println("\n" + toString());
            int currentPlayer = (player == X) ? X : O;
            String currentPlayerName = (currentPlayer == X) ? playerXName : playerOName;

            System.out.print(currentPlayerName + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            try {
                putMark(row, col);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            int winningPlayer = winner();
            if (winningPlayer != 0) {
                System.out.println("\n" + toString());
                if (winningPlayer == X) {
                    System.out.println(playerXName + " wins!");
                } else {
                    System.out.println(playerOName + " wins!");
                }
                break;
            } else if (isBoardFull()) {
                System.out.println("\n" + toString());
                System.out.println("It's a tie!");
                break;
            }
        }
        scanner.close();
    }

    /** Checks if the board is full (no more moves possible) */
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == EMPTY)
                    return false;
        return true;
    }

    /** Test run of a simple game */
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}