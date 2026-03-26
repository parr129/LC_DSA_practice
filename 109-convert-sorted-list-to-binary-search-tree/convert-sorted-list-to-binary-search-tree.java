class Solution {
    public TreeNode sortedListToBST(ListNode h){
        if(h==null) return null;
        if(h.next==null) return new TreeNode(h.val);
        ListNode s=h,f=h,p=null;
        while(f!=null&&f.next!=null){
            p=s;s=s.next;f=f.next.next;
        }
        if(p!=null) p.next=null;
        TreeNode r=new TreeNode(s.val);
        r.left=(s!=h)?sortedListToBST(h):null;
        r.right=sortedListToBST(s.next);
        return r;
    }
}