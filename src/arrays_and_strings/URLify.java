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
        String string = "Mr John Smith    ";
        char[] stringAsChars = string.toCharArray();

        char[] converted = urlIfy(stringAsChars, 13);

        for (int i = 0; i < converted.length; i++) {
            System.out.print(converted[i]);
        }
    }

    public static char[] urlIfy(char[] string, int len) {

        int amountOfSpaces = 0;
        for (int i = 0; i < len; i++) {
            if (string[i] == ' ') {
                amountOfSpaces++;
            }
        }
        amountOfSpaces *= 3;

        char[] newString = new char[len + amountOfSpaces];
        for (int i = 0; i < newString.length; i++) {
            boolean spaceDetected = false;
            if (string[i] != ' ') {
                if (spaceDetected) {
                    newString[i + 3] = string[i];
                } else {
                    newString[i] = string[i];
                }
            } else {
                newString[i] = '%';
                newString[i + 1] = '2';
                newString[i + 2] = '0';
            }
        }
        return newString;
    }

}
