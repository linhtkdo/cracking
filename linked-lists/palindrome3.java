/* Recursive Approach */

class Result {
  public Node node;
  public boolean result;
}

boolean isPalindrome(Node head) {
  int len = length(head);
  Result p = helper(head, len);
  return p.result;
}

Result helper(Node head, int len) {
  if (head == null ||)
}

