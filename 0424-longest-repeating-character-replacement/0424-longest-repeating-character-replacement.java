class Solution {
    public int characterReplacement(String s, int k) {
        int[] f = new int[26];
        int l = 0, m = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            m = Math.max(m, ++f[s.charAt(i) - 'A']);
            if (i - l + 1 - m > k) {
                f[s.charAt(l) - 'A']--;
                l++;
            }
            r = Math.max(r, i - l + 1);
        }
        return r;
    }
}
