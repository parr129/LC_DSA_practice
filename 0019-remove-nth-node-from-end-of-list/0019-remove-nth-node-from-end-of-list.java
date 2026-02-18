class Solution {
    public ListNode removeNthFromEnd(ListNode h, int n) {
        ListNode d = new ListNode(0), f = d, s = d;
        d.next = h;
        for (int i = 0; i <= n; i++) f = f.next;
        while (f != null) {
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;
        return d.next;
    }
}
