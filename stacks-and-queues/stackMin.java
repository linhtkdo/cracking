/* 
Design a stack which has push, pop, and min that all operate in O(1) time. 
Have each node record what the min beneath itself is. 
*/
import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin> {
  public void push(int val) {
    int newMin = Math.min(val, min());
    super.push(new NodeWithMin(val, newMin));
  }
  
  public int min() {
    if (this.isEmpty()) return Integer.MAX_VALUE; // error val
    return peek().min;
  }
}

class NodeWithMin {
  public int val;
  public int min;
  public NodeWithMin(int v, int min) {
    val = v;
    this.min = min;
  }
}
