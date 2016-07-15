/*  
Given a string, check if it is a permutation of a palindrome.

In:   Tact Coa
Out:  True    (taco cat, atco cta)
*/
boolean check(String s) // Time: O(n) / n = len of s
{
    int[] table = buildFrequencyTable(s);
    return checkOdd(table);
}

// check that no more than one char has an odd count (even-len: 0; odd-len: 1)
boolean checkOdd(int[] table)
{
    boolean found = false;
    for (int count : table)
        if (count % 2 == 1)
        {
            if (found) return false;
            found = true;
        }
    return true;
}

// map each char to a num: a -> 0, b -> 1, c -> 2
// case insensitive. non-letter chars map to -1
int getIndex(Character c)
{
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int val = Character.getNumericValue(c);
    
    if (a <= val && val <= z) return val - a;
    return -1;
}

// count how many times each char appears
int[] buildFrequencyTable(String s)
{
    int[] table = new int [Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
    for (char c : s.toCharArray())
    {
        int x = getCharNumber(c);
        if (x != -1) table[x]++;
    }
    return table;
}
