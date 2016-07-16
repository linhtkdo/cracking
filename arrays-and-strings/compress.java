/*
aabcccccaaa -> a2b1c5a3
If the compressed string would not become smaller, return original str.
The str has only uppercase and lower case letters (a - z).
*/

String compress(String s)
{
    // create compressed str
    StringBuilder result = new StringBuilder();
    int count = 0;
    for (int i=0; i < s.length(); i++)
    {
        count++;
        
        // append this char: end of loop or next char is diff
        if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i+1)) 
        {
            result.append(s.charAt(i));
            result.append(count);
            count = 0;
        }
    }
    
    // return the shorter of the input and the compressed
    return result.length() < s.length() ? result.toString() : s;
}
