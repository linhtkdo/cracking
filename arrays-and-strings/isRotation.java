/*
Assume you have a method isSubstring which checks if one word is a sub of another.
Given s1 and s2, check if s2 is a rotation of s1 using only 1 call to isSubstring.

"waterbottle", "erbottlewat" -> true.

Time: O(N) / assumes isSub runs in O(A+B)
*/

boolean isRotation(String s1, String s2) {
    // check that s1 and s2 are equal len and not empty
    int len = s1.length();
    if (len != s2.length() || len == 0) return false;
    
    // s1 = xy = wat erbottle
    // s2 = yx = erbottle wat
    // yx is sub of xyxy
    String s1s1 = s1 + s1;
    return isSubstring(s1s1, s2);
}
