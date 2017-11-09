package linked_lists;

/**
 *
 * @author nicoq
 */
public class DeleteMiddleNode {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        Node node20 = new Node(20);
        Node node19 = new Node(19);
        Node node18 = new Node(18);
        Node node17 = new Node(17);
        Node node16 = new Node(16);
        Node node15 = new Node(15);
        Node node14 = new Node(14);
        Node node13 = new Node(13);
        Node node12 = new Node(12);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node9 = new Node(9);
        Node node8 = new Node(8);
        Node node7 = new Node(7);
        Node node6 = new Node(6);
        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node1 = new Node(1);

        list.add(node20);
        list.add(node19);
        list.add(node18);
        list.add(node17);
        list.add(node16);
        list.add(node15);
        list.add(node14);
        list.add(node13);
        list.add(node12);
        list.add(node11);
        list.add(node10);
        list.add(node9);
        list.add(node8);
        list.add(node7);
        list.add(node6);
        list.add(node5);
        list.add(node4);
        list.add(node3);
        list.add(node2);
        list.add(node1);
        
        list.printList();
        System.out.println();
        list.deleteMiddleNode(node10);
        System.out.println();
        list.printList();
    }
}
