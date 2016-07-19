/*
In:     (6 -> 1 -> 7) + (2 -> 9 -> 5)   617 + 295
Out:     9 -> 1 -> 2                    912

In: (1 -> 2 -> 3 -> 4) + (5 -> 6 -> 7)
*/

// Wrapper class to return both result and carry
class Partial {
    public Node sum = null;
    public int carry = 0;
}

Node add(Node l1, Node l2) {
    int len1 = length(l1);
    int len2 = length(l2);
    
    // pad the shorter list with zeros
    if (len1 < len2) l1 = pad(l1, len2 - len1);
    else l2 = pad(l2, len1 - len2);
    
    Partial p = helper(l1, l2);
    
    if (p.carry == 0) return p.sum;
    else {
        Node res = insert(p.sum, p.carry);
        return res;
    }
}

Partial helper(Node l1, Node l2) {
    if (l1 == null && l2 == null) {
        Partial p = new Partial();
        return p;
    }
    
    // recurse: go down until returns null
    // go up:   compute sum and add to head
    Partial p = helper(l1.next, l2.next);
    int val = p.carry + l1.data + l2.data;
    Node full = insert(p.sum, val % 10);
    
    // pass backwards sum so far and int carry
    p.sum = full;
    p.carry = val / 10;
    return p;
}

Node pad(Node l, int n) {
    Node head = l;
    for (int i = 0; i < n; i++) 
        head = insert(head, 0);
    return head;
}

// Insert node in front of list
Node insert(Node l, int data) {
    Node node = new Node(data);
    if (l != null) node.next = l;
    return node;
}
