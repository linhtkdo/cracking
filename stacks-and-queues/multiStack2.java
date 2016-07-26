public class MultiStack {
  private class Info {
    public int start, size, cap;
    public Info(int start, int cap) {
      this.start = start;
      this.cap = cap;
    }
    
    public boolean isWithinStackCap(int i) {
      if (i < 0 || i >= vals.length) return false;
      int contiguous = i < start ? i + vals.len : i;
      int end = start + cap;
      return start <= contiguous && contiguous < end;
    } 
    
    public int lastCapIn() {
      return adjustIn(start + cap - 1);
    }
    
    public int lastEltIn() {
      return adjustIn(start + size - 1);
    }
    
    public boolean isFull() { return size == cap;}
    public boolean isEmpty
  }
}
