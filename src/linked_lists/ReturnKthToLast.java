package linked_lists;

/**
 *
 * @author nicoq
 */
public class ReturnKthToLast {

    public static void main(String[] args) {
        
        MyLinkedList list = new MyLinkedList();
        
        list.add(new Node(20));
        list.add(new Node(19));
        list.add(new Node(18));
        list.add(new Node(17));
        list.add(new Node(16));
        list.add(new Node(15));
        list.add(new Node(14));
        list.add(new Node(13));
        list.add(new Node(12));
        list.add(new Node(11));
        list.add(new Node(10));
        list.add(new Node(9));
        list.add(new Node(8));
        list.add(new Node(7));
        list.add(new Node(6));
        list.add(new Node(5));
        list.add(new Node(4));
        list.add(new Node(3));
        list.add(new Node(2));
        list.add(new Node(1));
        
        list.printList();
        System.out.println();
        Node nodeKthToLast = list.returnKthToLast(7);
        System.out.println(nodeKthToLast.getData());
    }
}
