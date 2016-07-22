/* 
Use a single arr to implement 3 stacks.
Fixed Division: [0, n/3) | [n/3, 2n/3) | [2n/3, n).
*/

class MultiStack {
  private int count = 3;
  private int capacity;
  private int[] vals;
  private int[] sizes;
  
  public MultiStack(int cap) {
    capacity = cap;
    vals = new int[cap * count];
    sizes = new int[count];
  }
  
  public void push(int s, int val) throws FullStackException {
    // check that we have space 
    if (isFull(s)) throw new FullStackException();
    // increment stack pointer and update top
    sizes[s]++;
    vals[getTopIn(s)] = val;
  }
  
  public int pop(int s) {
    if (isEmpty(s)) throw new EmptyStackException();
    
    int top = getTopIn(s);
    int val = vals[top];  // get top
    vals[top] = 0;        // clear
    sizes[s]--;           // shrink
    return val;
  }
  
  public int peek(int s) {
    if (isEmpty(s)) throw new EmptyStackException();
    return vals[getTopIn(s)];
  }
  
  public boolean isEmpty(s) {
    return sizes[s] == 0;
  }
  
  public boolean isFull(int s) {
    return sizes[s] == capacity;
  }
  
  private int getTopIn(int s) {
    int offset = s * capacity;
    int size = sizes[s];
    return offset + size - 1;
  }
}

