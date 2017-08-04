package arrays_and_strings;

import sorting_algorithms.MergeSort;

/**
 * Given two strings, write a method to decide if one is a permutation of the
 * other.
 *
 * @author nicoq
 */
public class CheckPermutation {

    public static void main(String[] args) {

        String pair1string1 = "cat";
        String pair1string2 = "act";

        String pair2string1 = "car";
        String pair2string2 = "carpet";

        String pair3string1 = "qwerty";
        String pair3string2 = "ytrewq";

        String pair4string1 = "chocolaat";
        String pair4string2 = "chocolate";

        // not bad O(n log n)
        System.out.println("isPermutation1:");
        System.out.println(isPermutation1(pair1string1, pair1string2)); // "cat" "act" TRUE
        System.out.println(isPermutation1(pair2string1, pair2string2)); // "car" "carpet" FALSE
        System.out.println(isPermutation1(pair3string1, pair3string2)); // "qwerty" "ytrewq" TRUE
        System.out.println(isPermutation1(pair4string1, pair4string2)); // "chocolaat" "chocolate" FALSE

        // optimal O(n)
        System.out.println("\nisPermutation2:");
        System.out.println(isPermutation2(pair1string1, pair1string2)); // "cat" "act" TRUE
        System.out.println(isPermutation2(pair2string1, pair2string2)); // "car" "carpet" FALSE
        System.out.println(isPermutation2(pair3string1, pair3string2)); // "qwerty" "ytrewq" TRUE
        System.out.println(isPermutation2(pair4string1, pair4string2)); // "chocolaat" "chocolate" FALSE
    }

    // sorts each string and then checks if they are the same chracter by character
    // time complexity O(n log n)
    public static boolean isPermutation1(String string1, String string2) {
        // if the strings are of different length it is impossible to be permutations
        // of each other.
        if (string1.length() != string2.length()) {
            return false;
        }
        // converts string1 into array of Comparables in order to use mergeSort on it O(n)
        Comparable[] string1AsComparable = new Comparable[string1.length()];
        for (int i = 0; i < string1.length(); i++) {
            string1AsComparable[i] = string1.charAt(i);
        }
        // converts string2 into array of Comparables in order to use mergeSort on it O(n)
        Comparable[] string2AsComparable = new Comparable[string2.length()];
        for (int i = 0; i < string2.length(); i++) {
            string2AsComparable[i] = string2.charAt(i);
        }

        // sorts string1 and string2.
        // O(n log n)
        MergeSort.mergeSort(string1AsComparable);
        MergeSort.mergeSort(string2AsComparable);

        // O(n)
        for (int i = 0; i < string1AsComparable.length; i++) {
            if (string1AsComparable[i].compareTo(string2AsComparable[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    // makes two int arrays to track how many times each character from each string appears.
    // then checks if these two arrays are equal.
    // time complexity O(n)
    public static boolean isPermutation2(String string1, String string2) {
        // if the strings are of different length it is impossible to be permutations
        // of each other.
        if (string1.length() != string2.length()) {
            return false;
        }

        int[] string1CharAppearances = new int[128];
        int[] string2CharAppearances = new int[128];

        // maps each character to its appropriate ASCII position and increments that position
        for (int i = 0; i < string1.length(); i++) {
            string1CharAppearances[(int) string1.charAt(i)]++;
        }
        for (int i = 0; i < string2.length(); i++) {
            string2CharAppearances[(int) string2.charAt(i)]++;
        }

        // checks if each array of character appearances are equal.
        // if this is true it means both string had the same characters but
        // not necessarily in the same order hence being permutations of each other
        for (int i = 0; i < string1CharAppearances.length; i++) {
            if (string1CharAppearances[i] != string2CharAppearances[i]) {
                return false;
            }
        }
        return true;
    }
}
