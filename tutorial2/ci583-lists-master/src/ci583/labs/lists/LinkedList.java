package ci583.labs.lists;

/**
 * A linked list storing ints. The nodes of the list are instances of the Node class.
 */
public class LinkedList {

    protected Node _head;

    public boolean isEmpty() {
        return (_head == null);
    }

    public int head() {
        if(_head == null) {
            throw new NullPointerException("Empty Collection");
        } else {
            return _head.data;
        }
    }

    public LinkedList tail() {
        if(_head == null) {
            throw new NullPointerException("Empty Collection");
        } else if (_head.next == null) {
            return null;
        } else {
            LinkedList list = new LinkedList();
            list._head = _head.next;
            return list;
        }
    }

    public int length() {
        int counter = 0;
        Node n = _head;
        while(n != null) {
            counter++;
            n = n.next;
        }
        return counter;
    }

    public void cons (int data) {
        //a method that lets you add a new item to the front of a list.
        Node n = new Node(data);
        Node temp = _head;
        _head = n;
        _head.next = temp;
    }

    public boolean member(int data) {
        Node n = _head;
        while(n != null){
            if (n.data == data) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    public int indexOf(int data) {
        int counter = 0;
        Node n = _head;
        while (n != null) {
            if (n.data == data) {
                return counter;
            }
            n = n.next;
            counter++;
        }
        return -1;
    }

    public boolean delete (int index) {
        Node n = _head;
        Node prev = null;
        int counter = 0;
        while (n != null) {
            if(counter == index) {
                if(counter == 0) {
                    _head = _head.next;
                } else {
                    prev.next = n.next;
                }
                return true;
            }
            prev = n;
            n = n.next;
            counter++;
        }
        return false;
    }

    public void printList () {
        Node n = _head;
        System.out.println(n.data);
        while (n.next != null) {
            n = n.next;
            System.out.println(n.data);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node n = _head;
        while (n != null) {
            sb.append(n.data+":");
            n = n.next;
        }
        return sb.toString();
    }
}
