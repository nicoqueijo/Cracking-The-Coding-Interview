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
            {0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0}
        };
        
        int[][] newMatrix = zeroMatrix(matrix);
        // prints the new matrix that set the entire row and column of cells with value 0
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] zeroMatrix(int[][] matrix) {
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

}
