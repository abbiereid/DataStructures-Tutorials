package ci583.labs.lists;

public class Set extends LinkedCollection {

    //order doesn't matter for set.
    public boolean equals(Object o) {
        //if the object is compared with itself then return true
        if (o == this) {
            return true;
        }
        /*
        Check if o is an instance of Set or not
        null instance of type also returns false
        */
        if (!(o instanceof Set)) {
            return false;
        }
        //typecast o to Set so that we can compare it to this
        Set s2 = (Set) o;

        //check that the two sets are the same length
        if(this.length()!= s2.length()) {
            return false;
        }

        //loop through the current set and check that every element is an element of the other set.
        Node n = _head;
        while (n != null) {
            if(!s2.member(n.data)) {
                return false;
            }
            n = n.next;
        }
        return true;
    }

    //insert just needs to check there are no duplicates
    public boolean insert(int data) {
        if(this.member(data)) {
            return false;
        } else {
            Node n = new Node(data);
            n.next = _head;
            _head = n;
            return true;
        }
    }

    //currently on step 6..

}
