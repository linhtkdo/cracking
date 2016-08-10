/* 
Given a binary tree, create a linked list of all the nodes at each depth.
If you have a tree with depth D, you'll have D linked lists.

1. modification of bfs: iterate thru root first, then lv2, lv3, etc.
2. look at all adj nodes --> look at all children of lv(i-1).
*/

ArrayList<LinkedList<Node>> getList(Node root) {
  ArrayList<LinkedList<Node>> res = new ArrayList<LinkedList<Node>>();
  LinkedList<Node> cur = new LinkedList<Node>();
  if (root != null) cur.add(root);
  
  while (cur.size() > 0) {
    res.add(cur); 
    LinkedList<Node> parents = cur;
    cur = new LinkedList<Node>();
    
    for (Node parent : parents) {
      if (parent.left != null) cur.add(parent.left);
      if (parent.right != null) cur.add(parent.right);
    }
  }
  
  return res;
}
