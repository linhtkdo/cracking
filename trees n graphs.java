public class MaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq;
    private int N;
    
    public MaxPQ(int capacity)
    {   pq = (Key[]) new Comparable[capacity+1];    }
    
    // PQ ops
    public boolean isEmpty()
    {   return N == 0;  }
    
    public void insert(Key x)   // O(log n)
    {
        pq[++N] = x;    // add node at end
        swim(N);        // swim it up
    }
    
    public Key delMax()         // O(log n)     
    {
        Key max = pq[1];
        exch(1, N--);   // exchange root with node at end
        sink(1);        // sink it down
        pq[N+1] = null; // remove max node from heap
        return max;
    }
    
    // heap helper fxn
    private void swim(int k) 
    {
        while (k > 1 && less(k/2, k)) // parent of node at k is at k/2
        {
            exch(k, k/2);
            k = k/2;
        }
    }
    
    private void sink(int k) 
    {
        while (2*k <= N)
        {
            int j = 2*k;
            if (j < N && less (j, j+1)) j++; //children of node at k are 2k and 2k+1; find the larger child
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    
    // arr helper fxn
    private boolean less (int i, int j)
    {   return pq[i].compareTo(pq[j]) < 0;  }
    private void exch(int i, int j)
    {   Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;    }
    
}

public class BST<Key extends Comparable<Key>, Value>
{
    private Node root;
    
    private class Node
    {
        private Key key;
        private Value val;
        private Node left, right;
        public Node(Key key, Value val)
        {
            this.key = key;
            this.val = val;
        }
    }
    
    // inorder traversal of a BST yields keys in ascending order
    public void inorder(Node x)
    {
        if (x == null) return;
        inorder(x.left);
        visit(x);
        inorder(x.right);
    }
}

public class Graph
{
    // adj lists (using Bag data type)
    private final int V;
    private Bag<Integer>[] adj; 
    
    // create empty graph with V vertices
    public Graph(int V)
    {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }
    
    // add edge v-w
    public void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }
    
    
}

public class DepthFirstPaths
{
    // preferred if we want to visit every node in the graph
    
    private boolean[] marked;   // marked[v] = is there an s-v path?
    private int[] edgeTo;       // edgeTo[v] = last edge on s-v path
    private int s;              // source vertex
    
    // Computes a path between s and every other vertex in graph G
    public DepthFirstPaths(Graph G, int s)
    {
        this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        dfs(G, s);
    }
    
    // depth first search from v
    private void dfs(Graph G, int v)
    {
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w])
            {
                dfs(G, w);
                edgeTo[w] = v;
            }
    }
}

public class BreathFirstPaths
{
    private boolean[] marked;
    ...
    private void bfs(Graph G, int s)
    {
        Queue<Integer> q = new Queue<Integer>();    // init FIFO queue of vertices to explore
        q.enqueue(s);                               // add to end of queue
        marked[s] = true;
        
        while (!q.isEmpty())
        {
            int v = q.dequeue();                    // remove from front of queue
            visit(v);
            for (int w : G.adj(v))
                if (!marked[w]) 
                { 
                    q.enqueue(w); 
                    marked[w] = true; 
                }
        }
    }
}