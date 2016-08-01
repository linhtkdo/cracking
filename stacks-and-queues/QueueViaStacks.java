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
}
