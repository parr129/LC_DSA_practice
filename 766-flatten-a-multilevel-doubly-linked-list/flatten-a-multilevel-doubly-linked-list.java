class Solution {
    public Node flatten(Node head) {
        if(head==null) return head;
        java.util.Stack<Node> st=new java.util.Stack<>();
        st.push(head);
        Node dummy=new Node(0,null,null,null),prev=dummy;

        while(!st.isEmpty()){
            Node cur=st.pop();
            prev.next=cur;
            cur.prev=prev;

            if(cur.next!=null) st.push(cur.next);
            if(cur.child!=null){
                st.push(cur.child);
                cur.child=null;
            }
            prev=cur;
        }
        dummy.next.prev=null;
        return dummy.next;
    }
}