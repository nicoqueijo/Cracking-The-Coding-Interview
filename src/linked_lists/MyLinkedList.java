package linked_lists;

/**
 *
 * @author nicoq
 */
public class MyLinkedList {

    private Node head = new Node();
    private int size = 0;

    public void add(Node node) {
        if (head.getNext() == null) {
            head.setNext(node);
        } else {
            node.setNext(head.getNext());
            head.setNext(node);
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            return;
        }
        Node temp = head.getNext();
        head.setNext(temp.getNext());
        temp.setNext(null);
        size--;
    }

    /**
     * For each element starting with the first, traverse the linked list
     * looking for another element with the same data. If found remove the
     * element and start again until reach the end of the list.
     *
     * Time complexity: (n^2)
     */
    public void removeDuplicates() {
        if (isEmpty() || size == 1) {
            return;
        }
        Node tempHead = head;
        while (tempHead != null) {
            Node current = tempHead;
            while (current.getNext() != null) {
                if (current.getNext().getData() == tempHead.getData()) {
                    current.setNext(current.getNext().getNext());
                    size--;
                } else {
                    current = current.getNext();
                }
            }
            tempHead = tempHead.getNext();
        }
    }

    public void printList() {
        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            System.out.print(temp.getData() + " ");
        }
    }

    public int getSize() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }
}
