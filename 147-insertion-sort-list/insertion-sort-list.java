class Solution {
    public ListNode insertionSortList(ListNode h) {
        ListNode d=new ListNode(0),c=h;
        while(c!=null){
            ListNode p=d;
            while(p.next!=null && p.next.val<c.val) p=p.next;
            ListNode n=c.next;
            c.next=p.next;
            p.next=c;
            c=n;
        }
        return d.next;
    }
}