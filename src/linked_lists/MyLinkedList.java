package linked_lists;

import java.util.HashSet;
import java.util.Stack;

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
    public void removeDupsIteratively() {
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

    public void removeDupsUsingHashTable() {
        HashSet<Integer> hashSet = new HashSet<>();
        Node temp = head;
        while (temp.getNext() != null) {
            if (!hashSet.contains(temp.getNext().getData())) {
                hashSet.add(temp.getNext().getData());
            } else {
                Node nodeToDel = temp.getNext();
                temp.setNext(temp.getNext().getNext());
                nodeToDel.setNext(null);
                size--;
            }
            temp = temp.getNext();
        }
    }

    /**
     * Positions Node runner k steps from the head. Positions Node current at
     * the head. Starts traversing the Linked List incrementing runner and
     * current by one node at a time until runner reaches the tail. Once that
     * happens current is k positions from the tail. Current is returned.
     *
     * Time complexity: O(n)
     *
     * @param k the number of positions from the tail
     * @return the node that is kth to last from the tail
     */
    public Node returnKthToLast(int k) {
        if (k >= size) {
            System.out.println("k is greater or equal to last!");
            return null;
        }
        Node current = head;
        Node runner = head;
        for (int i = 0; i < k; i++) {
            runner = runner.getNext();
        }
        while (runner.getNext() != null) {
            runner = runner.getNext();
            current = current.getNext();
        }
        return current;
    }

    /**
     * Deletes node k by copying k.next.data to k and then making k point to
     * k.next.next. Then we make k.next point to null.
     *
     * Time complexity: O(1)
     *
     * @param k the node to delete.
     */
    public void deleteMiddleNode(Node k) {
        k.setData(k.getNext().getData());
        Node temp = k.getNext();
        k.setNext(k.getNext().getNext());
        temp.setNext(null);
    }

    /**
     * Traverses the linked list and pushes each node in a stack. Then traverses
     * the list from the start again while popping each node from the stack. If
     * a node from the linked list does not match the node being popped from the
     * stack, the linked list is not a palindrome. Else the linked list and the
     * stack were both traversed and compared and all the nodes match.
     *
     * Time complexity: O(n)
     *
     * @return whether this linkedlist is a palindrome
     */
    public boolean isPalindrome() {
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while (temp.getNext() != null) {
            stack.push(temp.getNext().getData());
            temp = temp.getNext();
        }
        temp = head;
        while (temp.getNext() != null) {
            if (temp.getNext().getData() != stack.pop()) {
                return false;
            }
            temp = temp.getNext();
        }
        return true;
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
