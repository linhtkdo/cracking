/* 
Recursive Approach 
0 ( 1 ( 2 ( 3 ) 2 ) 1 ) 0
recurse(n.next, len - 2)
*/

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
  // base case - reached middle: when len == 0 || 1
  if (head == null || len <= 0) return new Result(head, true);      // even len
  if (len == 1)                 return new Result(head.next, true); // odd len
  
  
  Result p = helper(head.next, len - 2);
  if (!p.result || p.node == null) return p; // false compare returned --> just pass up failure
  
  // go back up: compare current to returned node and return ret.next 
  p.result = (head.data == p.node.data);
  p.node = p.node.next;
  return p;
}

int length(Node n) {
  int len = 0;
  while (n != null) {
    len++;
    n = n.next;
  }
  return len;
}

