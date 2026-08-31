class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1, prev = -1, min = Integer.MAX_VALUE;
        int pos = 1;
        ListNode a = head, b = head.next;

        while (b != null && b.next != null) {
            if ((b.val > a.val && b.val > b.next.val) ||
                (b.val < a.val && b.val < b.next.val)) {

                if (first != -1) {
                    min = Math.min(min, pos - prev);
                }

                if (first == -1) {
                    first = pos;
                }

                prev = pos;
            }

            a = b;
            b = b.next;
            pos++;
        }

        if (first == -1 || first == prev) {
            return new int[]{-1, -1};
        }

        return new int[]{min, prev - first};
    }
}