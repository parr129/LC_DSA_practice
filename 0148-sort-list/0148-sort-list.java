class Solution {
    public ListNode sortList(ListNode h) {
        if (h == null || h.next == null) return h;

        ListNode s = h, f = h.next;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        ListNode m = s.next;
        s.next = null;

        ListNode l = sortList(h);
        ListNode r = sortList(m);
        return mg(l, r);
    }

    ListNode mg(ListNode a, ListNode b) {
        ListNode d = new ListNode(0), t = d;

        while (a != null && b != null) {
            if (a.val < b.val) {
                t.next = a;
                a = a.next;
            } else {
                t.next = b;
                b = b.next;
            }
            t = t.next;
        }

        t.next = (a != null) ? a : b;
        return d.next;
    }
}
