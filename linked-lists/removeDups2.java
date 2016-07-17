/*
No buffer allowed
Time: O(n^2) | Space: O(1)
*/

void deleteDups(Node head) {
    // 2 pointers: current iterates thru the llist
    Node curr = head;
    while (curr != null) {
        // runner checks all subsequent nodes for dups
        Node runner = curr;
        while (runner.next != null) {
            // remove nodes that have same val as curr
            if (runner.next.data == curr.data) runner.next = runner.next.next; 
            else runner = runner.next;
        }
        curr = curr.next;
    }
}


