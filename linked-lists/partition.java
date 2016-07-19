/*
All nodes less than x come before all nodes greater than or equal to x.
If x is contained within list, x only need to be after elts less than x.

In:   5,  3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
Out:      3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
*/

Node partition(Node n, int x) {
    // Insert elts less than x into before list and >= x into after list
    Node beforeStart = null;
    Node beforeEnd = null;
    Node afterStart = null;
    Node afterEnd = null;
    
    while (n != null) {
        Node next = n.next; // save next node to iterate next
        n.next = null;
        if (n.data < x) {   // insert n into end of before list
            if (beforeStart == null) {
                beforeStart = n;
                beforeEnd = beforeStart;
            } else {
                beforeEnd.next = n;
                beforeEnd = n;
            }
        } else {            // insert n into end of after list
            if (afterStart == null) {
                afterStart = n;
                afterEnd = afterStart;
            } else {
                afterEnd.next = n;
                afterEnd = n;
            }
        }
        n = next;
    }
    
    if (beforeStart == null) return afterStart;
    
    // Merge before and after lists
    beforeEnd.next = afterStart;
    return beforeStart;
}
