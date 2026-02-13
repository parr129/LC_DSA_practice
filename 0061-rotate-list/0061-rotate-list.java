class Solution {
    public ListNode rotateRight(ListNode h, int k) {
        if (h == null || h.next == null) return h;

        int n = 1;
        ListNode t = h;
        while (t.next != null) {
            t = t.next;
            n++;
        }

        k %= n;
        if (k == 0) return h;

        t.next = h;
        int s = n - k;
        ListNode p = t;

        while (s-- > 0) p = p.next;

        ListNode r = p.next;
        p.next = null;
        return r;
    }
}
