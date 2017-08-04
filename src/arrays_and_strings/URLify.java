package arrays_and_strings;

/**
 * Write a method to replace all spaces in a string with '%20'. You may assume
 * that the string has sufficient space at the end to hold the additional
 * characters, and that you are given the "true" length of the string. (Note: If
 * implementing in Java, please use a character array so that you can perform
 * this operation in place.)
 *
 * @author nicoq
 */
public class URLify {

    public static void main(String[] args) {

        String string1 = "Mr John Smith    ";
        String string2 = "The Land Before Time      ";
        String string3 = "The End  ";
        String string4 = "Hello World  ";
        String string5 = "String";

        char[] string1AsChars = string1.toCharArray();
        char[] string2AsChars = string2.toCharArray();
        char[] string3AsChars = string3.toCharArray();
        char[] string4AsChars = string4.toCharArray();
        char[] string5AsChars = string5.toCharArray();

        urlIfy(string1AsChars, 13);
        urlIfy(string2AsChars, 20);
        urlIfy(string3AsChars, 7);
        urlIfy(string4AsChars, 11);
        urlIfy(string5AsChars, 6);

        for (int i = 0; i < string1AsChars.length; i++) {
            System.out.print(string1AsChars[i]);
        }
        System.out.println();
        for (int i = 0; i < string2AsChars.length; i++) {
            System.out.print(string2AsChars[i]);
        }
        System.out.println();
        for (int i = 0; i < string3AsChars.length; i++) {
            System.out.print(string3AsChars[i]);
        }
        System.out.println();
        for (int i = 0; i < string4AsChars.length; i++) {
            System.out.print(string4AsChars[i]);
        }
        System.out.println();
        for (int i = 0; i < string5AsChars.length; i++) {
            System.out.print(string5AsChars[i]);
        }
        System.out.println();
    }

    // optimal solution
    // traverses the array backwards from the index of the last letter and adds
    // the current char if it's a letter or '0' '2' '%' to the following 3 indexes
    // if it is a space.
    // time complexity: O(n)
    public static void urlIfy(char[] string, int len) {
        int modIndex = string.length - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (string[i] != ' ') {
                string[modIndex] = string[i];
                modIndex--;
            } else {
                string[modIndex--] = '0';
                string[modIndex--] = '2';
                string[modIndex--] = '%';
            }
        }
    }
}
