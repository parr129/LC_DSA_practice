class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length(), sg = 1;
        long r = 0;
        while (i < n && s.charAt(i) == ' ') i++;
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+'))
            sg = s.charAt(i++) == '-' ? -1 : 1;
        while (i < n && Character.isDigit(s.charAt(i))) {
            r = r * 10 + (s.charAt(i++) - '0');
            if (r * sg <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (r * sg >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        return (int) (r * sg);
    }
}
