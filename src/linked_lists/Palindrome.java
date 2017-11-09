package linked_lists;

/**
 *
 * @author nicoq
 */
public class Palindrome {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        String string = "racecar";
        for (int i = 0; i < string.length(); i++) {
            list.add(new Node(string.charAt(i)));
        }

        System.out.println(list.isPalindrome());
    }

}
