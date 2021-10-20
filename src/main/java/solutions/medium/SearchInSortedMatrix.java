package solutions.medium;

public class SearchInSortedMatrix {
    /*
    We have two solution for this problem. One is O(m+n) solution and other is O(log(m*n)
     */

    /*
    O(m+n) solution.
    Here we will start from top-right. You can ask yourself why not top-left or bottom-right?
    We can either start from top-right or bottom-left. Say if we start from top-right, and if target element is
    bigger than current element, then we move down(that means discard current row) and if target is bigger than current
    element then we move left(discard current column). So you can see at every search we are discarding one column or row.
    We have total m+n rows+columns, so in maximum of m+n search we will find the element.
    If we had started from top-left or bottom-right, then we could not have movied like this.
     */
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int x_index = 0;
        int y_index = matrix[0].length - 1;
        int xlen = matrix.length, ylen = matrix[0].length;
        while (x_index >= 0 && x_index < xlen && y_index >= 0 && y_index < ylen) {
            if (matrix[x_index][y_index] == target) {
                return new int[]{x_index, y_index};
            } else if (matrix[x_index][y_index] < target) {
                x_index++;
            } else {
                y_index--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004},
        };
        System.out.println(searchInSortedMatrix(matrix, 44));
    }
}
