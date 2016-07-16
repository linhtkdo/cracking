/*
If an elt in an m x n matrix is 0, its entire row and col are set to 0.
Space: O(N)
*/

void setZeros(int[][] a) {
    
    // keep track of all rows and cols with zeros
    boolean[] row = new boolean[a.length];
    boolean[] col = new boolean[a[0].length];
    
    for (int i = 0; i < a.length; i++)
        for (int j = 0; j < a[0].length; j++)
            if (a[i][j] == 0) {
                row[i] = true;
                col[j] = true;
            }
    
    // nullify rows and cols
    for (int i = 0; i < row.length; i++)
        if (row[i]) nullifyRow(a, i);
    
    // same as prev block, but using col
}

void nullifyRow(int[][] a, int row) {
    for (int j = 0; j < a[0].length; j++)
        a[row][j] = 0;
}

// same as prev block, but using col
