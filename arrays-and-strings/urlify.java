/*
Replace all spaces in a string with '%20'. 
Assume the str has sufficient space at the end to hold the additional chars.

In:     "Mr John Smith    ", 13
Out:    "Mr%20John%20Smith"
*/

void replaceSpaces(char[] str, int len)
{
    // count number of spaces
    int count = 0;
    for (int i = 0; i < len; i++)
        if (str[i] == ' ') count++;
    
    // compute extra chars we will have in the final string
    int index = len + count * 2;
    if (len < str.length) str[len] = '\0';  // end arr
    
    // edit string: start from end (extra buffer at end, change chars without overwriting)
    for (int i = len-1; i >= 0; i--)
    {
        if (str[i] == ' ')
        {
            str[index - 1] = '0';
            str[index - 2] = '2';
            str[index - 3] = '%';
            index = index - 3;
        } 
        
        else str[--index] = str[i];
    }
}
    
