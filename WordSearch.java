public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }
        
        int rows = board.length;
        int columns = board[0].length;
        
        if (row < 0 || row >= rows || col < 0 || col >= columns || board[row][col] != word.charAt(index)) {
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        boolean found =
            dfs(board, word, row - 1, col, index + 1) || // Up
            dfs(board, word, row + 1, col, index + 1) || // Down
            dfs(board, word, row, col - 1, index + 1) || // Left
            dfs(board, word, row, col + 1, index + 1);   // Right
        board[row][col] = temp;
        
        return found;
    }
}
class Main {
    public static void main(String[] args) {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        
        String word = "ABCCED";
        
        WordSearch wordSearch = new WordSearch();
        boolean exists = wordSearch.exist(board, word);
        
        System.out.println("Word exists: " + exists);
    }
}
