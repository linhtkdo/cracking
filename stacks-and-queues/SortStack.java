/* 
Smallest items are on the top. 
Can use an additional temporary stack, but may not copy the elts into any other DS (arr).
1. Modify s instead of return new stack or change pointer.
2. Use isEmpty before any pop/ peek.
3. Use 2 stacks to reverse order (biggest vs smallest/ oldest vs newest on top).
4. Look out for redundant code (don't need code for push back the bigger elts: still pop from s and push to r).
*/

void sort (Stack<Integer> s) {
  Stack<Integer> r = new Stack<Integer>();
  while (!s.isEmpty()) {
    // insert each elt in s in order into r
    int tmp = s.pop();
    // find the right place in r to insert tmp; use s as additional storage
    while (!r.isEmpty() && r.peek() > tmp) s.push(r.pop());
    r.push(tmp);
    // copy bigger elts from s back into r: repeat the same steps (inner while loop won't run)
  }
  // copy elts from r(biggest on top) back into s(smallest on top)
  while (!r.isEmpty()) s.push(r.pop());
}
