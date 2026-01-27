class Solution {
    public Node connect(Node r) {
        if(r==null)return r;
        Node l=r;
        while(l.left!=null){
            Node h=l;
            while(h!=null){
                h.left.next=h.right;
                if(h.next!=null)h.right.next=h.next.left;
                h=h.next;
            }
            l=l.left;
        }
        return r;
    }
}
