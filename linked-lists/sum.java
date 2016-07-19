/*
In:     (7 -> 1 -> 6) + (5 -> 9 -> 2)   617 + 295
Out:     2 -> 1 -> 9                    912

In:     (1 -> 5 -> 9) + (2 -> 3 -> 6 -> 7)
Out:     3 -> 8 -> 5 -> 8
*/

Node add(l1, l2, int carry) {
    if (l1 == null && l2 == null && carry == 0) return null;
    
    // add l1 node and l2 node (and carry)
    Node result = new Node();
    int val = carry;
    if (l1 != null) val += l1.data;
    if (l2 != null) val += l2.data;
    result.data = val % 10 // record second digit of number 
    
    // recursive stack: node vals in sum list
    // go back up: current.next = lower level
    if (l1 != null || l2 != null) {
        Node more = add(l1 == null ? null : l1.next,    // one list may be shorter than another
                        l2 == null ? null : l2.next,    // don't want null pointer exception
                        val >= 10 ? 1 : 0);             // carry excess data to next node
        result.setNext(more);
    }
    return result;
}
