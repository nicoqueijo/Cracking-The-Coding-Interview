package sorting_algorithms;

/**
 *
 * @author nicoq
 */
public class MergeSort {

    /**
     * Mergesort algorithm.
     *
     * @param a an array of Comparable items.
     */
    public static void mergeSort(Comparable[] a) {
        Comparable[] tmpArray = new Comparable[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
    }

    /**
     * Internal method that makes recursive calls.
     *
     * @param a an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static void mergeSort(Comparable[] a, Comparable[] tmpArray,
            int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    /**
     * Internal method that merges two sorted halves of a subarray.
     *
     * @param a an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param leftPos the left-most index of the subarray.
     * @param rightPos the index of the start of the second half.
     * @param rightEnd the right-most index of the subarray.
     */
    private static void merge(Comparable[] a, Comparable[] tmpArray,
            int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // Main loop
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos].compareTo(a[rightPos]) <= 0) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd) // Copy rest of first half
        {
            tmpArray[tmpPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd) // Copy rest of right half
        {
            tmpArray[tmpPos++] = a[rightPos++];
        }

        // Copy tmpArray back
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }

    // TRACING MERGE SORT WITH ARRAY OF INTS
    public static void mergeSort1(int[] list, int lowIndex, int highIndex) {
        System.out.println("MERGESORT: LOW: " + list[lowIndex] + " HIGH: " + list[highIndex]);
        if (lowIndex == highIndex) {
            return;
        } else {
            int midIndex = (lowIndex + highIndex) / 2;
            mergeSort1(list, lowIndex, midIndex);
            mergeSort1(list, midIndex + 1, highIndex);
            merge1(list, lowIndex, midIndex, highIndex);
        }
    }

    public static void merge1(int[] list, int lowIndex, int midIndex, int highIndex) {

        System.out.println("MERGE: LOW: " + list[lowIndex] + " MID: " + list[midIndex] + " HIGH: " + list[highIndex]);

        int[] L = new int[midIndex - lowIndex + 2];
        for (int i = lowIndex; i <= midIndex; i++) {
            L[i - lowIndex] = list[i];
        }
        L[midIndex - lowIndex + 1] = Integer.MAX_VALUE;

        int[] R = new int[highIndex - midIndex + 1];
        for (int i = midIndex + 1; i <= highIndex; i++) {
            R[i - midIndex - 1] = list[i];
        }
        R[highIndex - midIndex] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = lowIndex; k <= highIndex; k++) {
            if (L[i] <= R[j]) {
                list[k] = L[i];
                i++;
            } else {
                list[k] = R[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {

        int[] list = {4, 6, 1, 5, 8, 3, 2, 7};

//        for (int i = 0; i < list.length; i++) {
//            System.out.print(list[i] + " ");
//        }
        System.out.println();

        mergeSort1(list, 0, list.length - 1);

//        for (int i = 0; i < list.length; i++) {
//            System.out.print(list[i] + " ");
//        }
    }

}
