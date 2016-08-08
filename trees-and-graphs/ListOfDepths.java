/* 
Given a binary tree, create a linked list of all the nodes at each depth.
If you have a tree with depth D, you'll have D linked lists.

1. pre-order traversal + pass in lv + 1 to next recursive call: ensure that we know which lv we're on.
2. ArrayList: resizable array, add(E), size(), get(index).
3. public method: create arr, call helper(node, arr, lv) -- modify arr, return arr. 
4. Use size() == lv to check if list has been created. 
*/

ArrayList<LinkedList<Node>> getList(Node root) {
  ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
  getList(root, lists, 0);
  return lists;
}

void getList(Node root, ArrayList<LinkedList<Node>> lists, int lv) {
  if (root == null) return;
  
  LinkedList<Node> list = null;
  if (lists.size() == lv) { // lv not contained in list
    list = new LinkedList<Node>();
    lists.add(list);
  } else {
    list = lists.get(lv);
  }
  
  list.add(root);
  getList(root.left, lists, lv + 1);
  getList(root.right, lists, lv + 1);
}
