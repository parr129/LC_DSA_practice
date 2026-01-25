class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), st = 0, en = 0;
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l > en - st) { st = l; en = r; }
                l--; r++;
            }
            l = i; r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l > en - st) { st = l; en = r; }
                l--; r++;
            }
        }
        return s.substring(st, en + 1);
    }
}
