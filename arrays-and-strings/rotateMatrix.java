/*
Rotate an n x n matrix by 90 deg. Can you do this in place?
Time:   O(n^2) -- must touch all elts
*/

boolean rotate(int[][] a) { 
    if (a.length == 0 || a.length != a[0].length) return false;
    int n = a.length;
    
    for (int layer = 0; layer < n/2; layer++) {
        int first = layer;
        int last = n - 1 - layer;
        
        for (int i = first; i < last; i++) {
            int offset = i - first; // 0, 1, 2, etc.
            int top = a[first][i];  // save top
            
            // TOP      :   [first]             [i starts at first]
            // BOTTOM   :   [last]              [i starts at last]
            // RIGHT    :   [i starts at first] [last]
            // LEFT     :   [i starts at last]  [first]
            
            a[first][i]             = a[last - offset][first];  // left -> top      
            a[last - offset][first] = a[last][last - offset];   // bottom -> left
            a[last][last - offset]  = a[i][last];               // right -> bottom
            a[i][last]              = top;                      // saved top -> right
        }
    }
    return true;
}
