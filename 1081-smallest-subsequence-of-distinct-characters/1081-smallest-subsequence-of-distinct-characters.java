class Solution {
    public String smallestSubsequence(String s) {
        int[] last = new int[26];
        boolean[] vis = new boolean[26];
        char[] st = new char[26];
        int top = -1;

        for (int i = 0; i < s.length(); i++)
            last[s.charAt(i) - 'a'] = i;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int x = c - 'a';
            if (vis[x]) continue;

            while (top >= 0 && st[top] > c && last[st[top] - 'a'] > i)
                vis[st[top--] - 'a'] = false;

            st[++top] = c;
            vis[x] = true;
        }

        return new String(st, 0, top + 1);
    }
}