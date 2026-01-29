/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head,int k){
        ListNode d=new ListNode(0),p=d;
        d.next=head;
        ListNode c=head;
        int i=0;
        while(c!=null){
            i++;
            if(i%k==0){
                p=rev(p,c.next);
                c=p.next;
            } else c=c.next;
        }
        return d.next;
    }
    ListNode rev(ListNode prev,ListNode nxt){
        ListNode last=prev.next,c=last;
        while(c.next!=nxt){
            ListNode t=c.next;
            c.next = t.next;
            t.next=prev.next;
            prev.next=t;
        }
        return last;
    }
}
