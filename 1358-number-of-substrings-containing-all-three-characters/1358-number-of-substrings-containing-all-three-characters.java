class Solution {
    public int numberOfSubstrings(String s) {
        int[] c = new int[3];
        int l = 0, r = 0, n = s.length(), a = 0;
        while (r < n) {
            c[s.charAt(r) - 'a']++;
            while (c[0] > 0 && c[1] > 0 && c[2] > 0) {
                a += n - r;
                c[s.charAt(l++) - 'a']--;
            }
            r++;
        }
        return a;
    }
}
