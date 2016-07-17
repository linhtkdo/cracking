boolean permutation(String s, String t)     // Time: O(n)
{
    // assume comparison is case sensitive and white space is significant
    if (s.length() != t.length())   return false;
    
    // assume character set is ASCII
    int[] charSet = new int[128]; 
    
    // count number of each char in s
    for (int i=0; i < s.length(); i++)
    {
        int c = s.charAt(i);
        charSet[c]++;
    }
    
    // check if the 2 strings have identical char counts
    for (int i=0; i < t.length(); i++)
    {
        int c = t.charAt(i);
        charSet[c]--;
        if (charSet[c] < 0) return false;
    }
    
    return true;
}
