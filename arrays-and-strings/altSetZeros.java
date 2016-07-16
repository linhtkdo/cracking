/*
If an elt in an m x n matrix is 0, its entire row and col are set to 0.
Space: O(1)
*/

void setZeros(int[][] a) {
    // Use first row and first col as replacements for row arr and col arr
    
    // Check if first row and first col have zero (nullify later if necessary)
    boolean rowHasZero = false;
    boolean colHasZero = false;
    for (int j = 0; j < a[0].length; j++)
        if (a[0][j] == 0) {
            rowHasZero = true;
            break;
        }
    
    for (int i = 0; i < a.length; i++)
        if (a[i][0] == 0) {
            colHasZero = true;
            break;
        }
    
    // Keep track of zeros for rest of arr
    for (int i = 1; i < a.length; i++)
        for (int j = 1; j < a[0].length; j++)
            if (a[i][j] == 0) {
                a[i][0] = 0;
                a[0][j] = 0;
            }
    
    // Nullify rows based on vals in first col
    for (int i = 1; i < a.length; i++)
        if (a[i][0] == 0) nullifyRow(a, i);
    
    // Nullify cols based on vals in first row
    for (int j = 1; j < a[0].length; j++)
        if (a[0][j] == 0) nullifyCol(a, j);
    
    // Nullify first row
    if (rowHasZero) nullifyRow(a, 0);
    
    // Nullify first col
    if (colHasZero) nullifyCol(a, 0);
}
