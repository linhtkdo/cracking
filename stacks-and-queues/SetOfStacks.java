/*
SetOfStacks creates a new stack once the prev one exceeds cap.
Follow up:  popAt(int index) on a specific substack.
*/

import java.util.ArrayList;
import java.util.EmptyStackException;

class SetOfStacks {
  ArrayList<Stack> stacks = new ArrayList<Stack>();
  public int cap;
  public SetOfStacks(int cap) {
    this.cap = cap;
  }
  
  public Stack getLastStack() {
    if (stacks.size() == 0) return null;
    return stacks.get(stacks.size() - 1);
  }
  
  public void push(int v) {
    // add to last stack
    Stack last = getLastStack();
    if (last != null && !last.isFull()) last.push(v);
    // if at cap: must create new stack
    else {
      Stack s = new Stack(cap);
      s.push(v);
      stacks.add(s);
    }
  }
  
  public int pop() {
    // operate on last stack
    Stack last = getLastStack();
    if (last == null) throw new EmptyStackException();
    int v = last.pop();
    // if empty after pop: remove from list of stacks
    if (last.size == 0) stacks.remove(stacks.size() - 1);
    return v;
  }
  
  public boolean isEmpty() {
    Stack last = getLastStack();
    return last == null || last.isEmpty();
  }
  
  public int popAt(int i) {
    return leftShift(i, true);
  }
  
  // If we pop an elt from s1, we need to remove the bottom of s2 and push it onto s1.
  // We then rollover from s3 to s2, etc.
  public int leftShift(int i, boolean flag) {
    Stack s = stacks.get(i);
    
    int x;
    if (flag) x = s.pop();
    else x = s.bottom();
    
    if (s.isEmpty()) stacks.remove(i);
    else if (stacks.size() > i + 1) {   // end at last stack
      int v = leftShift(i + 1, false);  // recurse to collect bottoms
      s.push(v);                        // go up and push to curr stack
    }
    
    return x;
  }
}


