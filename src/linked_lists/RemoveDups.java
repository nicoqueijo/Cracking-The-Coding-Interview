package linked_lists;

import java.util.LinkedList;

/**
 *
 * @author nicoq
 */
public class RemoveDups {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();
        list.add(new Node(6));
        list.add(new Node(2));
        list.add(new Node(4));
        list.add(new Node(4));
        list.add(new Node(5));
        list.add(new Node(2));
        list.add(new Node(3));
        list.add(new Node(2));
        list.add(new Node(9));
        list.add(new Node(6));
        list.add(new Node(4));

        list.printList();
        System.out.println();
        System.out.println("Size: " + list.getSize());
        System.out.println();
        
        list.removeDuplicates();
        
        list.printList();
        System.out.println();
        System.out.println("Size: " + list.getSize());
        System.out.println();

    }

    public static void removeDups(LinkedList<Integer> list) {

    }

}
