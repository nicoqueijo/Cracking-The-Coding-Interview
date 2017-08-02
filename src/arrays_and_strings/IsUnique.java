package arrays_and_strings;

import sorting_algorithms.MergeSort;

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
        System.out.println("\nisUnique3:");
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
    // time complexity: O(n^2)
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
    // time complexity: O(n log n)
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

        // O(n log n)
        MergeSort.mergeSort(stringAsComparable);

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
    // time complexity O(n)
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
}
