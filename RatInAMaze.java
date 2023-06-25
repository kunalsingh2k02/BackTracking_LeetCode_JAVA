public class RatInAMaze {
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        solveMaze(maze);
    }

    public static void solveMaze(int[][] maze) {
        int rows = maze.length;
        int columns = maze[0].length;
        int[][] solution = new int[rows][columns];

        if (solveMazeUtil(maze, 0, 0, solution)) {
            printSolution(solution);
        } else {
            System.out.println("No solution exists.");
        }
    }

    private static boolean solveMazeUtil(int[][] maze, int row, int col, int[][] solution) {
        int rows = maze.length;
        int columns = maze[0].length;

        if (row >= 0 && row < rows && col >= 0 && col < columns && maze[row][col] == 1) {
            solution[row][col] = 1;
            if (row == rows - 1 && col == columns - 1) {
                return true;
            }
            if (solveMazeUtil(maze, row, col + 1, solution)) {
                return true;
            }
            if (solveMazeUtil(maze, row + 1, col, solution)) {
                return true;
            }
            if (solveMazeUtil(maze, row - 1, col, solution)) {
                return true;
            }
            if (solveMazeUtil(maze, row, col - 1, solution)) {
                return true;
            }
            solution[row][col] = 0;
            return false;
        }

        return false;
    }

    private static void printSolution(int[][] solution) {
        int rows = solution.length;
        int columns = solution[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }
}
