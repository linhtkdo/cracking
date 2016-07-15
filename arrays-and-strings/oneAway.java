/*
Three types of edits: insert a char, remove a char, or replace a char.
Given 2 strings, check if they are one or zero edit away.

pale, ple   -> true
pales, pale -> true
pale, bale  -> true
pale, bae   -> false
*/

// len of str indicates which to check
boolean oneEdit(String s1, String s2)   // Time: O(n) / n = len of shorter str
{
    int len1 = s1.length(), len2 = s2.length();
    
    if (len1 == len2)       return oneReplace(s1, s2);
    if (len1 + 1 == len2)   return oneInsert(s1, s2);
    if (len1 - 1 == len2)   return oneInsert(s2, s1);
    return false;
}

// compare each char and ensure that the strings are only diff by one
// replacement: flag the difference
boolean oneReplace(String s1, String s2)
{
    boolean found = false;
    for (int i=0; i < s1.length(); i++)
        if (s1.charAt(i) != s2.charAt(i)) 
        {
            if (found) return false;    // ensure that this is the first difference found
            found = true;
        }
    return true;
}

// insertion/ removal: increments the pointer to the longer string
// check if you can insert a char into s1 to make s2
boolean oneInsert(String s1, String s2)
{
    int in1 = 0, in2 = 0;
    while (in1 < s1.length())
    {
        if (s1.charAt(in1) != s2.charAt(in2))
        {
            if (in1 != in2) return false;
            in2++;
        } else {
            in1++;
            in2++;
        }
    }
    return true;
}
