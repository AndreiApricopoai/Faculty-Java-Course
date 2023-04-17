package Lab7.Compulsory;

import java.util.List;

public class ExplorationMap {
    private final Cell[][] matrix;
    private final int n;


    public ExplorationMap(int n) {
        this.n = n;
        matrix = new Cell[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Cell();
            }
        }
    }
    public int getN() {
        return n;
    }

    public boolean explorationFinished() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (matrix[row][col].isEmpty()) {
                matrix[row][col].setTokens(robot.extractTokens());
                System.out.println(robot.getName() + " visisted cell " + row + " " + col + " stored tokens: " + matrix[row][col].getTokens());
                return true;
            }
            return false;
        }
    }


}
