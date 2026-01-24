class Solution {
    public int repeatedStringMatch(String a, String b) {
        String s = a;
        int c = 1;
        while (s.length() < b.length()) {
            s += a;
            c++;
        }
        if (s.contains(b)) return c;
        s += a;
        if (s.contains(b)) return c + 1;
        return -1;
    }
}
