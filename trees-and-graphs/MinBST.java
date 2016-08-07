/*
Given a sorted (increasing order) arr w unique int elts, create a bst w min height.
1. Create helper that takes in extra params (start, end). Call helper from public method.
2. Base case: use start, end (a won't change). Return null (Node) when subsection has 0 elts. 
3. Recurse: create new Node(mid), pass a subsection(left, right) of a using start, end.
*/

Node minBST(int[] a) {
  return minBST(a, 0, a.length - 1);
}

Node minBST(int[] a, int start, int end) {
  if (end < start) return null;
  
  int mid = (start + end) / 2;
  Node n = new Node(a[mid]);
  
  n.left = minBST(a, start, mid - 1);
  n.right = minBST(a, mid + 1, end);
  
  return n;
}
