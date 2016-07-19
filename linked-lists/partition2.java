/*
All nodes less than x come before all nodes greater than or equal to x.
If x is contained within list, x only need to be after elts less than x.
In:   5,  3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
Out:      3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
*/

partition(Node n, int x) {
    // start a new list using existing nodes
    Node head = n;
    NOde tail = n;
    
    // put nodes less than x at head, >= x put at tail. update head/tail each time
    while (n != null) {
        Node next = n.next;
        if (n.data < x) {
            n.next = head;
            head = n;
        } else {
            tail.next = n;
            tail = n;
        }
        n = next;
    }
    tail.next = null;
    return head;
}
