// 2 strings are permutations: same chars, but diff orders
// sorting will put chars from 2 permutations in same order
// just need to compare sorted versions

String sort(String s)   // Time: O(n logn)
{
    char[] content = s.toCharArray();
    java.util.Arrays.sort(content);
    return new String(content);
}

boolean permutation(String s, String t)
{
    if (s.length() != t.length()) return false;
    return sort(s).equals(sort(t));
}
