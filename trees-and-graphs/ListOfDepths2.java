/* 
Given a binary tree, create a linked list of all the nodes at each depth.
If you have a tree with depth D, you'll have D linked lists.

1. bfs
*/

ArrayList<LinkedList<Node>> getList(Node root) {
  ArrayList<LinkedList<Node>> res = new ArrayList<LinkedList<Node>>();
  LinkedList<Node> cur = new LinkedList<Node>();
  if (root != null) cur.add(root);
  
  while (cur.size() > 0) {
    res.add(cur); 
    LinkedList<Node> parents = cur;
    cur = new LinkedList<Node>();
    
    for 
  }
}
