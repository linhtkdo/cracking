void replaceSpaces(char[] str, int len)
{
    int count = 0;
    for (int i = 0; i < len; i++)
        if (str[i] == ' ') count++;
    
    int index = len + count * 2;
    if (len < str.length) str[len] = '\0'; ????
    for (int i = len-1; i >= 0; i--)
    {
        if (str[i] == ' ')
        {
            str[index - 1] = '0';
            str[index - 2] - '2';
            str[index - 3] = '%';
            index = index - 3;
        } 
        
        else str[--index] = str[i];
    }
}
    
