package solutions.veryHard;

import java.util.HashSet;
import java.util.Set;

public class NonAttackingQueens {
    public int nonAttackingQueens(int n) {
        if(n<=1) {
            return n;
        }
        // In case of n=2 and n=3, there will be no safe place.
        if (n < 4) {
            return 0;
        }

        return util(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private int util(int n, int currentRow, Set<Integer> rowHash, Set<Integer> colHash, Set<Integer[]> diagonalHash) {
        if (currentRow >= n) {
            return 1;
        }
        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            // first try in coord(currentRow, i) and see if this is possible.
            int xCoord = currentRow;
            int yCoord = i;
            // First check if the queen is already placed in the given row or not.
            if (rowHash.contains(xCoord) || colHash.contains(yCoord)) {
                continue;
            }
            // Now check the diagonal coordinates.
            if (checkDiagonalClash(diagonalHash, xCoord, yCoord, n)) {
                continue;
            }
            rowHash.add(currentRow);
            colHash.add(yCoord);
            Integer[] coords = new Integer[]{xCoord, yCoord};
            diagonalHash.add(coords);
            int value = util(n, currentRow + 1, rowHash, colHash, diagonalHash);
            totalCount += value;
            rowHash.remove(currentRow);
            colHash.remove(i);
            diagonalHash.remove(coords);
        }
        return totalCount;
    }

    private boolean checkDiagonalClash(Set<Integer[]> diagonalHash, int xCoord, int yCoord, int n) {
        for (Integer[] coords : diagonalHash) {
            int x = coords[0];
            int y = coords[1];
            int i = x;
            int j = y;
            // First check first quadrant.
            while (i >= 0 && j >= 0) {
                if (i == xCoord && j == yCoord) {
                    // There is already a element in this diagonal direction.
                    return true;
                }
                i--;
                j--;
            }
            // Check second quadrant.
            i = x;
            j = y;
            while (i >= 0 && j < n) {
                if (i == xCoord && j == yCoord) {
                    // There is already a element in this diagonal direction.
                    return true;
                }
                i--;
                j++;
            }
            // Check third quadrant.
            i = x;
            j = y;
            while (i < n && j < n) {
                if (i == xCoord && j == yCoord) {
                    // There is already a element in this diagonal direction.
                    return true;
                }
                i++;
                j++;
            }
            // Check the fourth quadrant.
            i = x;
            j = y;
            while (i < n && j >= 0) {
                if (i == xCoord && j == yCoord) {
                    // There is already a element in this diagonal direction.
                    return true;
                }
                i++;
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        NonAttackingQueens obj = new NonAttackingQueens();
        System.out.println(obj.nonAttackingQueens(4));
    }
}
