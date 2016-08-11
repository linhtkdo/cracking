/*
Check if a binary tree is balanced. 
A balanced tree is a tree st the heights of the 2 subtrees of any node never differ by more than 1. 

Recursion
Post order traversal technique
Travel all the way down to leaf nodes and then go up.
while going up, calculate the left and right subtree height.
If the difference between them is greater than 1, return –1.
Else Max(leftHeight, rightHeight) +1 .
Store the height at each level and when you go one level up, you add one to it.
Time complexity O(N) | space com­plex­ity O(h) where h is the height of the tree.
*/

boolean isBalanced(Node root) {
  return helper(root) > 0;
}

int helper(Node root) {
  if (root == null) return 0;
  
  int leftH = helper(root.left);
  if (leftH == -1) return -1;
  
  int rightH = helper(root.right);
  if (rightH == -1) return -1;
  
  int diff = leftH - rightH;
  if (Math.abs(diff) > 1) return -1;
  return 1 + Math.max(leftH, rightH);
}
