package solutions.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Sudoku {
    // We can't solve sudoku using bruteforce method. For 9*9 board there will be 9^81 combinations which will take years to compute.
    // Sudoku problem can be solved using backtracking.

    public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        int[][] sudokuBoard = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudokuBoard[i][j] = board.get(i).get(j);
            }
        }
        boolean res = checkAndFillTheBoard(sudokuBoard);
        if(!res) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int[] row : sudokuBoard) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for(int v : row) {
                rowList.add(v);
            }
            result.add(rowList);
        }
        return result;
    }

    boolean checkAndFillTheBoard(int[][] board) {
        boolean isBoardValid = checkValidityOfBoard(board);
        if (!isBoardValid) {
            return false;
        }
        if(isBoardFilled(board)) {
            return true;
        }
        int[] vacantSpot = getVacantSpot(board);
        int i = vacantSpot[0];
        int j = vacantSpot[1];
        if(i==-1 || j==-1) {
            return true;
        }
        for (int num = 1; num <= 9; num++) {
            board[i][j] = num;
            boolean result = checkAndFillTheBoard(board);
            if (!result) {
                board[i][j] = 0;
                continue;
            } else {
                return true;
            }
        }
        return false;
    }

    int[] getVacantSpot(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }


    void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            System.out.print("{");
            for (int j = 0; j < 9; j++) {
                int value = board[i][j];
                System.out.print(value + "    ");
            }
            System.out.print("}");
            System.out.println();
        }
    }

    boolean isBoardFilled(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int value = board[i][j];
                if(value == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    boolean checkValidityOfBoard(int[][] board) {
        // first check in the rows.
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                int value = board[i][j];
                if (value == 0) {
                    continue;
                }
                if (set.contains(value)) {
                    return false;
                } else {
                    set.add(value);
                }
            }
        }
        // Now check in all columns.
        for (int j = 0; j < 9; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                int value = board[i][j];
                if (value == 0) {
                    continue;
                }
                if (set.contains(value)) {
                    return false;
                } else {
                    set.add(value);
                }
            }
        }

        // Now check in every grid.
        if (!checkValidityInGrid(board, 0, 0)) {
            return false;
        }
        if (!checkValidityInGrid(board, 0, 3)) {
            return false;
        }
        if (!checkValidityInGrid(board, 0, 6)) {
            return false;
        }
        if (!checkValidityInGrid(board, 3, 0)) {
            return false;
        }
        if (!checkValidityInGrid(board, 3, 3)) {
            return false;
        }
        if (!checkValidityInGrid(board, 3, 6)) {
            return false;
        }
        if (!checkValidityInGrid(board, 6, 0)) {
            return false;
        }
        if (!checkValidityInGrid(board, 6, 3)) {
            return false;
        }
        if (!checkValidityInGrid(board, 6, 6)) {
            return false;
        }
        return true;
    }

    static boolean checkValidityInGrid(int[][] board, int addRow, int addCol) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int value = board[i + addRow][j + addCol];
                if (value == 0) {
                    continue;
                }
                if (set.contains(value)) {
                    return false;
                } else {
                    set.add(value);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {7, 8, 0, 4, 0, 0, 1, 2, 0},
                {6, 0, 0, 0, 7, 5, 0, 0, 9},
                {0, 0, 0, 6, 0, 1, 0, 7, 8},
                {0, 0, 7, 0, 4, 0, 2, 6, 0},
                {0, 0, 1, 0, 5, 0, 9, 3, 0},
                {9, 0, 4, 0, 6, 0, 0, 0, 5},
                {0, 7, 0, 3, 0, 0, 0, 1, 2},
                {1, 2, 0, 0, 0, 7, 4, 0, 0},
                {0, 4, 9, 2, 0, 6, 0, 0, 7}
        };
        int[][] testBoard = new int[][]{
                {7  ,  8  ,  3  ,  4  ,  1  ,  0  ,  1  ,  2  ,  0   },
                {6  ,  0  ,  0  ,  0  ,  7  ,  5  ,  0  ,  0  ,  9    },
                {0  ,  0  ,  0  ,  6  ,  0  ,  1  ,  0  ,  7  ,  8    },
                {0  ,  0  ,  7  ,  0  ,  4  ,  0  ,  2  ,  6  ,  0    },
                {0  ,  0  ,  1  ,  0  ,  5  ,  0  ,  9  ,  3  ,  0    },
                {9  ,  0  ,  4  ,  0  ,  6  ,  0  ,  0  ,  0  ,  5    },
                {0  ,  7  ,  0  ,  3  ,  0  ,  0  ,  0  ,  1  ,  2    },
                {1  ,  2  ,  0  ,  0  ,  0  ,  7  ,  4  ,  0  ,  0    },
                {0  ,  4  ,  9  ,  2  ,  0  ,  6  ,  0  ,  0  ,  7   }
        };
        //checkValidityOfBoard(testBoard);
        //solveSudoku(board);
    }
}
