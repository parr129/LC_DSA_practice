/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] a){
        if(a==null||a.length==0)return null;
        return div(a,0,a.length-1);
    }
    ListNode div(ListNode[] a,int l,int r){
        if(l==r)return a[l];
        int m=(l+r)/2;
        return m+1>r?div(a,l,m):merge(div(a,l,m),div(a,m+1,r));
    }
    ListNode merge(ListNode l, ListNode r){
        ListNode d=new ListNode(0),c=d;
        while(l!=null&&r!=null){
            if(l.val<=r.val){c.next=l;l=l.next;}
            else {c.next=r;r=r.next;}
            c=c.next;
        }
        c.next = l!=null?l:r;
        return d.next;
    }
}
