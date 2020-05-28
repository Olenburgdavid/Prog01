import java.util.*;
import java.util.Random;
import java.io.File;

class Board {
    static final int max_value[] = {16, 32, 64, 128, 256, 512, 1024, 2048};
    static int index = max_value.length - 1;
    private static int grid[][];
    private static Random rand = new Random();
    private int maxValue = max_value[index];
    int playerScore = 0;
    static int r = 0;
    static int c = 0;
    private int best = 0;
    private static int anim[][][];

    public Board() {
        grid = new int[4][4];
        anim = new int[4][4][4];
        randomCell();
        randomCell();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                anim[0][i][j] = grid[i][j];
                anim[1][i][j] = grid[i][j];
                anim[2][i][j] = grid[i][j];
                anim[3][i][j] = grid[i][j];
            }
        }
        if (playerScore >= best) {
            best = playerScore;
        }
    }

    public int getBest() {
        return best;
    }

    public static boolean newNum() {
        return true;
    }

    public Board(int[][] aGrid) {
        grid = aGrid;
    }

    public static int get(int m, int r, int c) {
        return anim[m][r][c];
    }

    public int getScore() {
        return playerScore;
    }

    public static int getGoal() {
        return max_value[index];
    }

    public static boolean isRandomIndex(int dR, int dC) {
        return r == dR && c == dC ? true : false;
    }

    public void moveLeft() {
        boolean used[][] = new boolean[4][4];
        for (int k = 0; k < 4; k++) {
            for (int j = 1; j < 4; j++) {
                for (int i = 0; i < 4; i++) {
                    if (grid[i][j - 1] == 0) {
                        grid[i][j - 1] = grid[i][j];
                        anim[k][j - 1][i] = grid[i][j];
                        grid[i][j] = 0;
                        anim[k][j][i] = grid[i][j];
                    } else if (grid[i][j - 1] == grid[i][j] && !used[i][j - 1] && !used[i][j]) {
                        grid[i][j - 1] *= 2;
                        anim[k][i][j - 1] = grid[i][j - 1];
                        playerScore += grid[i][j - 1];
                        grid[i][j] = 0;
                        anim[k][i][j] = grid[i][j];
                        used[i][j - 1] = true;
                    }
                }
            }
            if (k == 3) {
                if (moved()) {
                    randomCell();
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    anim[k][i][j] = grid[i][j];
                }
            }
        }
    }

    public void moveRight() {
        boolean used[][] = new boolean[4][4];
        for (int k = 0; k < 4; k++) {
            for (int j = 2; j > -1; j--) {
                for (int i = 0; i < 4; i++) {
                    if (grid[i][j + 1] == 0) {
                        grid[i][j + 1] = grid[i][j];
                        anim[k][i][j + 1] = grid[i][j];
                        grid[i][j] = 0;
                        anim[k][j][i] = grid[i][j];
                    } else if (grid[i][j] == grid[i][j + 1] && !used[i][j + 1] && !used[i][j]) {
                        grid[i][j + 1] *= 2;
                        anim[k][i][j + 1] = grid[i][j + 1];
                        playerScore += grid[i][j + 1];
                        grid[i][j] = 0;
                        anim[k][i][j] = grid[i][j];
                        used[i][j + 1] = true;
                    }
                }
            }
            if (k == 3) {
                if (moved()) {
                    randomCell();
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    anim[k][i][j] = grid[i][j];
                }
            }
        }
    }

    public void moveUp() {
        boolean used[][] = new boolean[4][4];
        for (int k = 0; k < 4; k++) {
            for (int i = 1; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (grid[i - 1][j] == 0) {
                        grid[i - 1][j] = grid[i][j];
                        anim[k][i - 1][j] = grid[i][j];
                        grid[i][j] = 0;
                        anim[k][j][i] = grid[i][j];
                    } else if (grid[i - 1][j] == grid[i][j] && !used[i - 1][j] && !used[i][j]) {
                        grid[i - 1][j] *= 2;
                        anim[k][i - 1][j] = grid[i - 1][j];
                        playerScore += grid[i - 1][j];
                        grid[i][j] = 0;
                        anim[k][i][j] = grid[i][j];
                        used[i - 1][j] = true;
                    }
                }
            }
            if (k == 3) {
                if (moved()) {
                    randomCell();
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    anim[k][i][j] = grid[i][j];
                }
            }
        }
    }

    public void moveDown() {
        boolean used[][] = new boolean[4][4];
        for (int k = 0; k < 4; k++) {
            for (int i = 2; i > -1; i--) {
                for (int j = 0; j < 4; j++) {
                    if (grid[i + 1][j] == 0) {
                        grid[i + 1][j] = grid[i][j];
                        anim[k][i + 1][j] = grid[i][j];
                        grid[i][j] = 0;
                        anim[k][j][i] = grid[i][j];
                    } else if (grid[i + 1][j] == grid[i][j] && !used[i + 1][j] && !used[i][j]) {
                        grid[i + 1][j] *= 2;
                        anim[k][i + 1][j] = grid[i + 1][j];
                        playerScore += grid[i + 1][j];
                        grid[i][j] = 0;
                        anim[k][i][j] = grid[i][j];
                        used[i + 1][j] = true;
                    }
                }
            }
            if (k == 3) {
                if (moved()) {
                    randomCell();
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    anim[k][i][j] = grid[i][j];
                }
            }
        }
    }

    private void randomCell() {
        int cells = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == 0) {
                    cells++;
                }
            }
        }
        int randomCell = 1 + rand.nextInt(cells);
        cells = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == 0) {
                    cells++;
                    if (cells == randomCell) {
                        grid[i][j] = (1 + rand.nextInt(10)) == 10 ? 4 : 2;
                        r = i;
                        c = j;
                    }
                }
            }
        }
    }

    public static boolean moved() {
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 3; c++) {
                if (grid[r][c] == grid[r][c + 1]) {
                    return true;
                }
            }
        }
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 4; c++) {
                if (grid[r][c] == grid[r + 1][c]) {
                    return true;
                }
            }
        }
        return false;
    }

    public void incGoal() {
        if (index == max_value.length - 1) {
            index = 0;
        } else {
            index++;
        }
    }

    public void decGoal() {
        if (index == 0) {
            index = max_value.length - 1;
        } else {
            index--;
        }
    }
}