import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> r = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return r;
        f(s, 0, 0, new StringBuilder(), r);
        return r;
    }

    void f(String s, int i, int p, StringBuilder b, List<String> r) {
        if (p == 4) {
            if (i == s.length()) r.add(b.toString());
            return;
        }
        for (int l = 1; l <= 3; l++) {
            if (i + l > s.length()) break;
            String x = s.substring(i, i + l);
            if (x.length() > 1 && x.charAt(0) == '0') continue;
            int v = Integer.parseInt(x);
            if (v > 255) continue;

            int t = b.length();
            if (p > 0) b.append('.');
            b.append(x);

            f(s, i + l, p + 1, b, r);

            b.setLength(t);
        }
    }
}
