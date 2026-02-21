class AllOne {
    class N {
        int c;
        Set<String> s = new HashSet<>();
        N p, n;
        N(int x) { c = x; }
    }

    Map<String, N> m = new HashMap<>();
    N h = new N(0), t = new N(0);

    public AllOne() {
        h.n = t;
        t.p = h;
    }

    void add(N a, N b) {
        b.n = a.n;
        b.p = a;
        a.n.p = b;
        a.n = b;
    }

    void rm(N x) {
        x.p.n = x.n;
        x.n.p = x.p;
    }

    public void inc(String k) {
        if (!m.containsKey(k)) {
            if (h.n == t || h.n.c != 1) add(h, new N(1));
            h.n.s.add(k);
            m.put(k, h.n);
        } else {
            N x = m.get(k);
            if (x.n == t || x.n.c != x.c + 1) add(x, new N(x.c + 1));
            x.n.s.add(k);
            m.put(k, x.n);
            x.s.remove(k);
            if (x.s.isEmpty()) rm(x);
        }
    }

    public void dec(String k) {
        N x = m.get(k);
        if (x.c == 1) m.remove(k);
        else {
            if (x.p == h || x.p.c != x.c - 1) add(x.p, new N(x.c - 1));
            x.p.s.add(k);
            m.put(k, x.p);
        }
        x.s.remove(k);
        if (x.s.isEmpty()) rm(x);
    }

    public String getMaxKey() {
        return t.p == h ? "" : t.p.s.iterator().next();
    }

    public String getMinKey() {
        return h.n == t ? "" : h.n.s.iterator().next();
    }
}