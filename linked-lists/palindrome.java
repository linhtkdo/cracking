/* Reverse and Compare */

boolean isPalindrome(Node head) {
  Node rev = reverse(head);
  return isEqual(head, rev);
}

Node reverse(Node node) {
  Node head = null;
  while (node != null) {
    Node n = new Node(node.data); // clone
    n.next = head;
    head = n;
    node = node.next;
  }
  return head;
}

boolean isEqual(Node one, Node two) {
  while (one != null && two != null) {
    if (one.data != two.data) return false;
    one = one.next;
    two = two.next;
  }
  return one == null && two == null;
}
