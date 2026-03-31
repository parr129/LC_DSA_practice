class Solution {
    public String shortestPalindrome(String s) {
        String r = new StringBuilder(s).reverse().toString();
        String t = s + "#" + r;
        int[] l = new int[t.length()];
        for (int i = 1; i < t.length(); i++) {
            int j = l[i - 1];
            while (j > 0 && t.charAt(i) != t.charAt(j)) j = l[j - 1];
            if (t.charAt(i) == t.charAt(j)) j++;
            l[i] = j;
        }
        return r.substring(0, s.length() - l[t.length() - 1]) + s;
    }
}