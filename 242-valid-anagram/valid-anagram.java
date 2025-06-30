import java.util.Arrays;
class Solution {
    public boolean isAnagram(String s, String t) {
    char[] parts = s.toCharArray();
    char[] partt = t.toCharArray();

    Arrays.sort(parts);
    Arrays.sort(partt);
    return Arrays.equals(parts, partt);

    }
}