boolean isUnique(String s)  // Time: O(n) / n = len of s | Space: O(1)
{
    // assume character set is ASCII
    if (s.length() > 128) return false;
    
    // flag at index i indicates whether char i in the alphabet is contained in string
    boolean[] charSet = new boolean[128];
    
    for (int i=0; i<s.length(); i++)
    {
        int index = s.charAt(i);
        if (charSet[index]) return false;  // already found this char
        charSet[index] = true;
    }
    
    return true;
}
