/*
k = 1 would return the last elt, k = 2 the sec to last, and so on.
Recursive: need to update both the node and the counter that all levels will see.
Space: O(n)
*/

// Don't return the elt
int printKthToLast(Node head, int k) {
    // hit end: pass back a counter set to 0
    if (head == null) return 0;
    // each parent call adds 1
    int i = printKthToLast(head.next, k) + 1;
    // counter = k: reached the kth to last elt
    if (i == k) System.out.println(k + "th to last node is" + head.data);
    return i;
}

// Create a wrapper class
class Index {
    public int val = 0;
}
Node kthToLast(Node head, int k) {
    Index i = new Index();
    return kthToLast(head, k, i);
}
Node kthToLast(Node head, int k, Index i) {
    if (head == null) return null;
    Node node = kthToLast(head.next, k, i);
    i.val++;
    if (i.val == k) return head;
    return node;
}
