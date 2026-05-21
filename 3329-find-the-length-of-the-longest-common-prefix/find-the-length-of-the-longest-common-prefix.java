class Solution {
    public int longestCommonPrefix(int[] a, int[] b) {
        Set<Integer> s = new HashSet<>();
        for (int x : a) {
            while (x > 0) {
                s.add(x);
                x /= 10;
            }
        }
        int ans = 0;
        for (int x : b) {
            while (x > 0) {
                if (s.contains(x)) {
                    ans = Math.max(ans, (int)Math.log10(x) + 1);
                    break;
                }
                x /= 10;
            }
        }
        return ans;
    }
}