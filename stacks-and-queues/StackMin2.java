/*
Design a stack which has push, pop, and min that all operate in O(1) time.
Use an additional stack to keep track of the mins.
More space efficient (do not have to keep track of the min for every single elt).
*/

import java.util.Stack;
public class StackWithMin extends Stack<Integer> {
  Stack<Integer> s2;
  public StackWithMin() {
    s2 = new Stack<Integer>();
  }
  
  public void push(int val) {
    if (val <= min()) s2.push(val);
    super.push(val);
  }
  
  public Integer pop() {
    int val = super.pop();
    if (val == min()) s2.pop();
    return val;
  }
  
  public int min() {
    if (s2.isEmpty()) return Integer.MAX_VALUE;
    return s2.peek();
  }
}
