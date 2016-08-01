/*
Implement a queue using 2 stacks.
*/

public class MyQueue<T> {
  Stack<T> s1, s2;
  
  public MyQueue() {
    s1 = new Stack<T>();
    s2 = new Stack<T>();
  }
  
  public int size() {
    return s1.size() + s2.size();
  }
  
  // push onto stackNewest
  public void add(T val) {
    s1.push(val);
  }
  
  // use Stack API to check if stackOldest is empty; 
  // then transfer all elts from stackNewest into stackOldest 
  private void shiftStacks() {
    if (s2.isEmpty())
      while (!s1.isEmpty()) s2.push(s1.pop());
  }
  
  // dequeue from stackOldest
  public T peek() {
    shiftStacks(); // ensure s1 has the curr elts
    return s2.peek();
  }
  
  public T remove() {
    shiftStacks();
    return s2.pop();
  }
}
