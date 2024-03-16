package ci583.labs.lists;

/**
 * A set implemented as linked list.
 */

public class SortedList extends LinkedList {

    public void insert (int data) {
        Node n = new Node(data);
        Node prev = null;
        Node current = _head;
        if (current == null) {
            _head = n;
            return;
        } else if (current.data > n.data) {
            n.next = current;
            _head = n;
            return;
        }
        while (current != null) {
            if(current.data > n.data) {
                n.next = current;
                prev.next = n;
            }
            prev = current;
            current = current.next;
        }
    }

}
