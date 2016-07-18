/*
Delete a node in the middle.
In:     node c from 1-->5-->9-->4
Result:             1-->5-->4
*/

boolean deleteNode(Node n) {
    if (n == null || n.next == null) return false;
    Node next = n.next;
    n.data = next.data; // copy data of next node to n
    n.next = next.next; // delete next node
    return true;
}

