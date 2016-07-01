// Stack: linked-list implementation
public class LinkedStackofStrings {
  private Node first = null;
  
  private class Node { // private inner class: access modifiers for instance var don't matter
    String item;
    Node next;
    
    public Node(String item) {
      this.item = item;
    }
  }
  
  public boolean isEmpty() {
    return first == null;
  }
  
  public void push(String item) {
    Node oldfirst = first; // save a link to the list
    first = new Node(); // create a new node for the beginning
    first.next = oldfirst; // set instance var for new node
  }
  
  public String pop() {
    if (first == null) throw new EmptyStackException();
    String item = first.item; // save item to return
    first = first.next; // delete first node
    return item; // return saved item
  }
}

// Stack: arr implementation
public class FixedCapacityStackOfStrings {
  private String[] s;
  private int N = 0;
  
  public FixedCapacityStackOfStrings(int capacity) {
    s = new String[capacity];
  }
  
  public boolean isEmpty() {
    return N == 0;
  }
  
  // s[] is storing N items 0...N-1

  public void push(String item) { // add new item at s[N]
    s[N++] = item; // N++: use to index into arr; then increment N
  }
  
  public String pop() { // remove item from s[N-1]
    return s[--N]; // --N: decrement N; then use to index into arr
  }
}

// Queue: linked-list implementation
public class LinkedQueueOfStrings {
  private Node first, last; // pointers to first node, last node
  
  private class Node {
    String item;
    Node next;
    
    public Node(String item) {
      this.item = item;
    }
  }
  
  public boolean isEmpty() {
    return first == null;
  }
  
  public void enqueue(String item) { // enqueue after last
    Node oldlast = last; // save a link to last node
    last = new Node(); // create a new node for the end
    last.next = null;
    if (isEmpty()) first = last; // for empty queue
    else oldlast.next = last; // link the new node to the end 
  }
  
  public String dequeue() { // dequeue from first, identical to pop()
    if (isEmpty()) throw new NoSuchElementException();
    String item = first.item;
    first = first.next;
    if (isEmpty()) last = null; // for empty queue
    return item;
    
  }
}
