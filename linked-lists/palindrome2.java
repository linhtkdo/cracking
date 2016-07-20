/* 
Iterative Approach: 
We want to detect if the front half is the reverse of sec half.
*/

boolean isPalindrome(Node head) {
  Node fast = head;
  Node slow = head;
  
  Stack<Integer> stack = new Stack<Integer>();
  
  // iterate thru first half, push elt onto stack -> reverse first half
  // when fast (2x speed) reaches end, slow will be at mid
  while (fast != null && fast.next != null) {
    stack.push(slow.data);
    slow = slow.next;
    fast = fast.next.next;
  }
  
  // odd len: skip mid
  if (fast != null) slow = slow.next;
  
  // iterate thru sec half and compare to stack
  while (slow != null) {
    int top = stack.pop().intValue();
    if (top != slow.data) return false;
    slow = slow.next;
  }
  return true;
}
