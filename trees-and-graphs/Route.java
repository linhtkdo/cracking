/* 
Given a directed graph, find out whether there is a route btw 2 nodes.
1. Enum types enable for a variable (state) to be a set of predefined constants (3 states).
2. Graph method: getNodes(). Node method: getAdjacent().
3. Use LinkedList for queue.
4. Special case (start==end) -> terminate at start. 
*/

enum State { Unvisited, Visited, Visiting; } // mark

boolean search(Graph g, Node start, Node end) {
  if (start == end) return true;
  LinkedList<Node> q = new LinkedList<Node>();
  for (Node u : g.getNodes()) u.state = State.Unvisited;
  
  start.state = State.Visiting;
  q.add(start);
  
  while (!q.isEmpty()) {
    Node u = q.removeFirst();               // dequeue
    for (Node v : u.getAdjacent())          // add and mark all adj
      if (v.state == State.Unvisited) {
        if (v == end) return true;          // check
        v.state = State.Visiting;
        q.add(v);
      }
    u.state = State.Visited;
  }
  
  return false;
}

