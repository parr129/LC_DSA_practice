class Solution {
    int i;
    String s;
    Map<String, Deque<Integer>> m = new HashMap<>();

    public int evaluate(String expression) {
        s = expression;
        i = 0;
        return f();
    }

    int f() {
        if (s.charAt(i) != '(') {
            if (Character.isLowerCase(s.charAt(i))) return m.get(v()).peekLast();
            return n();
        }
        i++;
        int r = 0;
        if (s.startsWith("let", i)) {
            i += 4;
            List<String> vs = new ArrayList<>();
            while (true) {
                if (s.charAt(i) == '(' || s.charAt(i) == '-' || Character.isDigit(s.charAt(i))) {
                    r = f();
                    break;
                }
                String k = v();
                if (s.charAt(i) == ')') {
                    r = m.get(k).peekLast();
                    break;
                }
                vs.add(k);
                i++;
                int val = f();
                m.computeIfAbsent(k, z -> new ArrayDeque<>()).addLast(val);
                if (s.charAt(i) == ')') {
                    r = val;
                    break;
                }
                i++;
            }
            for (String k : vs) m.get(k).pollLast();
        } else if (s.startsWith("add", i)) {
            i += 4;
            int a = f();
            i++;
            int b = f();
            r = a + b;
        } else {
            i += 5;
            int a = f();
            i++;
            int b = f();
            r = a * b;
        }
        i++;
        return r;
    }

    String v() {
        int j = i;
        while (i < s.length() && s.charAt(i) != ' ' && s.charAt(i) != ')') i++;
        return s.substring(j, i);
    }

    int n() {
        int j = i;
        if (s.charAt(i) == '-') i++;
        while (i < s.length() && Character.isDigit(s.charAt(i))) i++;
        return Integer.parseInt(s.substring(j, i));
    }
}