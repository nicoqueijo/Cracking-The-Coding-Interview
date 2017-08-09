package arrays_and_strings;

/**
 * There are three types of edits that can be performed on strings: insert a
 * character, remove a character, or replace a character. Given two strings,
 * write a function to check if they are one edit (or zero edits) away.
 *
 * @author nicoq
 */
public class OneAway {

    public static void main(String[] args) {

        String pair1string1 = "pale";
        String pair1string2 = "ple";

        String pair2string1 = "pales";
        String pair2string2 = "pale";

        String pair3string1 = "pale";
        String pair3string2 = "bale";

        String pair4string1 = "pale";
        String pair4string2 = "bake";

        System.out.println(oneAway(pair1string1, pair1string2) + ""); // true
        System.out.println(oneAway(pair2string1, pair2string2) + ""); // true
        System.out.println(oneAway(pair3string1, pair3string2) + ""); // true
        System.out.println(oneAway(pair4string1, pair4string2) + ""); // false
    }

    // Optimal solution
    // If the difference between the two strings is greater than one it is impossible
    // for them to be one edit away so false is returned.
    // Ff they are the same length each string is traversed character by character
    // on the same index. On the second occurence that the characters at the current
    // index are different it returns false.
    // If the lengths vary by 1, we traverse both strings using the shorter one
    // in the loop. When we find two different characters at the current index, we
    // increment the index of the longer string. On the second occurence of different
    // characters we return false.
    // Time complexity: O(n)
    public static boolean oneAway(String string1, String string2) {

        final int SAME_LENGTH = 0;
        final int STRING1_LONGER = 1;
        final int STRING2_LONGER = 2;
        int lengthCase;

        if (Math.abs(string1.length() - string2.length()) > 1) {
            return false;
        } else if (string1.length() == string2.length()) {
            lengthCase = SAME_LENGTH;
        } else if (string1.length() > string2.length()) {
            lengthCase = STRING1_LONGER;
        } else {
            lengthCase = STRING2_LONGER;
        }

        int differences = 0;
        int offset = 0;
        switch (lengthCase) {
            case SAME_LENGTH:
                for (int i = 0; i < string1.length(); i++) {
                    if (string1.charAt(i) != string2.charAt(i)) {
                        differences++;
                        if (differences > 1) {
                            return false;
                        }
                    }
                }
                break;
            case STRING1_LONGER:
                for (int i = 0; i < string2.length(); i++) {
                    if (string1.charAt(i + offset) != string2.charAt(i)) {
                        offset++;
                        if (offset > 1) {
                            return false;
                        }
                    }
                }
                break;
            case STRING2_LONGER:
                for (int i = 0; i < string1.length(); i++) {
                    if (string1.charAt(i) != string2.charAt(i + offset)) {
                        offset++;
                        if (offset > 1) {
                            return false;
                        }
                    }
                }
                break;
        }
        return true;
    }

}
