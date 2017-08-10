package arrays_and_strings;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
 * place?
 *
 * @author nicoq
 */
public class RotateMatrix {

    public static void main(String[] args) {

        char[][] matrix
                = {
                    {'A', 'B', 'C', 'D'},
                    {'E', 'F', 'G', 'H'},
                    {'I', 'J', 'K', 'L'},
                    {'M', 'N', 'O', 'P'}
                };

        System.out.println("original matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        char[][] rotatedMatrix = rotateMatrix(matrix, "right");
        System.out.println("rotated matrix (right):");
        for (int i = 0; i < rotatedMatrix.length; i++) {
            for (int j = 0; j < rotatedMatrix[0].length; j++) {
                System.out.print(rotatedMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        rotatedMatrix = rotateMatrix(matrix, "left");
        System.out.println("rotated matrix (left):");
        for (int i = 0; i < rotatedMatrix.length; i++) {
            for (int j = 0; j < rotatedMatrix[0].length; j++) {
                System.out.print(rotatedMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    // Solution using additional data structure 
    //
    // Traverses the matrix and writes it in another matrix inversing the row
    // or column depending on direction changed.
    //
    // Time complexity: O(n)
    // Space complexity: O(n)
    public static char[][] rotateMatrix(char[][] matrix, String direction) {
        char[][] rotatedMatrix = new char[matrix.length][matrix[0].length];
        if (direction.equals("right")) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    rotatedMatrix[j][matrix[0].length - 1 - i] = matrix[i][j];
                }
            }
        } else if (direction.equals("left")) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    rotatedMatrix[matrix[0].length - 1 - j][i] = matrix[i][j];
                }
            }
        }
        return rotatedMatrix;
    }
}
