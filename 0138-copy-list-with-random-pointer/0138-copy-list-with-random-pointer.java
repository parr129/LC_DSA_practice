class Solution {
    public Node copyRandomList(Node h) {
        if (h == null) return null;

        Map<Node, Node> m = new HashMap<>();
        Node t = h;

        while (t != null) {
            m.put(t, new Node(t.val));
            t = t.next;
        }

        t = h;
        while (t != null) {
            m.get(t).next = m.get(t.next);
            m.get(t).random = m.get(t.random);
            t = t.next;
        }

        return m.get(h);
    }
}
