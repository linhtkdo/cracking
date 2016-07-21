/*
3 -> 1 -> 5 -> 9 \
                    7 -> 2 -> 1
          4 -> 6 /
Time: O(A + B) | Space: O(1)
*/

Node intersection(Node l1, Node l2) {
  if (l1 == null || l2 == null) return null;
  
  // get tail and len
  Result res1 = tailAndLen(l1);
  Result res2 = tailAndLen(l2);
  
  // diff tails: no intersection
  if (res1.tail != res2.tail) return null;
  
  // set pointers to start of each list
  Node shorter = res1.len < res2.len ? l1 : l2;
  Node longer = res1.len < res.len ? l2 : l1;
  
  // advance pointer for longer
  longer = advance(longer, Math.abs(res1.len - res2.len));
  
  // traverse each list until pointers are same
  while (shorter != longer) {
    shorter = shorter.next;
    longer = longer.next;
  }
  
  return longer;
}

class Result {
  public Node tail;
  public int len;
  public Result(Node tail, int len) {
    this.tail = tail;
    this.len = len;
  }
}

Result tailAndLen(Node l) {
  if (l == null) return null;
  int len = 1;
  Node curr = l;
  while (curr.next != null) {
    len++;
    curr = curr.next;
  }
  return new Result(curr, len);
}

Node advance(Node head, int n) {
  Node curr = head;
  while (n > 0 && curr != null) {
    curr = curr.next;
    n--;
  }
  return curr;
}
