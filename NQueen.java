import java.util.Arrays;
import java.util.Stack;

public class NQueen {
    static int count=0;
    private static void placeQueen(int[] board, int row) {
        if (row == board.length) {
            printBoard(board);
        } else {
            for (int col = 0; col < board.length; col++) {
                if (isSafe(board, row, col)) {
                    board[row] = col;
                    placeQueen(board, row + 1);
                    count++;
                }
            }
        }
    }

    private static boolean isSafe(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col ||
                    board[i] - i == col - row ||
                    board[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    private static void printBoard(int[] board) {
        Stack<Integer> s = new Stack<Integer> ();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row] == col) {
                    System.out.print("Q ");
                    s.push(col+1);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(s.toArray())+"\n");
    }

    public static void main(String[] args) {
        int n = 4; 
        int[] board = new int[n];
        placeQueen(board, 0);
        System.out.println("Total calls " + count);
    }
}
