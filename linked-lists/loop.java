/*
Given a circular linked list, return the node at the beginning of the loop.
Def: a linked list in which a node's next pointer points to an earlier node.

A. Detect if linked list has a loop.
B. Figure out where the loop starts. 

1. Move fast 2x slow. When slow enters loop, after k steps, fast is k steps into loop. 
2. Slow is k steps behind fast, or fast is loop_size - k steps behind slow (they are in a circle).
3. Fast catches up to slow after loop_size - k turns, at k steps from loop start.
*/

Node getLoopStart(Node head) {
  Node slow = head;
  Node fast = head;
  
  // find meeting pt: k steps from the loop start
  while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow == fast) break;
  }
  
  if (fast == null || fast.next == null) return null;
  
  // move slow to head. keep fast at meeting pt. each are k steps from 
  // loop start. move them at same pace -> meet at start
  slow = head;
  while (slow != fast) {
    slow = slow.next;
    fast = fast.next;
  }
  return fast;
}
