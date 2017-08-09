package arrays_and_strings;

/**
 * Implement a method to perform basic string compression using the counts of
 * repeated characters. For example, the string aabcccccaaa would become
 * a2blc5a3. If the "compressed" string would not become smaller than the
 * original string, your method should return the original string. You can
 * assume the string has only uppercase and lowercase letters (a - z).
 *
 * @author nicoq
 */
public class StringCompression {

    public static void main(String[] args) {

        String string1 = "aabcccccaaa";
        String string2 = "hhhhhhheeeeeeggggggggggg";
        String string3 = "eeeffdaassssskk";
        String string4 = "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm";
        String string5 = "abcdefg";

        System.out.println(stringCompression(string1)); // a2b1c5a3
        System.out.println(stringCompression(string2)); // h7e6g11
        System.out.println(stringCompression(string3)); // e3f2d1a2s5k2
        System.out.println(stringCompression(string4)); // m35
        System.out.println(stringCompression(string5)); // abcdefg (because it's shorter than its compressed version)
    }

    // Optimal solution
    //
    // If the string is empty we return 0.
    // We will keep the compressed string in a StringBuilder which we initialize to
    // the worst case possible which would be twice the string length. We do this
    // to avoid constant resizing of the compressed string.
    //
    // We keep track of the last character seen and the count of repeated characters.
    // We initialize last seen character as the first index of the string and the 
    // count as 1. Then we traverse the string to check if the next character 
    // differs from the last one we have seen. If it differs we increment count, 
    // set the last seen character as the current character, append both things to
    // compressed string and reset count back to 1. If the character is the same as
    // last seen character we simply increment count.
    // At the end we return the smaller of the compressed string and the original
    // string.
    //
    // Time complexity: O(n)
    public static String stringCompression(String string) {
        if (string.length() == 0) {
            return "0";
        }
        char lastSeen = string.charAt(0);
        int count = 1;
        StringBuilder compressedString = new StringBuilder(string.length() * 2);
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) != lastSeen) {
                compressedString.append(lastSeen);
                compressedString.append(count);
                lastSeen = string.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        compressedString.append(lastSeen);
        compressedString.append(count);
        return compressedString.toString().length() < string.length()
                ? compressedString.toString() : string;
    }
}
