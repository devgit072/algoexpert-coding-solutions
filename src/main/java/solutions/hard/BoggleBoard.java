package solutions.hard;

import java.util.ArrayList;
import java.util.List;

public class BoggleBoard {
    public static List<String> boggleBoard(char[][] board, String[] words) {
        List<String> results = new ArrayList<>();
        int rows = board.length;
        int columns = board[0].length;

        for (String word : words) {
            boolean searched = false;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        List<String> positions = new ArrayList<>();
                        boolean[][] seen = new boolean[rows][columns];
                        searched = searchUtil(board, rows, columns, i, j, positions, word, 0, seen);
                        if (searched) {
                            results.add(word);
                            break;
                        }
                    }
                }
                if (searched) {
                    break;
                }
            }

        }
        return results;
    }

    public static boolean searchUtil(char[][] board, int rows, int columns, int x, int y,
                                     List<String> positions, String word, int index, boolean[][] seen) {
        if (x < 0 || y < 0 || x >= rows || y >= columns) {
            return false;
        }
        if(seen[x][y]) {
            return false;
        }

        if (index == word.length() - 1) {
            seen[x][y] = true;
            System.out.printf("Last Char: %c matched at index: (%d, %d)\n", word.charAt(index), x, y);
            return word.charAt(index) == board[x][y];
        }

        boolean value1 = false, value2 = false, value3 = false, value4 = false, value5 = false, value6 = false, value7 = false, value8 = false;
        if (board[x][y] == word.charAt(index)) {
            seen[x][y] = true;
            System.out.printf("Char: %c matched at index: (%d, %d)\n", word.charAt(index), x, y);
            value1 = searchUtil(board, rows, columns, x, y - 1, positions, word, index + 1, seen);
            value2 = searchUtil(board, rows, columns, x - 1, y - 1, positions, word, index + 1, seen);
            value3 = searchUtil(board, rows, columns, x - 1, y, positions, word, index + 1, seen);
            value4 = searchUtil(board, rows, columns, x - 1, y + 1, positions, word, index + 1, seen);
            value5 = searchUtil(board, rows, columns, x, y + 1, positions, word, index + 1, seen);
            value6 = searchUtil(board, rows, columns, x + 1, y + 1, positions, word, index + 1, seen);
            value7 = searchUtil(board, rows, columns, x + 1, y, positions, word, index + 1, seen);
            value8 = searchUtil(board, rows, columns, x + 1, y - 1, positions, word, index + 1, seen);

            if (value1 || value2 || value3 || value4 || value5 || value6 || value7 || value8) {
                positions.add(String.format("%d#%d", x, y));
                return true;
            } else {
                seen[x][y] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'t', 'h', 'i', 's', 'i', 's', 'a'},
                {'s', 'i', 'm', 'p', 'l', 'e', 'x'},
                {'b', 'x', 'x', 'x', 'x', 'e', 'b'},
                {'x', 'o', 'g', 'g', 'l', 'x', 'o'},
                {'z', 'x', 'x', 'D', 'T', 'r', 'a'},
                {'g', 'i', 'P', 'E', 'A', 'd', 'x'},
                {'x', 'a', 'g', 'x', 'x', 'x', 'x'},
                {'N', 'O', 'z', 'R', 'E', '-', 'P'},
                {'x', 'x', 'D', 'E', 'T', 'A', 'E'}
        };

        String[] strArr = new String[] {"zigzag"};
        List<String> result = boggleBoard(matrix, strArr);
        for(String s : result) {
            System.out.println(s);
        }
    }
}
