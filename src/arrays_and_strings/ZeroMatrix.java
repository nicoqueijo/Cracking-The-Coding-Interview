package arrays_and_strings;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column are set to 0.
 *
 * @author nicoq
 */
public class ZeroMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 1}
        };

        System.out.println("Algorithm 1");
        int[][] newMatrix = zeroMatrix1(matrix);
        // Algorithm 1
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println();
        
        System.out.println("Algorithm 2");
        zeroMatrix2(matrix);
        // Algorithm 2
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Traverses the matrix testing whether the current cell has the value of 0.
    // If so it traverses every cell at that row and column and sets their values
    // to 0.
    //
    // Time complexity: O(n(l + w)) where n is the amount of cells in the matrix,
    // l is the length of the matrix, w is the width of the matrix. In a worse case
    // scenario every cell contains the value 0 and the algorithm traverses across
    // that row and column to set those cells to 0. For every cell it does length +
    // width work.
    public static int[][] zeroMatrix1(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] newMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    for (int r = 0; r < rows; r++) {
                        newMatrix[r][j] = 0;
                    }
                    for (int c = 0; c < cols; c++) {
                        newMatrix[i][c] = 0;
                    }
                }
            }
        }
        return newMatrix;
    }

    // Traverses the matrix...
    //
    // Time complexity: 
    public static void zeroMatrix2(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] rowsWithZero = new boolean[rows];
        boolean[] colsWithZero = new boolean[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowsWithZero[i] = true;
                    colsWithZero[j] = true;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rowsWithZero[i] || colsWithZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
