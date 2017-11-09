package linked_lists;

/**
 *
 * @author nicoq
 */
public class RemoveDups {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();
//        list.add(new Node(1));
//        list.add(new Node(2));
//        list.add(new Node(3));
//        list.add(new Node(2));
//        list.add(new Node(1));
//        list.add(new Node(2));
//        list.add(new Node(2));
//        list.add(new Node(1));
//        list.add(new Node(3));
//        list.add(new Node(3));
        
        list.add(new Node(2));
        list.add(new Node(2));
        list.add(new Node(2));
        list.add(new Node(2));
        list.add(new Node(2));
        list.add(new Node(2));
        list.add(new Node(2));
        list.add(new Node(2));
        list.add(new Node(2));
        list.add(new Node(2));

        list.printList();
        System.out.println();
        System.out.println("Size: " + list.getSize());
        System.out.println();

        //list.removeDupsIteratively();
        list.removeDupsUsingHashTable();

        list.printList();
        System.out.println();
        System.out.println("Size: " + list.getSize());
        System.out.println();
    }
}
