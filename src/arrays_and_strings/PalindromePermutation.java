package arrays_and_strings;

/**
 * Given a string, write a function to check if it is a permutation of a
 * palindrome. A palindrome is a word or phrase that is the same forwards and
 * backwards. A permutation is a rearrangement of letters. The palindrome does
 * not need to be limited to just dictionary words.
 *
 * @author nicoq
 */
public class PalindromePermutation {

    public static void main(String[] args) {

        String string1 = "racecar"; // known palindrome
        String string2 = "eraracc"; // permutation of string1 
        String string3 = "a man a plan a canal panama"; // known palindrome
        String string4 = "canal man a panama a plan a"; // permutation of string3 
        String string5 = "library"; // not a palindrome
        String string6 = "netbeans"; // not a palindrome
        String string7 = "hello world"; // not a palindrome
        String string8 = ""; // empty string is a palindrome

        System.out.println(isPalindromePermutation(string1)); // true
        System.out.println(isPalindromePermutation(string2)); // true
        System.out.println(isPalindromePermutation(string3)); // true
        System.out.println(isPalindromePermutation(string4)); // true
        System.out.println(isPalindromePermutation(string5)); // false
        System.out.println(isPalindromePermutation(string6)); // false
        System.out.println(isPalindromePermutation(string7)); // false
        System.out.println(isPalindromePermutation(string8)); // true

    }

    // optimal solution
    // a permutation of a palindrome must have an even amount of each character 
    // except maybe one. We make an array of ints to represent the 128 ASCII 
    // characters. Then we traverse the string and for each character we increment
    // the index of the that ASCII char in our array. At the end we traverse our
    // ASCII array and make sure each index has an even value except for at most
    // one which would represent the middle of the palindrome.
    // time complexity: O(n)
    public static boolean isPalindromePermutation(String string) {
        int[] asciiTableCounter = new int[128];
        for (int i = 0; i < string.length(); i++) {
            asciiTableCounter[string.charAt(i)]++;
        }
        int amountOfOddChars = 0;
        for (int i = 0; i < asciiTableCounter.length; i++) {
            if (asciiTableCounter[i] % 2 != 0) {
                amountOfOddChars++;
            }
            if (amountOfOddChars > 1) {
                return false;
            }
        }
        return true;
    }

}
