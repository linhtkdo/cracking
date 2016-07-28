/*
SetOfStacks creates a new stack once the prev one exceeds cap.
Follow up:  popAt(int index) *later*.
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
}


