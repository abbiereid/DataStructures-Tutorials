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

    //union needs to add all elements of the other set to this set
    public Set union(Set s2) {
        Set s1 = this; //get the current set, (a copy of it)
        Node n = s2._head; //get the first element of passed through set
        while (n != null) { //whilst not at the end of the set
            if(!s1.member(n.data)) { //if the element is not already in the current set
                s1.insert(n.data);//add it to the current set
            }
            n = n.next; //if not, move on
        }
        return s1;
    }

    //intersection needs to return a set of all elements that are in both sets

    public Set intersection(Set s2) {
        Set set = new Set(); //create a new set to store the intersection
        Node n = s2._head; //get the first element of passed through set
        while (n != null) { //whilst not at the end of the set
            if(this.member(n.data)) { //if the element is not already in the current set
                set.insert(n.data);//add it to the current set
            }
            n = n.next; //if not, move on
        }
        return set;
    }

    public Set difference(Set s2) {
        Set set = new Set(); //create a new set to store the difference
        Node n = _head; //get the first element of passed through set
        while (n != null) { //whilst not at the end of the set
            if(!s2.member(n.data)) { //if the element is not already in the current set
                set.insert(n.data);//add it to the current set
            }
            n = n.next; //if not, move on
        }
        return set;
    }
}
