class Solution{
    public Node connect(Node r){
        Node h=null,t=null,c=r;
        while(c!=null){
            if(c.left!=null){
                if(t!=null)t.next=c.left;else h=c.left;
                t=c.left;
            }
            if(c.right!=null){
                if(t!=null)t.next=c.right;else h=c.right;
                t=c.right;
            }
            c=c.next;
            if(c==null){c=h;h=t=null;}
        }
        return r;
    }
}