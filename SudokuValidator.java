class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            if (!isValidUnit(board[row])) {
                return false;
            }
        }
        for (int col = 0; col < 9; col++) {
            char[] column = new char[9];
            for (int row = 0; row < 9; row++) {
                column[row] = board[row][col];
            }
            if (!isValidUnit(column)) {
                return false;
            }
        }
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                char[] subBox = new char[9];
                int index = 0;
                for (int row = boxRow * 3; row < boxRow * 3 + 3; row++) {
                    for (int col = boxCol * 3; col < boxCol * 3 + 3; col++) {
                        subBox[index++] = board[row][col];
                    }
                }
                if (!isValidUnit(subBox)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidUnit(char[] unit) {
        boolean[] seen = new boolean[9];
        for (char c : unit) {
            if (c != '.') {
                int digit = c - '1';
                if (seen[digit]) {
                    return false;
                }
                seen[digit] = true;
            }
        }
        return true;
    }
}
public class SudokuValidator{
    public static void main(String[] args) {
        
    }
}