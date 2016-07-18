/*
k = 1 would return the last elt, k = 2 the sec to last, and so on.
Iterative:
Space: O(1) | Time: O(n)
*/

Node kthToLast(Node head, int k) {
    // Put p2 at the beginning
    Node p1 = head;
    Node p2 = head;
    
    // Move p1 k nodes into list 
    for (int i = 0; i < k; i++) {
        if (p1 == null) return null; // out of bounds
        p1 = p1.next;
    }
    // p1 will hit end of list after (len-k) steps. p2 will be k nodes from end
    while (p1 != null) {
        p1 = p1.next;
        p2 = p2.next;
    }
    return p2;
}
