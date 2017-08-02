package arrays_and_strings;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 *
 * @author nicoq
 */
public class IsUnique {

    public static void main(String[] args) {
        String str1 = "boolean";
        String str2 = "apple";
        String str3 = "mouse";
        String str4 = "water";
        String str5 = "transportation";
        String str6 = "abcdefghijklmnopqrstuvwxyz";

        // brute force O(n^2)
        System.out.println("isUnique1:");
        System.out.println(isUnique1(str1)); // "boolean" FALSE
        System.out.println(isUnique1(str2)); // "apple" FALSE
        System.out.println(isUnique1(str3)); // "mouse" TRUE
        System.out.println(isUnique1(str4)); // "water" TRUE
        System.out.println(isUnique1(str5)); // "transportation" FALSE
        System.out.println(isUnique1(str6)); // "abcdefghijklmnopqrstuvwxyz" TRUE

        // improved O(n log n)
        System.out.println("\nisUnique2:");
        System.out.println(isUnique2(str1)); // "boolean" FALSE
        System.out.println(isUnique2(str2)); // "apple" FALSE
        System.out.println(isUnique2(str3)); // "mouse" TRUE
        System.out.println(isUnique2(str4)); // "water" TRUE
        System.out.println(isUnique2(str5)); // "transportation" FALSE
        System.out.println(isUnique2(str6)); // "abcdefghijklmnopqrstuvwxyz" TRUE

        // optimal O(n)
        System.out.println("\nisUnique2:");
        System.out.println(isUnique3(str1)); // "boolean" FALSE
        System.out.println(isUnique3(str2)); // "apple" FALSE
        System.out.println(isUnique3(str3)); // "mouse" TRUE
        System.out.println(isUnique3(str4)); // "water" TRUE
        System.out.println(isUnique3(str5)); // "transportation" FALSE
        System.out.println(isUnique3(str6)); // "abcdefghijklmnopqrstuvwxyz" TRUE
    }

    // brute force solution.
    // for every character in a string is checks every other character to see if
    // there is another one of the same value.
    // complexity: O(n^2)
    public static boolean isUnique1(String string) {
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < string.length(); j++) {
                if (i == j) {
                    continue;
                } else if (string.charAt(i) == string.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // improved solution.
    // sorts the characters in the string alphabetically, then checks if two
    // of the same characters appear adjacent to each other.
    // complexity: O(n log n)
    public static boolean isUnique2(String string) {
        // a string must have at least two characters to have duplicate characters
        if (string.length() < 2) {
            return false;
        }

        // converts string into array of Comparables in order to use mergeSort on it O(n)
        Comparable[] stringAsComparable = new Comparable[string.length()];
        for (int i = 0; i < string.length(); i++) {
            stringAsComparable[i] = string.charAt(i);
        }

        mergeSort(stringAsComparable); // O(n log n)
        // string is now sorted alphabetically
        // for each char in sorted string check if next char is the same, if so
        // return false. At the end of loop return true. O(n)
        for (int i = 1; i < stringAsComparable.length; i++) {
            if (stringAsComparable[i] == stringAsComparable[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // optimal solution.
    // makes an array of booleans the size of the amount of ASCII characters.
    // use this array to map and track each character in the string to see if
    // it has been visisted yet.
    // complexity O(n)
    public static boolean isUnique3(String string) {
        // assuming ASCII char set, you cannot possibly have a string with all
        // unique chars whose number of chars exceeds the amount of available chars
        if (string.length() > 128) {
            return false;
        }
        boolean[] charAppearance = new boolean[128];
        for (int i = 0; i < string.length(); i++) {
            int asciiValue = (int) string.charAt(i);
            if (charAppearance[asciiValue]) {
                return false;
            } else {
                charAppearance[asciiValue] = true;
            }
        }
        return true;
    }

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

}
